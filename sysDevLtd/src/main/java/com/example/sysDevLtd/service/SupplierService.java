package com.example.sysDevLtd.service;

import com.example.sysDevLtd.entity.model.pos.ProductDetails;
import com.example.sysDevLtd.entity.model.pos.Supplier;
import com.example.sysDevLtd.repository.SupplierRepository;
import com.example.sysDevLtd.utils.Message;
import com.example.sysDevLtd.utils.MessageResponse;
import com.example.sysDevLtd.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
//    public MessageResponse supplierSave(Supplier supplier) {
//        if (supplier.getProductDetails() != null) {
//            ProductDetails details = productDetailsRepository.save(product.getProductDetails());
//            product.setProductDetails(details);
//        }
//        productRepository.save(product);
//        return new MessageResponse(Message.SUCCESS);
//    }



    public MessageResponse saveSupplier(Supplier supplier) {
        Supplier newSupplier = new Supplier();
        newSupplier.setSupplierName(supplier.getSupplierName());
        newSupplier.setContactPerson(supplier.getContactPerson());
        newSupplier.setEmail(supplier.getEmail());
        newSupplier.setPhoneNumber(supplier.getPhoneNumber());

        supplierRepository.save(newSupplier);
        return new MessageResponse(Message.SUCCESS);
    }


    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }


    public Supplier findSupplierById(long supplierId) {
        return supplierRepository.findById(supplierId).get();
    }

    public Optional<Supplier> updateSupplier(long supplierId, Supplier supplier) {
        Optional<Supplier> result = supplierRepository.findById(supplierId);

        if (result.isPresent()) {
            Supplier newSupplier = result.get();
            newSupplier.setSupplierName(supplier.getSupplierName());
            newSupplier.setContactPerson(supplier.getContactPerson());
            newSupplier.setEmail(supplier.getEmail());
            newSupplier.setPhoneNumber(supplier.getPhoneNumber());

            supplierRepository.save(newSupplier);
        } else {
            throw new ResourceNotFoundException("Supplier", "supplierId", supplierId);
        }

        return result;
    }





//    public Optional<Supplier> updateDepartmentStatus(int deptId, Supplier departmentDTO) {
//        Optional<Supplier> result = departmentRepository.findById(deptId);
//        if (result.isPresent()) {
//            Department department = result.get();
//            department.setActive(departmentDTO.isActive());
//            departmentRepository.save(department);
//        } else {
//            throw new ResourceNotFoundException("Department", "deptId", deptId);
//        }
//
//        return result;
//    }

}
