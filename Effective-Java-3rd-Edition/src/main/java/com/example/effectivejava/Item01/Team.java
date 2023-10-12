package com.example.effectivejava.Item01;

public class Team {
    String playerName;
    int age;

    public Team(String playerName, int age) {
        this.playerName = playerName;
        this.age = age;
    }

    public Team(String coachName) {
    }

    public static Team createWithAge(String playerName){
        return new Team(playerName, 31);
    }
}
