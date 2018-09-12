import { Component } from '@angular/core';
import { Combat } from './combat';
import { CombatService } from './combat.service';


@Component({
    templateUrl: 'app/combat.component.html',
    styleUrls: [ 'app/combat.component.css' ]
})
export class CombatComponent {

  private combat: Combat = new Combat();
  private combats: Array<Combat> = new Array<Combat>();

  constructor(private combatService: CombatService) {
  }
  public lesCombats(): Array<Combat> {
    return this.combatService.findAll();
  }
}
