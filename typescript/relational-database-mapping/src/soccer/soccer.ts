import {Athlete} from "../athlete/athlete.ts";

export class Soccer extends Athlete {

  public readonly club: string;

  constructor(name: string, club: string, type: string) {
    super(name, type);
    this.club = club;
  }

  getClub(): string {
    return this.club;
  }
}
