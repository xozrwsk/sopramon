import { Injectable } from '@angular/core';

// @Injectable()
// export class AppConfigService {
//   private url: string = 'http://localhost:8080/api/';
//
//   public getApiUrl(): string{
//     return this.url;
//   }
//
// }


@Injectable()
export class AppConfigService {
    private apiUrl: string = "http://localhost:8080/api/";
    private apiUser: string = "JP";
    private apiPassword: string = "1";

    public getApiUrl(): string {
        return this.apiUrl;
    }

    public getApiBasic(): string {
        return 'Basic ' + btoa(this.apiUser + ':' + this.apiPassword);
    }
}
