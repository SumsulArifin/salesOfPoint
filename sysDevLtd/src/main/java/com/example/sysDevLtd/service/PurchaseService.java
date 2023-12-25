package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Purchase;
import com.example.sysDevLtd.entity.model.pos.Supplier;
import com.example.sysDevLtd.repository.PurchaseRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    public MessageResponse savePurchase(Purchase purchase) {
        Supplier supplier = purchase.getStock().getSupplier();
        purchaseRepository.save(purchase);
        return new MessageResponse(Message.SUCCESS);
    }

    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    public Purchase purchaseGet(Long id) {
        return this.purchaseRepository.findById(id).orElse(new Purchase());
    }

    public void purchaseDelete(Long id) {
        purchaseRepository.deleteById(id);
    }
}
