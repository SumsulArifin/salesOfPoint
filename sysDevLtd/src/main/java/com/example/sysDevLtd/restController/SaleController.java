package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Purchase;
import com.example.sysDevLtd.entity.model.pos.Sale;
import com.example.sysDevLtd.entity.model.pos.Supplier;
import com.example.sysDevLtd.entity.request.WarrantyDetailsDTO;
import com.example.sysDevLtd.repository.CustomerRepository;
import com.example.sysDevLtd.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/warranty/{invoiceNumber}")
    public List<WarrantyDetailsDTO> getWarrantyDetailsByInvoiceNumber(@PathVariable long invoiceNumber) {
        return saleService.findWarrantyDetailsByInvoiceNumber(invoiceNumber);
    }

    @GetMapping("/getAllSale")
    public ResponseEntity<List<Sale>> getAllSale() {
        List<Sale> saleList = saleService.getAllSale();
        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }

    @GetMapping("/getSaleById/{saleId}")
    public ResponseEntity<Sale> getDepartmentById(@PathVariable("saleId") long saleId) {
        Sale sale = saleService.findSaleById(saleId);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

//    @GetMapping("/warranty/{invoiceNumber}")
//    public void getWarrantyDetailsByInvoiceNumber(@PathVariable long invoiceNumber) {
//        saleService.findWarrantyDetailsByInvoiceNumber(invoiceNumber);
//    }

//    @GetMapping("/warranty/{invoiceNumber}")
//    public ResponseEntity<SaleInfoDTO> getSaleInfoByInvoiceNumber(@PathVariable long invoiceNumber) {
//        SaleInfoDTO saleInfo = saleService.getSaleInfoByInvoiceNumber(invoiceNumber);
//        if (saleInfo != null) {
//            return new ResponseEntity<>(saleInfo, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping("/warranty/{invoiceNumber}")
//    public Long getRemainingWarrantyDays(@PathVariable long invoiceNumber) {
//        return saleService.findWarrantyEndDateByInvoiceNumberAndCalculateRemainingDays(invoiceNumber);
//    }

//    @PostMapping("/save")
//    public ResponseEntity<MessageResponse> savePurchase(@RequestBody Sale sale) {
//        if (sale == null) {
//            return new ResponseEntity<>(new MessageResponse(Message.FAILED), HttpStatus.BAD_REQUEST);
//        }
//        MessageResponse response = saleService.saveSaleAndUpdateStock(sale);
//        if (response.getMessage() == Message.SUCCESS) {
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
