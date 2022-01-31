import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-banner-navigation',
  templateUrl: './banner-navigation.component.html',
  styleUrls: ['./banner-navigation.component.css']
})
export class BannerNavigationComponent implements OnInit {

  logoutStatus = false;
  userId: any = null;

  constructor(private router: Router) { 

  }

  ngOnInit(): void {
    this.userId = localStorage.getItem("idPersonne");
  }

  logout(){
    localStorage.removeItem("idPersonne");
    this.router.navigate(['/']);
    this.userId = null;
  }
}
