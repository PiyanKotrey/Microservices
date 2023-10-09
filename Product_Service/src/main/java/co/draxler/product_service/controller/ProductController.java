package co.draxler.product_service.controller;

import co.draxler.product_service.dto.CreateProduct;
import co.draxler.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProduct createProduct){
        productService.createProduct(createProduct);
    }

    @GetMapping
    public CollectionModel<?> findAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public EntityModel<?> findById(@PathVariable String id){
        return productService.findById(id);
    }
    @PutMapping("/{id}")
    public EntityModel<?> updateById(@PathVariable String id,@RequestBody CreateProduct createProduct){
        return productService.updateById(id, createProduct);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id){
        productService.deleteById(id);
    }
}
