import {Criket} from "../criket/criket.ts";

export class Bowling extends Criket {
  public readonly bowlingAverage: number;

  constructor(name: string, battingAverage: number, bowlingAverage: number, type: string) {
    super(name, battingAverage, type);
    this.bowlingAverage = bowlingAverage;
  }

  getBowlingAverage(): number {
    return this.bowlingAverage;
  }
}
