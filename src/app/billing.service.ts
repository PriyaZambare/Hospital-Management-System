import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Billing {
  id?: number;
  patientId: number;
  amount: number;
  status: string;
}

@Injectable({
  providedIn: 'root'
})
export class BillingService {
  private baseUrl = 'http://localhost:8081/api/v4';

  constructor(private http: HttpClient) {}

  getAllBills(): Observable<Billing[]> {
    return this.http.get<Billing[]>(this.baseUrl);
  }

  addBill(bill: Billing): Observable<Billing> {
    return this.http.post<Billing>(this.baseUrl, bill);
  }
}