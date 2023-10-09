package co.draxler.product_service.service;

import co.draxler.product_service.assembler.ProductAssembler;
import co.draxler.product_service.dto.CreateProduct;
import co.draxler.product_service.dto.ProductDto;
import co.draxler.product_service.mapper.ProductMapper;
import co.draxler.product_service.model.Product;
import co.draxler.product_service.repositery.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;
    @Override
    public void createProduct(CreateProduct createProduct) {
        Product product = productMapper.mapCreateProductToProduct(createProduct);
        productRepository.save(product);
    }

    @Override
    public CollectionModel<?> findAllProduct() {
        List<Product> products = productRepository.findAll();
        return productAssembler.toCollectionModel(products);
    }

    @Override
    public EntityModel<?> findById(String id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productAssembler.toModel(product);
    }

    @Override
    public EntityModel<?> updateById(String id, CreateProduct createProduct) {
        Product product = productRepository.findById(id).orElseThrow();
        productMapper.mapForPartialUpdate(product,createProduct);
        Product product1 = productRepository.save(product);
        return productAssembler.toModel(product1);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
