

import { Stock } from "../home/stock.model";

export interface PurchaseModel {
    purchasesId: number;
    purchaseDate: Date;
    price: number;
    payment: string;
    discount: number;
    totalAmount: number;
    deliveryAddress: string;
    warranty: string;
    stock: Stock;
  }