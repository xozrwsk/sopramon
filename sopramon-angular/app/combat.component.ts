import { Component } from '@angular/core';
import { Combat } from './combat';
import { CombatService } from './combat.service';


@Component({
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/combat.component.css' ]
})
export class CombatComponent {

  private combats: Array<Combat> = new Array<Combat>();

    constructor(private combatService : CombatService) {
          }


    public getCombats() : Array<Combat>{
      return  this.combatService.findAll();
    }


    public filtrerProduits(){
        return this.combatService.findAllById(this.filtre);

    }
  }
