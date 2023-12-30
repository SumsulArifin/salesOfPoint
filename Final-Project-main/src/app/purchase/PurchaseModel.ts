export interface PurchaseFormData {
  purchase: {
    purchaseDate: Date;
    price: number;
    payment: string;
    discount: number;
    totalAmount: number;
    deliveryAddress: string;
    warranty: string;
  };
  stock: {
    quantity: number;
  };
  product: {
    productName: string;
    productType: string;
    model: string;
  };
  productDetails: {
    registrationNo: string;
    chassisNumber: string;
    engineNumber: string;
    cubicCapacity: string;
    noOfTyres: number;
    numberOfCylinders: number;
    yearOfManufacture: Date;
    mileage: number;
    drive: string;
    seatingCapacity: number;
    fuelType: string;
    exteriorColor: string;
    carFeatures: string;
    body: string;
    exportedFrom: string;
    };
  supplier: {
    supplierId: number;
  };
}