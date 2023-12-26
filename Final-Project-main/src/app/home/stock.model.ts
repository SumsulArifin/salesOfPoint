export interface ProductDetails {
    productDetailsId: number;
    registrationNo: string;
  }

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
  
  export interface Product {
    createdAt: string;
    updatedAt: string | null;
    productName: string;
    productDetails: ProductDetails;
  }
  
  export interface Supplier {
    supplierId: number;
    supplierName: string | null;
    contactPerson: string | null;
    email: string | null;
    phoneNumber: string | null;
  }
  
  export interface Stock {
    stockId: number;
    quantity: number;
    status: boolean;
    product: Product;
    supplier: Supplier;
  }
  