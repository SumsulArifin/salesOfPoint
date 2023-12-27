package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import com.example.sysDevLtd.entity.model.pos.Sale;
import com.example.sysDevLtd.entity.model.pos.Stock;
import com.example.sysDevLtd.repository.CustomerRepository;
import com.example.sysDevLtd.repository.SaleRepository;
import com.example.sysDevLtd.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleService {


    private final SaleRepository saleRepository;
    private final StockRepository stockRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, StockRepository stockRepository) {
        this.saleRepository = saleRepository;
        this.stockRepository = stockRepository;
    }

    public Sale saveSaleAndUpdateStock(Sale sale) {
        Sale savedSale = saleRepository.save(sale);

        Stock stock = savedSale.getStock();
        if (stock != null) {
            Stock existingStock = stockRepository.findById(stock.getStockId()).orElse(null);
            if (existingStock != null) {
                existingStock.setStatus(false); // Example: Setting status to false after a sale
                stockRepository.save(existingStock); // Save the updated stock entity
            }
        }
        return savedSale;
    }

    public Long findWarrantyEndDateByInvoiceNumberAndCalculateRemainingDays(long invoiceNumber) {
        Date endDate = saleRepository.findWarrantyEndDateByInvoiceNumber(invoiceNumber);

        if (endDate != null) {
            Date currentDate = new Date(); // Current date
            long remainingMilliseconds = endDate.getTime() - currentDate.getTime();
            long remainingDays = remainingMilliseconds / (1000 * 60 * 60 * 24); // Convert milliseconds to days
            return remainingDays ;
        } else {
            return null;
        }
    }


//    @Autowired
//    private SaleRepository saleRepository;
//
//    @Autowired
//    private StockRepository stockRepository;
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public Sale saveSaleAndUpdateStock(Sale sale) {
//        if (sale.getCustomer() != null) {
//            Customer customer = customerRepository.save(sale.getCustomer());
//            sale.setCustomer(customer);
//        }
//        Stock stock = sale.getStock();
//        if (stock != null) {
//            stock.setStatus(false);
//            stockRepository.save(stock);
//        }
//
//        return saleRepository.save(sale);
//    }
}
