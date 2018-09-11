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
                for (let p of resp.json()._embedded.produits) {
                    this.produits.push(new Produit(p));
                }
            });
    }

    public findAll(): Array<Produit> {
        return this.produits;
    }


    public findAllByNom(nom: string): Array<Produit> {
        return this.produits.filter(p =>
            p.getNom()
                .toLowerCase()
                .indexOf(nom.toLowerCase()) !== -1
        );
    }


    public save(produit: Produit) {
        if (this.produits.indexOf(produit) === -1) {
            produit.setGamme(this.appConfigService.getApiUrl() + "gammes/1");
            this.http
                .post(this.appConfigService.getApiUrl() + "produits", produit, this.requestOptions)
                .subscribe(resp => this.produits.push(new Produit(resp.json())));
        }

        else {
            this.http
                .put(produit.getHref(), produit, this.requestOptions)
                .subscribe();
        }
    }


    public delete(produit: Produit) {
        let myIndex: number = this.produits.indexOf(produit);
        this.http
            .delete(produit.getHref(), this.requestOptions)
            .subscribe(resp => this.produits.splice(myIndex, 1));
    }
}
