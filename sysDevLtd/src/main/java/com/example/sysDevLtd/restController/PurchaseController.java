package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Purchase;
import com.example.sysDevLtd.service.ProductService;
import com.example.sysDevLtd.service.PurchaseService;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@CrossOrigin(originPatterns = {"*"})
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/save")
    public ResponseEntity<MessageResponse> savePurchase(@RequestBody Purchase purchase) {
        if (purchase == null) {
            return new ResponseEntity<>(new MessageResponse(Message.FAILED), HttpStatus.BAD_REQUEST);
        }
        MessageResponse response = purchaseService.savePurchase(purchase);
        if (response.getMessage() == Message.SUCCESS) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPurchase")
    public ResponseEntity<List<Purchase>> getAllPurchase() {
        List<Purchase> purchases = purchaseService.getAllPurchase();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @GetMapping({"/getPurchase/{id}"})
    public Purchase getPurchase(@PathVariable("id") Long id) {
        Purchase purchase = this.purchaseService.purchaseGet(id);
        return purchase;
    }

    @DeleteMapping({"/deletePurchase/{id}"})
    public void deletePurchase(@PathVariable("id") Long id) {
        this.purchaseService.purchaseDelete(id);
    }
}
