export interface Purchase {
    purchaseDate: string;
    price: number;
    payment: string;
    discount: number;
    totalAmount: number;
    deliveryAddress: string;
    warranty: string;
    stock: {
      quantity: number;
      product: {
        productName: string;
        productType: string;
        productDetails: {
          registrationNo: string;
          chassisNumber: string;
          engineNumber: string;
          cubicCapacity: string;
          noOfTyres: number;
          numberOfCylinders: number;
          yearOfManufacture: string;
          engineCapacity: string;
          mileage: number;
          drive: string;
          seatingCapacity: number;
          fuelType: string;
          exteriorColor: string;
          carFeatures: string;
          body: string;
          rpm: string;
        };
      };
      supplier: {
        supplierName: string;
        contactPerson: string;
        email: string;
        phoneNumber: string;
      };
    };
  }
  