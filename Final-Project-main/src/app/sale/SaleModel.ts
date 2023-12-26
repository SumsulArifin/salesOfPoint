export interface SaleModel {
    sale:{
    saleId: number;
    quantity: number;
    saleDate: Date;
    price: number;
    discount: number;
    totalAmount: number;
  };
  
    Stock: {
    stockId: number;
    quantity: number;
    status: boolean;
  };
  
    Customer: {
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
  };
  
    Product :{
    
  };
  
   Supplier: {
    
  };}