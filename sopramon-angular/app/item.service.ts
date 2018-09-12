import { Injectable } from '@angular/core';
import { Item } from './item';
import { AppConfigService } from './app-config.service';
import { Http } from '@angular/http';
import { Headers } from '@angular/http';
import { RequestOptions } from '@angular/http';


@Injectable()
export class ItemService {
  private items: Array<Item> = new Array<Item>();
      private requestOptions: RequestOptions;

  constructor(private http: Http, private appConfigService: AppConfigService ) {
    let myHeaders: Headers = new Headers();

    myHeaders.append('Authorization', this.appConfigService.getApiBasic());
    this.requestOptions = new RequestOptions({headers: myHeaders});
    
    this.http
        .get(this.appConfigService.getApiUrl() + "items", this.requestOptions)
        .subscribe(resp => this.items = resp.json()._embedded.items);
  }

  public findAll(): Array<Item> {
      return this.items;
  }

  public findAllByNom(nom: string): Array<Item> {
      return this.items.filter(i =>
          i.nom
              .toLowerCase()
              .indexOf(nom.toLowerCase()) !== -1
      );
  }

  // public acheterItem(): {
  //
  // }
}
