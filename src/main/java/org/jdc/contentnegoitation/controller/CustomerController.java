package org.jdc.contentnegoitation.controller;

import lombok.RequiredArgsConstructor;
import org.jdc.contentnegoitation.dao.CustomerDao;
import org.jdc.contentnegoitation.entity.Customer;
import org.jdc.contentnegoitation.entity.Customers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;
    @PostMapping(value="/create-customer",consumes =
            {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Customer>
    createCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(201)
                .body(customerDao.save(customer));
    }

    @GetMapping(value="/list-customers",produces =
            { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public Customers listAllCustomers(){
        return new Customers(customerDao.findAll());
    }
    //http://localhost:8080/list-customers-v2?type=xml
    @GetMapping("/list-customers-v2")
    public ResponseEntity<Customers>
    listCustomersV2(@RequestParam String type){
        if("xml".equals(type)){
            return ResponseEntity.status(200)
                    .contentType(MediaType.APPLICATION_XML)
                    .body(new Customers(customerDao.findAll()));

        }
        else {
            return ResponseEntity.status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new Customers(customerDao.findAll()));
        }
    }
}
