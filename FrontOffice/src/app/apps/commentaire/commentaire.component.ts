import { Component, Input, OnInit } from '@angular/core';
import { CommentaireService } from 'src/app/service/commentaire/commentaire.service';

@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.css']
})
export class CommentaireComponent implements OnInit {

  @Input()
  idAnnonce: any;
  commentaires: any = [];

  constructor(private commentaireService: CommentaireService) { }

  ngOnInit(): void {
    if (this.idAnnonce) {
      this.commentaireService.getCommentaires(this.idAnnonce).then(res => {
        this.commentaires = res;
        console.log("commen", this.commentaires);
        }, (err) => {
          console.log(err);
        });
    }
  }

}
