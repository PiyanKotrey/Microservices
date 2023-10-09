package co.draxler.product_service.service;

import co.draxler.product_service.dto.CreateProduct;
import co.draxler.product_service.dto.ProductDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface ProductService {
    void createProduct(CreateProduct createProduct);
    CollectionModel<?> findAllProduct();
    EntityModel<?> findById(String id);
    EntityModel<?> updateById(String id,CreateProduct createProduct);
    void deleteById(String id);
}
