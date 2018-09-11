import { Component } from '@angular/core';
import { Item } from './item';
import { ItemService } from './item.service';


@Component({
    templateUrl: 'app/item.component.html',
    styleUrls: ['app/item.component.css']
})
export class ProduitComponent {
    private item: Item = new Item();
    private items: Array<Item> = new Array<Item>();

    constructor(private itemService: ItemService) {
    }

    public getItems(): Array<Item> {
      return this.itemService.findAll();
    }
}
