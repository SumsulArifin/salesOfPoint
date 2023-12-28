package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Sale;
import com.example.sysDevLtd.entity.model.pos.Stock;
import com.example.sysDevLtd.entity.request.WarrantyDetailsDTO;
import com.example.sysDevLtd.repository.SaleRepository;

import com.example.sysDevLtd.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {


    private final SaleRepository saleRepository;
    private final StockRepository stockRepository;

//    @Autowired
//    SaleRepositoryW saleRepositoryW;

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

    public List<WarrantyDetailsDTO> findWarrantyDetailsByInvoiceNumber(long invoiceNumber) {
        List<Object[]> result = saleRepository.findWarrantyEndDateByInvoiceNumber(invoiceNumber);

        List<WarrantyDetailsDTO> warrantyDetailsList = new ArrayList<>();

        for (Object[] objects : result) {
            Date endDate = (Date) objects[0];
            String firstName = (String) objects[1];
            String productName = (String) objects[2];
            Date saleDate =(Date)  objects[3];

            // Calculate days left
            long daysLeft = endDate.getTime() - new Date().getTime();
            daysLeft = Math.max(daysLeft, 0) / (1000 * 60 * 60 * 24); // Convert milliseconds to days

            WarrantyDetailsDTO warrantyDetails = new WarrantyDetailsDTO(firstName, productName, saleDate, daysLeft);
            warrantyDetailsList.add(warrantyDetails);
        }

        return warrantyDetailsList;
    }

//    public void findWarrantyDetailsByInvoiceNumber(long invoiceNumber) {
//        List<Object[]> result = saleRepository.findWarrantyEndDateByInvoiceNumber(invoiceNumber);
//
//        for (Object[] objects : result) {
//            Date endDate = (Date) objects[0];
//            String customerFirstName = (String) objects[1];
//            String productName = (String) objects[2];
//
//            // Calculate days left
//            long daysLeft = endDate.getTime() - new Date().getTime();
//            daysLeft = Math.max(daysLeft, 0) / (1000 * 60 * 60 * 24); // Convert milliseconds to days
//
//            System.out.println("Customer First Name: " + customerFirstName);
//            System.out.println("Product Name: " + productName);
//            System.out.println("Days Left for Warranty: " + daysLeft);
//        }
//    }

//    public SaleInfoDTO getSaleInfoByInvoiceNumber(long invoiceNumber) {
//        return saleRepositoryW.getSaleInfoByInvoiceNumber(invoiceNumber);
//    }
//    public Long findWarrantyEndDateByInvoiceNumberAndCalculateRemainingDays(long invoiceNumber) {
//        Date endDate = saleRepository.findWarrantyEndDateByInvoiceNumber(invoiceNumber);
//
//        if (endDate != null) {
//            Date currentDate = new Date(); // Current date
//            long remainingMilliseconds = endDate.getTime() - currentDate.getTime();
//            long remainingDays = remainingMilliseconds / (1000 * 60 * 60 * 24); // Convert milliseconds to days
//            return remainingDays ;
//        } else {
//            return null;
//        }
//    }


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
