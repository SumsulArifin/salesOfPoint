package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import com.example.sysDevLtd.repository.ProductDetailsRepository;
import com.example.sysDevLtd.repository.ProductRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public MessageResponse saveProduct(Product product) {
        if (product.getProductDetails() != null) {
            ProductDetails details = productDetailsRepository.save(product.getProductDetails());
            product.setProductDetails(details);
        }
        productRepository.save(product);
        return new MessageResponse(Message.SUCCESS);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product productGet(Long id) {
        return this.productRepository.findById(id).orElse(new Product());
    }

    public void productDelete(Long id) {productRepository.deleteById(id);
    }
}
