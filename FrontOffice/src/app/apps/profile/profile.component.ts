import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userId: any = null;
  user: any = null;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.getUserInfos();
  }

  getUserInfos(){
    this.userId = localStorage.getItem("idPersonne");
    if (this.userId) {
      this.loginService.getPersonne(this.userId).then(res => {
        this.user = res;
        console.log(this.user)
      }, (err) => {
        console.log(err);
      });
    }
  }

}
