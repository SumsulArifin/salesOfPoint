//package com.example.sysDevLtd.repository;
//
//import com.example.sysDevLtd.entity.request.SaleInfoDTO;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public class SaleRepositoryW {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public SaleInfoDTO getSaleInfoByInvoiceNumber(long invoiceNumber) {
//        String jpqlQuery = "SELECT s.warranty.endDate, s.customer.firstName, s.stock.product.productName " +
//                "FROM Sale s " +
//                "WHERE s.invoiceNumber = :invoiceNumber";
//
//        List<Object[]> results = entityManager.createQuery(jpqlQuery, Object[].class)
//                .setParameter("invoiceNumber", invoiceNumber)
//                .getResultList();
//
//        SaleInfoDTO saleInfoDTO = new SaleInfoDTO();
//
//        if (!results.isEmpty()) {
//            Object[] result = results.get(0);
//            LocalDate endDate = (LocalDate) result[0];
//            String customerFirstName = (String) result[1];
//            String productName = (String) result[2];
//
//            // Calculate days left based on the endDate
//            LocalDate currentDate = LocalDate.now();
//            long daysLeft = endDate.until(currentDate).getDays();
//
//            saleInfoDTO.setDaysLeft(daysLeft);
//            saleInfoDTO.setCustomerFirstName(customerFirstName);
//            saleInfoDTO.setProductName(productName);
//        }
//
//        return saleInfoDTO;
//    }
//}
//
