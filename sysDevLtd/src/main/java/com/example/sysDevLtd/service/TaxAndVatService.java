package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.entity.model.pos.TaxAndVat;
import com.example.sysDevLtd.repository.SupplierRepository;
import com.example.sysDevLtd.repository.TaxAndVatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxAndVatService {

    @Autowired
    TaxAndVatRepository taxAndVatRepository;


    public void TaxAndVatSave(TaxAndVat taxAndVat) {

        taxAndVatRepository.save(taxAndVat);
    }

}
