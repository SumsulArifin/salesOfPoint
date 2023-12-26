package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.entity.model.pos.Sale;
import com.example.sysDevLtd.repository.CustomerRepository;
import com.example.sysDevLtd.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
@CrossOrigin(originPatterns = {"*"})
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/save")
    public ResponseEntity<Sale> saveSaleAndUpdateStock(@RequestBody Sale sale) {
        Sale savedSale = saleService.saveSaleAndUpdateStock(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }


}
