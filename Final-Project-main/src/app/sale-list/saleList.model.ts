export interface Sale {
    createdAt: string;
    updatedAt: string | null;
    deletedAt: string | null;
    createdBy: string | null;
    updatedBy: string | null;
    deletedBy: string | null;
    status: boolean;
    saleId: number;
    invoiceNumber: number;
    quantity: number;
    saleDate: string;
    price: number;
    discount: number;
    totalAmount: number;
    stock: {
      stockId: number;
      quantity: number;
      status: boolean;
      product: {
        createdAt: string;
        updatedAt: string | null;
        deletedAt: string | null;
        createdBy: string | null;
        updatedBy: string | null;
        deletedBy: string | null;
        status: boolean;
        productId: number;
        productName: string;
        productType: string;
        productDetails: {
          productDetailsId: number;
          registrationNo: string;
          chassisNumber: string;
          engineNumber: string;
          cubicCapacity: string;
          noOfTyres: number;
          numberOfCylinders: number;
          yearOfManufacture: string;
          body: string;
          mileage: number;
          drive: string;
          seatingCapacity: number;
          fuelType: string;
          exteriorColor: string;
          carFeatures: string;
          exportedFrom: string;
        };
      };
      supplier: {
        supplierId: number;
        supplierName: string;
        contactPerson: string;
        email: string;
        phoneNumber: string;
      };
    };
    customer: {
      customerId: number;
      firstName: string;
      lastName: string;
      email: string;
      phoneNumber: string;
    };
    warranty: {
      createdAt: string;
      updatedAt: string | null;
      deletedAt: string | null;
      createdBy: string | null;
      updatedBy: string | null;
      deletedBy: string | null;
      status: boolean;
      warrantyId: number;
      startDate: string;
      endDate: string;
      terms1: string;
      terms2: string;
      terms3: string;
      terms4: string;
      terms5: string;
      terms6: string;
      terms7: string;
      terms8: string;
      terms9: string;
      terms10: string;
      comment: string;
    };
  }
  