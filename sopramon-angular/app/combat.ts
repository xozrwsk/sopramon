
export class Combat {
      private id: string;
      private dateCombat: string;
      private arene: string;
      private type: string;
      private tours: number;
      private sopramon: string;
      private boss: string;
      private coup: number;
      private href: string;

      constructor(private json?: any) {
          if (json !== undefined) {
              this.id = json.id;
              this.dateCombat = json.dateCombat;

              if (json._links !== undefined) {
                  this.href = json._links.self.href;
              }
          }
      }

      public getId(): string {
          return this.id;
      }

      public getHref(): string {
          return this.href;
      }
      }
