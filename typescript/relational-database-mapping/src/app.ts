import {RdbmsConfig} from "./config/rdbms.config.ts";
import {Soccer} from "./soccer/soccer.ts";
import {Criket} from "./criket/criket.ts";
import {Bowling} from "./bowling/bowling.ts";

RdbmsConfig.open();
RdbmsConfig.initialize();

const soccerPlayer: Soccer = new Soccer("김축구", "축구명문", "Soccer");
const criketPlayer: Criket = new Criket("김크켓", 0.67, "Criket");
const bowlingPlayer: Bowling = new Bowling("김볼링", 0.71, 100, "Bowling");

await RdbmsConfig.insertAthlete(soccerPlayer);
await RdbmsConfig.insertAthlete(criketPlayer);
await RdbmsConfig.insertAthlete(bowlingPlayer);
await RdbmsConfig.getAthlete();

RdbmsConfig.close();
