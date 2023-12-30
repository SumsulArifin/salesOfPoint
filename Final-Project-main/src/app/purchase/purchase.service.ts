import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PurchaseFormData } from './PurchaseModel';
import { Supplier } from './SupplierModel';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  private url = 'http://localhost:8080/purchase';

  private urlSupplier = 'http://localhost:8080/supplier';

  constructor(private httpService: HttpClient) {}



  savePurchase(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
  
    const requestBody = {
      purchaseDate: data.purchase.purchaseDate,
      price: data.purchase.price,
      payment: data.purchase.payment,
      discount: data.purchase.discount,
      totalAmount: data.purchase.totalAmount,
      deliveryAddress: data.purchase.deliveryAddress,
      warranty: data.purchase.warranty,
      stock: {
        quantity: data.stock.quantity,
        product: {
          productName: data.product.productName,
          productType: data.product.productType,
          model: data.product.model,
          productDetails: {
            registrationNo: data.productDetails.registrationNo,
            chassisNumber: data.productDetails.chassisNumber,
            engineNumber: data.productDetails.engineNumber,
            cubicCapacity: data.productDetails.cubicCapacity,
            noOfTyres: data.productDetails.noOfTyres,
            numberOfCylinders: data.productDetails.numberOfCylinders,
            yearOfManufacture: data.productDetails.yearOfManufacture,
            mileage: data.productDetails.mileage,
            drive: data.productDetails.drive,
            seatingCapacity: data.productDetails.seatingCapacity,
            fuelType: data.productDetails.fuelType,
            exteriorColor: data.productDetails.exteriorColor,
            carFeatures: data.productDetails.carFeatures,
            body: data.productDetails.body,
            exportedFrom: data.productDetails.exportedFrom,
          }
        },
        supplier: {
          supplierId: data.supplier.supplierId,
        }
      }
    };
    console.log('Request Body:', requestBody);
    return this.httpService.post<any>(`${this.url}/save`, requestBody, { headers });
  }
  

  getSupplier() : Observable<Supplier[]> {
    const task = this.httpService.get<Supplier[]>(this.urlSupplier + '/getAllSupplier');
    return task;
  }
}
