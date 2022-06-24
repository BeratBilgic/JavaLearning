package FixtureGeneratorExample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<String>();
        teams.add("Team 1");
        teams.add("Team 2");
        teams.add("Team 3");
        teams.add("Team 4");
        teams.add("Team 5");
        teams.add("Team 6");
        //teams.add("Team 7");

        LinkedHashMap<Integer, ArrayList<Match>> fixture = new LinkedHashMap<>();

        fixture = generatorFixture(teams);

        fixture = secondHalfFixture(fixture);

        printFiscture(fixture);
    }

    public static LinkedHashMap<Integer, ArrayList<Match>> generatorFixture(ArrayList<String> teams){
        LinkedHashMap<Integer, ArrayList<Match>> fixture = new LinkedHashMap<>();
        Collections.shuffle(teams);

        if (teams.size() % 2 != 0){
            teams.add("PASS");
        }

        int totalRound = teams.size()-1;
        int matchPerRound = teams.size()/2;

        for (int i = 1; i <= totalRound; i++) {
            ArrayList<Match> roundMatch = new ArrayList<Match>();
            for (int k = 0; k <  matchPerRound; k++) {
                int home = (i + k) % (teams.size() - 1);
                int away = (teams.size() - 1 - k + i) % (teams.size() - 1);

                if (k == 0)
                    away = teams.size() - 1 ;

                roundMatch.add(new Match(teams.get(home), teams.get(away)));
            }

            Collections.shuffle(roundMatch);
            fixture.put(i,roundMatch);
        }
        return  fixture;
    }

    public static LinkedHashMap<Integer, ArrayList<Match>> secondHalfFixture(LinkedHashMap<Integer, ArrayList<Match>> fix){
        int len = fix.size();

        for (int i = len+1; i <= len*2; i++) {
            ArrayList<Match> matches = fix.get(i-len);
            ArrayList<Match> revMatches = new ArrayList<>();
            for (int j = 0; j < matches.size(); j++) {
                revMatches.add(j,new Match(matches.get(j).getAway(),matches.get(j).getHome()));
            }
            fix.put(i,revMatches);
        }
        return fix;
    }

    public static void printFiscture(LinkedHashMap<Integer, ArrayList<Match>> fixture){
        for (Map.Entry<Integer, ArrayList<Match>> o : fixture.entrySet()) {
            ArrayList<Match> matches = o.getValue();
            System.out.println("\nRound " + o.getKey());
            for (Match m:matches) {
                System.out.printf("%-13s vs\t%-13s\n",m.getHome(),m.getAway());
            }
        }
    }
}
