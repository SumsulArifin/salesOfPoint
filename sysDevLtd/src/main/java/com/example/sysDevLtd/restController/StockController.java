package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin(originPatterns = {"*"})
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/stocks/{stockId}")
    public List<Object[]> getStockDetails(@PathVariable Long stockId) {
        return stockService.findProductNameProductIdAndSupplierByStockId(stockId);
    }

//    @GetMapping("/stocksCount/{stockId}")
//    public List<Object[]> getStockDetailsWithCount(@PathVariable Long stockId) {
//        return stockService.countAndFindDetailsByStockId(stockId);
//    }

    @GetMapping("/stocks/count/{productId}")
    public long countStocksByProductId(@PathVariable Long productId) {
        return stockService.countByProductId(productId);
    }

    @GetMapping("/stocks/count/product/{productName}")
    public long countStocksByProductName(@PathVariable String productName) {
        return stockService.countByProductName(productName);
    }
}
