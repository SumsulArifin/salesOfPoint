package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.service.ProductService;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(originPatterns = {"*"})
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<MessageResponse> saveProduct(@RequestBody Product product) {
        if (product == null) {
            return new ResponseEntity<>(new MessageResponse(Message.FAILED), HttpStatus.BAD_REQUEST);
        }

        MessageResponse response = productService.saveProduct(product);
        if (response.getMessage() == Message.SUCCESS) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/save")
//    public ResponseEntity<MessageResponse> saveProduct(@RequestBody Product product) {
//        MessageResponse response = productService.saveProduct(product);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }



    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @GetMapping("/getAllProduct")
//    @ResponseBody
//    public ResponseEntity<List<Product>> getAllAssignDetails() {
//        List<Product> products = productService.getAllProduct();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
}
