package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import com.example.sysDevLtd.repository.ProductDetailsRepository;
import com.example.sysDevLtd.repository.ProductRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {


    @Autowired
    ProductDetailsRepository productDetailsRepository;
    public MessageResponse saveProductDetail(ProductDetails productDetails) {
        productDetailsRepository.save(productDetails);
        return new MessageResponse(Message.SUCCESS);
    }
}
