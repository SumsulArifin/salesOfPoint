package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.model.pos.Customer;
import com.example.sysDevLtd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(originPatterns = {"*"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {

        if (customer != null) {
            customerService.customerSave(customer);
        }
    }

}
