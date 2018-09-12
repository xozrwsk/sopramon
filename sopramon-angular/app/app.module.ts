import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { Combat } from './combat';
import { CombatComponent } from './combat.component';
import { CombatService } from './combat.service';
import { ICombatService } from './i-combat.service';
import { ItemService } from './item.service';
import { ICombatComponent } from './i-combat.component';
import { RouterModule, Routes } from '@angular/router';
import { AppConfigService } from './app-config.service';
import { ItemComponent } from './item.component'

// constructeurs ==> récupérer les informations
//Configuration des routes
const routes: Routes = [
  { path: 'icombat', component: ICombatComponent },
  { path: 'combat', component: CombatComponent },
  { path: 'item', component: ItemComponent },
  // { path: 'jouer', component: CombatComponent },
  { path: '', redirectTo: 'icombat', pathMatch: 'full' }
];


@NgModule({
    imports: [
        BrowserModule,
		     FormsModule,
         RouterModule.forRoot(routes),
         HttpModule,
      ],
    declarations: [
        AppComponent,
        ICombatComponent,
        CombatComponent,
        ItemComponent
        ],
    bootstrap: [
    AppComponent ],
    providers: [
    AppConfigService,
    CombatService,
    ICombatService,
    ItemService
  ],

})
export class AppModule { }
