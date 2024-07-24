import {Athlete} from "../athlete/athlete.ts";

export class Criket extends Athlete {
  public readonly battingAverage: number;

  constructor(name: string, battingAverage: number, type: string) {
    super(name, type);
    this.battingAverage = battingAverage;
  }

  getBattingAverage(): number {
    return this.battingAverage;
  }
}
