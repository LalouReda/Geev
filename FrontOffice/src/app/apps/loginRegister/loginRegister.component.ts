import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login/login.service';

@Component({
  selector: 'app-loginRegister',
  templateUrl: './loginRegister.component.html',
  styleUrls: ['./loginRegister.component.css']
})
export class LoginRegisterComponent implements OnInit {

  personneForm: FormGroup;

  nom = new FormControl('', [Validators.required]);
  prenom = new FormControl('', [Validators.required]);
  description = new FormControl('');
  email = new FormControl('', [Validators.required]);
  telephone = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required]);
  confirmPassword = new FormControl('', [Validators.required]);

  loginForm: FormGroup;
  email1 = new FormControl('', [Validators.required]);
  password1 = new FormControl('', [Validators.required]);


  constructor(private loginService: LoginService,private router: Router) {
    this.personneForm = new FormGroup({
      nom: this.nom,
      prenom: this.prenom,
      description: this.description,
      email: this.email,
      telephone: this.telephone,
      password: this.password,
      confirmPassword: this.confirmPassword
    });
    this.loginForm = new FormGroup({
      email1: this.email1,
      password1: this.password1,
    });
  }

  ngOnInit() {
  }

  createAccount(){
    this.loginService.create(this.personneForm.value).then(res => {
      console.log(res);
    }, (err) => {
      console.log(err);
    });
  }
  loginPersonne(){
    this.loginService.verifier(this.loginForm.get('email1')?.value,this.loginForm.get("password1")?.value).then(res => {
      if (res) {
        let temp: any = res;
        localStorage.setItem("idPersonne", temp.idPersonne);
        this.router.navigate(['/profil']);
      }else{
        alert("indentifiants invalides")
      }
    }, (err) => {
      console.log(err);
    });
  }

}
