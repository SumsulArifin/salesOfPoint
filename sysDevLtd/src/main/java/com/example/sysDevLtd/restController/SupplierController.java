package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Product;
import com.example.sysDevLtd.entity.model.pos.Supplier;
import com.example.sysDevLtd.service.ProductService;
import com.example.sysDevLtd.service.SupplierService;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(originPatterns = {"*"})
public class SupplierController {

//    @Autowired
//    SupplierService supplierService;
//
//    @PostMapping("/save")
//    public ResponseEntity<MessageResponse> saveSupplier(@RequestBody Supplier supplier) {
//        if (supplier == null) {
//            return new ResponseEntity<>(new MessageResponse(Message.FAILED), HttpStatus.BAD_REQUEST);
//        }
//        MessageResponse response = supplierService.supplierSave(supplier);
//        if (response.getMessage() == Message.SUCCESS) {
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/getAllSupplier")
//    public ResponseEntity<List<Supplier>> getAllSupplier() {
//        List<Supplier> suppliers = supplierService.getAllSupplier();
//        return new ResponseEntity<>(suppliers, HttpStatus.OK);
//    }
//
//    @GetMapping({"/getSupplier/{id}"})
//    public Supplier getSupplier(@PathVariable("id") Long id) {
//        Supplier supplier = this.supplierService.supplierGet(id);
//        return supplier;
//    }
//
//    @DeleteMapping({"/deleteSupplier/{id}"})
//    public void deleteSupplier(@PathVariable("id") Long id) {
//        this.supplierService.supplierDelete(id);
//    }
}
