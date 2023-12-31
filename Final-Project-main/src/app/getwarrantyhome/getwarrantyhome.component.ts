import { Component } from '@angular/core';
import { GetwarrantyhomeService } from './getwarrantyhome.service';
import { Sale } from './GetWarrantyModel';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-getwarrantyhome',
  templateUrl: './getwarrantyhome.component.html',
  styleUrls: ['./getwarrantyhome.component.css']
})
export class GetwarrantyhomeComponent {

  sales!: Sale;

  id!: number;

  constructor(private services: GetwarrantyhomeService,private router: Router, 
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['postId'];
    this.services.find(this.id).subscribe((task: Sale) => {
      this.sales = task
      
    });
  }
}
