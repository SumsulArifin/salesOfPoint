package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import com.example.sysDevLtd.service.ProductDetailsService;
import com.example.sysDevLtd.service.ProductService;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productDetails")
@CrossOrigin(originPatterns = {"*"})
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productDetailsService;

    @PostMapping("/save")
    public ResponseEntity<MessageResponse> saveProductDetails(@RequestBody ProductDetails productDetails) {
        if (productDetails == null) {
            return new ResponseEntity<>(new MessageResponse(Message.FAILED), HttpStatus.BAD_REQUEST);
        }
        MessageResponse response = productDetailsService.saveProductDetail(productDetails);
        if (response.getMessage() == Message.SUCCESS) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
