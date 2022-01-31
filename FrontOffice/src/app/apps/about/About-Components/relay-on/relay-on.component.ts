import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-relay-on',
  templateUrl: './relay-on.component.html',
  styleUrls: ['./relay-on.component.css']
})
export class RelayOnComponent implements OnInit {

  relayOn = [
    {
      icon: 'sl-icon-target text-info-gradiant',
      field: 'Des suggestion en fonction de votre localisation',
      fieldText: 'Trouvez les annonces qui peuvent vous interesser et cela au plus proche'
    },
    {
      icon: 'sl-icon-mouse text-info-gradiant',
      field: 'De nombreuse annonces postées chaque jour',
      fieldText: 'N\'hésiter pas à visiter notre site plusieurs fois par jour, les pépites ne resteront pas disponible bien longtemps ;)'
    },
    {
      icon: 'sl-icon-earphones-alt text-info-gradiant',
      field: 'Contactez-nous',
      fieldText: 'Si vous avez des questions ou une remarque nous seront ravis de vous ecouter.'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
