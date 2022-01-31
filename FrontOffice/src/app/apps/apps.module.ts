import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppsRoutingModule } from './apps-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppsComponent } from './apps.component';
import { BlogComponent } from './blog/blog.component';
import { AboutComponent } from './about/about.component';

import { RelayOnComponent } from './about/About-Components/relay-on/relay-on.component';
import { TopContentComponent } from './about/About-Components/top-content/top-content.component';

import { FullComponent } from './layout/full/full.component';

import { BannerComponent } from './shared/banner/banner.component';
import { BannerNavigationComponent } from './shared/banner-navigation/banner-navigation.component';
import { FooterComponent } from './shared/footer/footer.component';
import { LoginRegisterComponent } from './loginRegister/loginRegister.component';
import { ProfileComponent } from './profile/profile.component';
import { CommentaireComponent } from './commentaire/commentaire.component';

@NgModule({
  declarations: [
    AppsComponent,
    BlogComponent,
    AboutComponent,
    RelayOnComponent,
    TopContentComponent,
    FullComponent,
    BannerComponent,
    LoginRegisterComponent,
    BannerNavigationComponent,
    FooterComponent,
    ProfileComponent,
    CommentaireComponent
  ],
  imports: [
    CommonModule,
    AppsRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [],
})
export class AppsModule {}
