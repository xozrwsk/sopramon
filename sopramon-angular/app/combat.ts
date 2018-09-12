export class Combat {
      private id: number;
      private dateCombat: string;
      private arene: string;
      private type: string;
      private tours: number;
      private sopramon: number;
      private boss: number;
      private coup: number;


      public getId(): number {
          return this.id;
      }
      public getDateCombat(): string {
          return this.dateCombat;
      }
      public getArene(): string {
          return this.arene;
      }
      public getSopramon(): number{
		       return this.sopramon;
	    }
    public getBoss(): number{
       return this.boss;
     }
      }
