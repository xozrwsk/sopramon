export class Item {
  public nom;
  public prix;
  public description;
  public attaque;
  public defense;
  public esquive;
  public vitesse;

  // constructor(public nom?: string, private prix?: number) {
  // }

  public getNom(): string {
    return this.nom;
  }

  public getPrix(): number {
    return this.prix;
  }

  public getDescription(): string {
    return this.description;
  }

  public getAttaque(): number {
    return this.attaque;
  }

  public getDefense(): number {
    return this.defense;
  }

  public getEsquive(): number {
    return this.esquive;
  }

  public getVitesse(): number {
    return this.vitesse;
  }

}
