package co.draxler.product_service.assembler;

import co.draxler.product_service.controller.ProductController;
import co.draxler.product_service.dto.ProductDto;
import co.draxler.product_service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import co.draxler.product_service.model.Product;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product,EntityModel<ProductDto>> {
    private ProductMapper productMapper;
    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @SuppressWarnings("unchecked")
    public ProductAssembler() {
        super(ProductController.class,(Class<EntityModel<ProductDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public EntityModel<ProductDto> toModel(Product entity) {
        ProductDto productDto = productMapper.mapProductToProductDto(entity);
        return EntityModel.of(productDto);
    }

    @Override
    public CollectionModel<EntityModel<ProductDto>> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }
}
