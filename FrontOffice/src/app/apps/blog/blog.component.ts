import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login/login.service';
import { AnnonceService } from 'src/app/service/annonce/annonce.service';
import { ReservationService } from 'src/app/service/reservation/reservation.service';
import * as $ from 'jquery';
import { SettingService } from 'src/app/service/setting/setting.service';
import { CommentaireService } from 'src/app/service/commentaire/commentaire.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css'],
})
export class BlogComponent implements OnInit {
  @ViewChild("imag", {static: false}) imag: ElementRef | any;

  annonces : any [] = [] ;
  user:any = null;
  commentaire:any = "";

  annonceForm: FormGroup;
  userId: any = null;
  imgSrc="";

  titre = new FormControl('', [Validators.required]);
  image = new FormControl('');
  description = new FormControl('',[Validators.required]);
  adresse = new FormControl('', [Validators.required]);
  

  constructor(private annonceService: AnnonceService,private router: Router,private reservationService: ReservationService,private commentaireService: CommentaireService, private settingService: SettingService ) {
    this.annonceForm = new FormGroup({
      titre: this.titre,
      image: this.image,
      description: this.description,
      adresse: this.adresse,
    });
    this.imgSrc = this.settingService.getImgDir();
  }

  ngOnInit() {
    this.getAllAnnonces();
    this.userId = localStorage.getItem("idPersonne");
  }

  upload() {
    var formData: any = new FormData();
    formData.append("file", this.annonceForm.get('image')?.value);
      this.annonceService.upload(formData).subscribe(
        (response) => {
          if (response) {
            this.annonceForm.get("image")?.setValue(this.imag);
            console.log(response);
            this.createAnnonce()
          }
        },
        (error) => () => {
        }
      )
  }

  uploadFile(event:any) {
    const file = event.target.files[0];
    this.imag = file.name;
    this.annonceForm.get('image')?.setValue(file); //this line is mandatory
    console.log(this.annonceForm.value, this.imag);
  }

  createAnnonce(){
    if (this.userId) {
      this.annonceService.createAnnonce(this.annonceForm.value).then(res => {
      console.log(res);
       //this.getAllAnnonces();
        this.annonces.push(res);
        alert("annonce crée avec avec succès");
      }, (err) => {
        console.log(err);
      });
    } else {
      alert("vous devez vous connecter");
    }
  }

  deleteAnnonce(idAnnonce:any){
    this.annonceService.deleteAnnonce(idAnnonce).then(res => {
      this.getAllAnnonces();
    }, (err) => {
      console.log(err);
    });
  }
  reserver(idAnnonce: any,idPersonne:any){
    if (this.userId) {
      console.log(idAnnonce,idPersonne)
      this.reservationService.createReservation(idAnnonce,idPersonne).then(res => {
        if (res) {
          console.log(res);
          this.getAllAnnonces();
        }else{
          alert("Vous ne pouvez pas effectuer cette opération");
        }
      }, (err) => {
        console.log(err);
      });
    } else {
      alert("Vous devenez vous connecter pour continuer");
    }
  }

  commenter(idAnnonce: any,idPersonne:any){
    if (this.userId) {
      console.log(this.commentaire);
      this.commentaireService.createCommentaire(idAnnonce,idPersonne,this.commentaire).then(res => {
        if (res) {
          console.log(res);
          this.getAllAnnonces();
        }else{
          alert("Vous ne pouvez pas effectuer cette opération");
        }
      }, (err) => {
        console.log(err);
      });
    } else {
      alert("Vous devenez vous connecter pour continuer");
    }
  }

  getAllAnnonces(){
    this.annonceService.getListAnnonces().subscribe(res => {
      this.annonces = res.sort((a, b) => b.idAnnonce - a.idAnnonce);;
     }, (err) => {
       console.log(err);
     });

  }
  loginClick() {
    this.router.navigate(['/login']);
  }

  newPost() {
    this.router.navigate(['/post']);
  }

  viewDetail(personne:any) {
    this.user = personne;
  }
}
