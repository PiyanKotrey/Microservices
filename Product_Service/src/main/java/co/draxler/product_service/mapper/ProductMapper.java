package co.draxler.product_service.mapper;

import co.draxler.product_service.dto.CreateProduct;
import co.draxler.product_service.dto.ProductDto;
import co.draxler.product_service.model.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product mapCreateProductToProduct(CreateProduct createProduct);
    ProductDto mapProductToProductDto(Product product);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapForPartialUpdate(@MappingTarget Product product,CreateProduct createProduct);
}
