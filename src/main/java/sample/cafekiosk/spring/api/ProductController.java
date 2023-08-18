package sample.cafekiosk.spring.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.cafekiosk.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.cafekiosk.spring.api.service.product.ProductService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/v1/products/new")
    public ApiResponse createProduct(@Valid @RequestBody ProductCreateRequest request) {
        return ApiResponse.of(HttpStatus.OK, productService.createProduct(request));

    }

    @GetMapping("/api/v1/products/selling")
    public ApiResponse getSellingProducts() {
        return ApiResponse.ok(productService.getSellingProducts());
    }
}
