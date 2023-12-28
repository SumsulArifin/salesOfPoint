import { Component, OnInit } from '@angular/core';
import { Sale } from './InvoiceModel';
import { InvoiceService } from './invoice.service';
import { ActivatedRoute, Router } from '@angular/router';
import * as html2pdf from 'html2pdf.js';


@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit{

 

  id!: number;

  sale!: Sale;

  constructor(private services: InvoiceService,
    private router: Router, private route: ActivatedRoute,) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['postId'];
    this.services.find(this.id).subscribe((task: Sale) => {
      this.sale = task
      console.log(this.sale);
      
    });
    
  }

  calculateTax(): number {
    return this.sale.totalAmount * 0.093;
  }

  calculateTotal(): number {
    return this.sale.totalAmount + this.calculateTax();
  }

  printInvoice() {
    window.print();
  }

  generatePDF() {
    const content = document.getElementById('invoice-container');
  
    if (!content) {
      console.error("Element with ID 'invoice-container' not found.");
      return;
    }
  
    const options = {
      margin: 10,
      filename: 'invoice.pdf',
      image: { type: 'jpeg', quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
    };
  
    html2pdf().from(content).set(options).toPdf().output('blob').then((pdfData: Blob) => {
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(pdfData);
      link.download = 'invoice.pdf';
      link.click();
    });
  }
  
  
  
  
  

}
