package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.repository.ProductDetailsRepository;
import com.example.sysDevLtd.repository.ProductRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public MessageResponse saveProduct(Product product) {
        Product product1 = new Product();
     product1.setProductName(product.getProductName());
     product1.setProductType(product.getProductType());
     product1.setOwnerNumber(product.getOwnerNumber());
     product1.setProductDetails(product.getProductDetails());
     product1.setCreatedBy(product.getCreatedBy());
        productRepository.save(product1);
        return new MessageResponse(Message.SUCCESS);
    }


}
