package League;

import League.Match.Match;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Team.Team;

public class League {

        Match[] matches=new Match[34];
        Team[] teams=new Team[18];

        /*public Player[] DisplayTopScorers(){
                Player[] topScorers = new Player[3];
                int currentTopScorer = 0;
                for (int i = 0; i < 3; i++) {
                        int maxGoals = -1;
                        for (int j = 0; j < teams.length; j++) {
                                for (int k = 0; k < teams[j].getTotal(); k++) {
                                        if(teams[j].getPlayers()[k].getGoalsScored()>maxGoals &&
                                                teams[j].getPlayers()[k] != topScorers[0] &&
                                                teams[j].getPlayers()[k] != topScorers[1] )
                                        {
                                                maxGoals = teams[j].getPlayers()[k].getGoalsScored();
                                                topScorers[currentTopScorer] = teams[j].getPlayers()[k];
                                                ++currentTopScorer;
                                        }
                                }
                        }
                }
                return topScorers;
        }*/
      /*  public Player[] DisplayTopGoalKeepers() {
                Player[] topKeepers = new Player[3];
                int max = 0;
                for (int i=0;i<3;i++) {
                        for (int j = 0; j < teams.length; j++) {
                                for (int k = 0; k < teams[j].getTotal(); k++) {
                                        if (teams[j].getPlayers()[k] instanceof Goalkeeper) {
                                                topKeepers[i] = (Goalkeeper) teams[j].getPlayers()[k];
                                                if (max < ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves()) {
                                                        max = ((Goalkeeper) teams[j].getPlayers()[k]).GetSaves();
                                                        topKeepers[i + 1] = topKeepers[i];
                                                        topKeepers[i] = (Goalkeeper) teams[j].getPlayers()[k];
                                                }

                                        }
                                }
                        }
                }
                return topKeepers;
        }
        /*void DisplayByGoals();
        void DisplayByAge();
        void DisplayByDate(String date);*/


}
