package com.Spring.Boot.HMS.docLogin.controller;

import com.Spring.Boot.HMS.docLogin.entity.Billing;
import com.Spring.Boot.HMS.docLogin.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v4")
@RestController

public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    // Get all billing records
    @GetMapping("/billing")
    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    // Get a single billing record by ID
    @GetMapping("billing/id")
    public Billing getBillById(@PathVariable Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    // Create a new billing record
    @PostMapping("/billing")
    public Billing createBill(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }

    // Update an existing billing record
    @PutMapping("/billing/id")
    public Billing updateBill(@PathVariable Long id, @RequestBody Billing billing) {
        Optional<Billing> existingBill = billingRepository.findById(id);
        if (existingBill.isPresent()) {
            Billing bill = existingBill.get();
            bill.setPatientId(billing.getPatientId());
            bill.setAmount(billing.getAmount());
            bill.setStatus(billing.getStatus());
            return billingRepository.save(bill);
        }
        return null;
    }

    // Delete a billing record
    @DeleteMapping("/billing/id")
    public String deleteBill(@PathVariable Long id) {
        billingRepository.deleteById(id);
        return "Billing record with ID " + id + " deleted successfully.";
    }
}
