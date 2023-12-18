package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.service.ProductService;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(originPatterns = {"*"})
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<MessageResponse> saveProduct(@RequestBody Product product) {
        MessageResponse response = productService.saveProduct(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
