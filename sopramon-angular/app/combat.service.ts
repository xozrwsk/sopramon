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
      this.requestOptions = new RequestOptions ({headers: myHeaders });

       this.http
            .get(this.appConfigService.getApiUrl() + "combats", this.requestOptions)
            .subscribe(resp => {
                for (let c of resp.json()._embedded.produits) {
                    this.combats.push(new Combat(c));
                }
            });
    }

    public findAll(): Array<Combat> {
        return this.combats;
    }


    public findAllById(id: number): Array<Combat> {
        return this.combats.filter(c => c.getId
        );
    }
}
