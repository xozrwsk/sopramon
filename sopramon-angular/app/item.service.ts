import { Injectable } from '@angular/core';
import { Item } from './item';


@Injectable()
export class ItemService {
  private items: Array<Item> = new Array<Item>();

  public findAll(): Array<Item> {
      return this.items;
  }

  public acheterItem(): {

  }
}
