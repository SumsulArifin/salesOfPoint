import { Stock } from "./stock.model";

export interface Purchase {
    purchasesId: number;
    status: boolean;
    purchaseDate: string;
    price: number;
    payment: string;
    discount: number;
    totalAmount: number;
    deliveryAddress: string;
    warranty: string;
    stock: Stock;
  }