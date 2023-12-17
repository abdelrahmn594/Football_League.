package mainPackage;

import League.GUI.GUI;
import League.League;
import League.Match.Match;
import League.Person.Coach.Coach;
import League.Person.Player.*;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void ReadFiles(League league){

        //Read Coaches
        ArrayList<Coach> coaches = new ArrayList<>();
        BufferedReader ReadCoach = null;
        try {
            ReadCoach = new BufferedReader(new FileReader("Coaches.txt"));
            while (ReadCoach.ready()){
                String coach = ReadCoach.readLine();
                String[] coachInfo = coach.split("\t");
                Coach newCoach = new Coach(coachInfo[0],Integer.parseInt(coachInfo[1]),Integer.parseInt(coachInfo[2]),coachInfo[3],Integer.parseInt(coachInfo[4]));
                coaches.add(newCoach);
            }
        }catch (IOException exp){
            System.out.println("Coaches file not found");
        }finally {
            if (ReadCoach!= null){
                try {
                    ReadCoach.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close coaches file");
                }
            }
        }
        //Read Referees
        ArrayList<Referee> referees = new ArrayList<>();
        BufferedReader ReadReferee = null;
        try {
            ReadReferee = new BufferedReader(new FileReader("Referees.txt"));
            while (ReadReferee.ready()){
                String referee = ReadReferee.readLine();
                String[] refereeInfo = referee.split("\t");
                Referee newReferee = new Referee(refereeInfo[0],Integer.parseInt(refereeInfo[1]),Integer.parseInt(refereeInfo[2]),Integer.parseInt(refereeInfo[3]),Integer.parseInt(refereeInfo[4]));
                referees.add(newReferee);
            }
        }catch (IOException exp){
            System.out.println("Referees file not found");
        }finally {
            if (ReadReferee!= null){
                try {
                    ReadReferee.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close referees file");
                }
            }
        }
        //Read Stadiums
        ArrayList<Stadium> stadiums = new ArrayList<>();
        BufferedReader ReadStadium = null;
        try {
            ReadStadium = new BufferedReader(new FileReader("Stadiums.txt"));
            while (ReadStadium.ready()){
                String stadium = ReadStadium.readLine();
                String[] stadiumInfo = stadium.split("\t");
                Stadium newStadium = new Stadium(stadiumInfo[0],stadiumInfo[1],Integer.parseInt(stadiumInfo[2]));
                stadiums.add(newStadium);
            }

        }catch (IOException exp){
            System.out.println("Stadiums file not found");
        }finally {
            if (ReadStadium!= null){
                try {
                    ReadStadium.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close stadiums file");
                }
            }
        }
        //Read Teams
        ArrayList<Team> teams = new ArrayList<>();
        BufferedReader ReadTeam = null;
        try {
            ReadTeam = new BufferedReader(new FileReader("Teams.txt"));
            int TeamsCount = 1;
            while (ReadTeam.ready()){
                ArrayList<Player> players = new ArrayList<>();
                Player TeamCaptain = null;
                BufferedReader ReadTeamPlayers = null;
                try {
                    ReadTeamPlayers = new BufferedReader(new FileReader("Team"+TeamsCount+"Players.txt"));
                    while (ReadTeamPlayers.ready()){
                        String player = ReadTeamPlayers.readLine();
                        String[] playerInfo = player.split("\t");
                        if(playerInfo[0].equals("Forward")){
                            Forward newPlayer = new Forward(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Boolean.parseBoolean(playerInfo[13]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Forward(newPlayer);
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Midfielder")){
                            Midfielder newPlayer = new Midfielder(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Boolean.parseBoolean(playerInfo[13]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Midfielder(newPlayer);
                            }
                            players.add(newPlayer);
                        }else if (playerInfo[0].equals("Defender")){
                            Defender newPlayer = new Defender(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Integer.parseInt(playerInfo[13]),
                                    Boolean.parseBoolean(playerInfo[14]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Defender(newPlayer);
                            }
                            players.add(newPlayer);
                        }else{
                            Goalkeeper newPlayer = new Goalkeeper(playerInfo[1],
                                    Integer.parseInt(playerInfo[2]),
                                    Integer.parseInt(playerInfo[3]),
                                    playerInfo[4],Integer.parseInt(playerInfo[5]),
                                    Double.parseDouble(playerInfo[6]),
                                    Integer.parseInt(playerInfo[7]),
                                    Integer.parseInt(playerInfo[8]),
                                    Integer.parseInt(playerInfo[9]),
                                    Integer.parseInt(playerInfo[10]),
                                    Integer.parseInt(playerInfo[11]),
                                    Integer.parseInt(playerInfo[12]),
                                    Integer.parseInt(playerInfo[13]),
                                    Boolean.parseBoolean(playerInfo[14]));
                            if (newPlayer.getCaptain()){
                                TeamCaptain = new Goalkeeper(newPlayer);
                            }
                            players.add(newPlayer);
                        }
                    }
                }catch (IOException exp){
                    System.out.println("Team " + TeamsCount + " file not found");
                }finally {
                    if (ReadTeamPlayers!= null){
                        try {
                            ReadTeamPlayers.close();
                        }catch (IOException exp){
                            System.out.println("Couldn't close team" + TeamsCount + "Players file");
                        }
                    }
                }
                Coach TeamCoach = null;
                for (Coach coach : coaches){
                    if (coach.getTeamID() == TeamsCount){
                        TeamCoach = coach;
                    }
                }
                String team = ReadTeam.readLine();
                String[] teamInfo = team.split("\t");
                System.out.println(Arrays.toString(teamInfo));
                Team newTeam = new Team(teamInfo[0],
                        players,
                        TeamCaptain,
                        TeamCoach,
                        new ArrayList<>(),
                        Integer.parseInt(teamInfo[1]),
                        Integer.parseInt(teamInfo[2]),
                        Integer.parseInt(teamInfo[3]));
                teams.add(newTeam);
                ++TeamsCount;
            }
            league.setTeams(teams);
        }catch (IOException exp){
            System.out.println("Teams file not found");
        }finally {
            if (ReadTeam!= null){
                try {
                    ReadTeam.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close teams file");
                }
            }
        }
        //Read Matches
        ArrayList<Match> matches = new ArrayList<>();
        BufferedReader ReadMatch = null;
        try {
            ReadMatch = new BufferedReader(new FileReader("Matches.txt"));
            while (ReadMatch.ready()){
                String match = ReadMatch.readLine();
                String[] matchInfo = match.split("\t");
                String team1Name = matchInfo[1];
                String team2Name = matchInfo[2];
                Team team1 = new Team();
                Team team2 = new Team();
                for (Team team : teams){
                    if (team.getName().equals(team1Name)){
                        team1 = new Team(team);
                    }else if (team.getName().equals(team2Name)){
                        team2 = new Team(team);
                    }
                }
                Team[] MatchTeams = new Team[2];
                MatchTeams[0] = team1;
                MatchTeams[1] = team2;
                String refereeName = matchInfo[3];
                Referee MatchReferee = new Referee();
                for (Referee referee : referees){
                    if (referee.getPersonName().equals(refereeName)){
                        MatchReferee = new Referee(referee);
                    }
                }
                String stadiumName = matchInfo[5];
                Stadium MatchStadium = new Stadium();
                for (Stadium stadium : stadiums){
                    if (stadium.getStadiumName().equals(stadiumName)){
                        MatchStadium = new Stadium(stadium);
                    }
                }
                try {
                    Match newMatch = new Match(matchInfo[0],new SimpleDateFormat("dd/MM/yyyy").parse(matchInfo[0]),MatchTeams,MatchReferee,matchInfo[4],MatchStadium,Integer.parseInt(matchInfo[6]),Integer.parseInt(matchInfo[7]));
                    MatchStadium.matches.add(newMatch);
                }catch (ParseException exp){
                    System.out.println("Invalid date");
                }
            }
        }catch (IOException exp){
            System.out.println("Matches files not found");
        }finally {
            if (ReadMatch!= null){
                try {
                    ReadMatch.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close matches file");
                }
            }
        }
    }
    public static void WriteFiles(League league){
        //Write Coaches
        BufferedWriter WriteCoach = null;
        try {
            WriteCoach = new BufferedWriter(new FileWriter("Coaches.txt"));
            for (Team team : league.getTeams()){
                try {
                    WriteCoach.write(team.getCoach().writeCoach());
                    WriteCoach.write("\n");
                }catch (NullPointerException exp){
                    System.out.println("Team has no coach");
                }
            }
        }catch (IOException exp){
            System.out.println("Coaches file not found");
        }finally {
            if (WriteCoach!=null){
                try {
                    WriteCoach.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close coaches file");
                }
            }
        }
        //Write Referees
        BufferedWriter WriteReferees = null;
        try {
            WriteReferees = new BufferedWriter(new FileWriter("Referees.txt"));
            for (Referee referee : league.referees){
                WriteReferees.write(referee.WriteReferee());
                WriteReferees.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Referees file not found");
        }finally {
            if (WriteReferees!=null){
                try {
                    WriteReferees.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close referees file");
                }
            }
        }
        //Write Stadiums
        BufferedWriter WriteStadiums = null;
        try {
            WriteStadiums = new BufferedWriter(new FileWriter("Stadiums.txt"));
            for (Stadium stadium : league.stadiums){
                WriteStadiums.write(stadium.WriteStadium());
                WriteStadiums.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Stadiums file not found");
        }finally {
            if (WriteStadiums!=null){
                try {
                    WriteStadiums.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close stadiums file");
                }
            }
        }
        //Write Teams
        BufferedWriter WriteTeams = null;
        try {
            WriteTeams = new BufferedWriter(new FileWriter("Teams.txt"));
            int TeamsCount = 1;
            for (Team team : league.getTeams()){
                System.out.println(team.WriteTeam());
                WriteTeams.write(team.WriteTeam());
                WriteTeams.write("\n");
                BufferedWriter WriteTeamPlayers = null;
                try {
                    WriteTeamPlayers = new BufferedWriter(new FileWriter("Team" + TeamsCount + "Players.txt"));
                    for (Player player : team.Players){
                        if (player instanceof Forward){
                            Forward forward = (Forward) player;
                            WriteTeamPlayers.write(forward.WriteForward());
                        }else if(player instanceof Midfielder){
                            Midfielder midfielder = (Midfielder) player;
                            WriteTeamPlayers.write(midfielder.WriteMidfielder());
                        }else if(player instanceof Defender){
                            Defender defender = (Defender) player;
                            WriteTeamPlayers.write(defender.WriteDefender());
                        }else{
                            Goalkeeper goalkeeper = (Goalkeeper) player;
                            WriteTeamPlayers.write(goalkeeper.WriteGoalkeeper());
                        }
                        WriteTeamPlayers.write("\n");
                    }
                }catch (IOException exp){
                    System.out.println("Team" + TeamsCount + "Players file not found");
                }finally {
                    if (WriteTeamPlayers!=null){
                        try {
                            WriteTeamPlayers.close();
                        }catch (IOException exp){
                            System.out.println("Couldn't close Team" + TeamsCount + "Players file");
                        }
                    }
                }
                ++TeamsCount;
            }
        }catch (IOException exp){
            System.out.println("Teams file not found");
        }finally {
            if (WriteTeams != null){
                try {
                    WriteTeams.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close teams file");
                }
            }
        }
        //Write Matches
        BufferedWriter WriteMatches = null;
        try {
            WriteMatches = new BufferedWriter(new FileWriter("Matches.txt"));
            for (Match match : league.matches){
                WriteMatches.write(match.WriteMatch());
                WriteMatches.write("\n");
            }
        }catch (IOException exp){
            System.out.println("Matches file not found");
        }finally {
            if (WriteMatches!=null){
                try {
                    WriteMatches.close();
                }catch (IOException exp){
                    System.out.println("Couldn't close matches file");
                }
            }
        }
    }
    public static void teamMenu(League league,Scanner input,Team currentTeam){
        while (true){
            System.out.println("TEAM MENU :");
            System.out.println("1- Add Player");
            System.out.println("2- Search for a Player");
            System.out.println("3- Display Players");
            System.out.println("4- Display Team Info");
            System.out.println("5- Display Team Matches");
            System.out.println("6- Edit Team");
            System.out.println("7- Exit");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter Player Info:");
                System.out.print("Player Name:");
                input.nextLine();
                String PlayerName = input.nextLine();
                System.out.print("Player Age: ");
                int PlayerAge = input.nextInt();
                System.out.print("Player Number");
                int PlayerNumber = input.nextInt();
                System.out.print("Enter Player Position (Forward/Midfielder/Defender/Goalkeeper) : ");
                input.nextLine();
                String PlayerPosition;
                while (true){
                    PlayerPosition = input.nextLine();
                    if (PlayerPosition.toLowerCase().startsWith("f") ||
                            PlayerPosition.toLowerCase().startsWith("m") ||
                            PlayerPosition.toLowerCase().startsWith("d") ||
                            PlayerPosition.toLowerCase().startsWith("g")){
                        break;
                    }else {
                        System.out.println("Invalid Input");
                    }
                }
                System.out.println("Is this player a captain?(y/n)");
                boolean isCaptain;
                while (true){
                    String answer = input.next();
                    if (answer.toLowerCase().startsWith("y")){
                        isCaptain = true;
                        break;
                    }else if (answer.toLowerCase().startsWith("n")){
                        isCaptain = false;
                        break;
                    }else {
                        System.out.println("Invalid input");
                    }
                }
                /*if (PlayerPosition.toLowerCase().startsWith("f")){
                    Player newPlayer = new Forward(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,0,isCaptain);
                }
                Player newPlayer = new Player(PlayerName,PlayerAge,0,currentTeam.getName(),PlayerNumber,0,0,0,0,0,0,isCaptain);
                currentTeam.addPlayer(newPlayer);*/
            }
        }
    }
    public static void teamsMenu(League league,Scanner input){
        while (true){
            System.out.println("TEAMS MENU :");
            System.out.println("1- Add Team");
            System.out.println("2- Search for a Team");
            System.out.println("3- Display Teams");
            System.out.println("4- Back to the main menu");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter Team Info :");
                System.out.println("Team Name: ");
                input.nextLine();
                String TeamName = input.nextLine();
                Team newTeam = new Team(TeamName,new ArrayList<>(),null,null,new ArrayList<>(),0,0,0);
                league.AddTeam(newTeam);
            }else if (choice == 2){
                System.out.print("Enter team info :");
                String TeamName = input.nextLine();
                Team searched = league.searchTeam(TeamName);
                try {
                    teamMenu(league,input,searched);
                }catch (NullPointerException exp){
                    System.out.println("Team not found");
                }
            }else if (choice == 3){
                //league.getTeams().
            } else if (choice == 4) {
                break;
            }
        }
    }
    public static void mainMenu(League league){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Select one of the following choices : ");
            System.out.println("1- Teams Menu");
            System.out.println("2- Matches Menu");
            System.out.println("3- Stats Menu");
            System.out.println("4- Exit");
            int choice = input.nextInt();
            if (choice == 1){
                teamsMenu(league,input);
            }else if (choice == 2){
                //Matches menu
            } else if (choice == 3) {
                //stats menu
            }else if(choice == 4){
                break;
            }
        }
    }
    public static void main(String[] args) {
        League league = new League();
        ReadFiles(league);
        //SwingUtilities.invokeLater(() -> new GUI(league));
        mainMenu(league);
        WriteFiles(league);
    }
}