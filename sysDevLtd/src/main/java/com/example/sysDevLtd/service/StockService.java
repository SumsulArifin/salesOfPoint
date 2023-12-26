package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Purchase;
import com.example.sysDevLtd.entity.model.pos.Stock;
import com.example.sysDevLtd.repository.StockRepository;
import com.example.sysDevLtd.repository.StockRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    private final StockRepositoryImpl stockRepositoryImpl;

    @Autowired
    public StockService(StockRepositoryImpl stockRepositoryImpl) {
        this.stockRepositoryImpl = stockRepositoryImpl;
    }

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public long countByProductName(String productName) {
        return stockRepositoryImpl.countByProductName(productName);
    }
    public List<Object[]> findProductNameProductIdAndSupplierByStockId(Long stockId) {
        return stockRepository.findProductNameProductIdAndSupplierByStockId(stockId);
    }

//    public List<Object[]> countAndFindDetailsByStockId(Long stockId) {
//        return stockRepository.countAndFindDetailsByStockId(stockId);
//    }
public long countByProductId(Long productId) {
    return stockRepository.countByProductId(productId);
}


}
