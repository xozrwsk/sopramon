import { Injectable } from '@angular/core';
import { Combat } from './combat';
import { Http } from '@angular/http';
import { AppConfigService} from './app-config.service';
import { Headers } from '@angular/http';
import { RequestOptions } from '@angular/http';

@Injectable()
export class CombatService {

    private combats: Array<Combat> = new Array<Combat>();
      private requestOptions: RequestOptions;

  constructor(private http: Http, private appConfigService: AppConfigService ) {
    let myHeaders: Headers = new Headers();

    myHeaders.append('Authorization', this.appConfigService.getApiBasic());
    this.requestOptions = new RequestOptions({headers: myHeaders});

    this.http
        .get(this.appConfigService.getApiUrl() + "combats", this.requestOptions)
        .subscribe(resp => this.combats = resp.json()._embedded.combats);
  }

  public findAll(): Array<Combat> {
      return this.combats;
  }

  }
