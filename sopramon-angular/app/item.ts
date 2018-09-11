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

}
