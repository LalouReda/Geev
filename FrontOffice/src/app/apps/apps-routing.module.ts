import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BlogComponent } from './blog/blog.component';
import { AboutComponent } from './about/about.component';


import { FullComponent } from './layout/full/full.component';
import { LoginRegisterComponent } from './loginRegister/loginRegister.component';
import { ProfileComponent } from './profile/profile.component';



const routes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      { path: '', component: BlogComponent },
      { path: 'about', component: AboutComponent },
      { path: 'login-regsiter', component: LoginRegisterComponent },
      { path: 'profil', component: ProfileComponent  }
     
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppsRoutingModule { }
