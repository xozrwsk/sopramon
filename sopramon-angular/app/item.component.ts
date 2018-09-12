import { Component } from '@angular/core';
import { Item } from './item';
import { ItemService } from './item.service';


@Component({
    templateUrl: 'app/item.component.html'
})
export class ItemComponent {
    private item: Item = new Item();
    private items: Array<Item> = new Array<Item>();
    private filtre: string="";

    constructor(private itemService: ItemService) {
    }

    public filtrerItem() {
      return this.itemService.findAllByNom(this.filtre);
    }

    public getItems(): Array<Item> {
      return this.itemService.findAll();
    }
}
