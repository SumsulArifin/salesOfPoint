export interface ProductDetails {
    productDetailsId: number;
    registrationNo: string;
    yearOfManufacture: string;
  }

  
  
  export interface Product {
    createdAt: string;
    updatedAt: string | null;
    productName: string;
    productDetails: ProductDetails;
    model: string;
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
  