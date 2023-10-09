package co.draxler.product_service.dto;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record CreateProduct(String name,
                            String description,
                            BigDecimal price) {
}
