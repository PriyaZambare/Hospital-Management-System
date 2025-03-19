

import { Component, OnInit } from '@angular/core';
import { Billing, BillingService } from '../billing.service';


@Component({
  selector: 'app-billing',
  standalone: false,
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {
  bills: Billing[] = [];
  newBill: Billing = { patientId: 0, amount: 0, status: 'Pending' };

  constructor(private billingService: BillingService) {}

  ngOnInit(): void {
    this.loadBillingData();
  }

  loadBillingData(): void {
    this.billingService.getAllBills().subscribe(
      (response: any) => {
        this.bills = response.bills;  // Access nested "bills" array
      }
    );
  }

  addBill(): void {
    this.billingService.addBill(this.newBill).subscribe(() => {
      this.loadBillingData();
      this.newBill = { patientId: 0, amount: 0, status: 'Pending' };
    });
  }

  
}
