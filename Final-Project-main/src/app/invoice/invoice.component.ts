import { Component, OnInit } from '@angular/core';
import { Sale } from './InvoiceModel';
import { InvoiceService } from './invoice.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit{

  id!: number;

  sale!: Sale[];

  constructor(private services: InvoiceService,
    private router: Router, private route: ActivatedRoute,) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['postId'];
    this.services.find(this.id).subscribe((task: Sale[]) => {
      this.sale = task
    });
    
  }

}
