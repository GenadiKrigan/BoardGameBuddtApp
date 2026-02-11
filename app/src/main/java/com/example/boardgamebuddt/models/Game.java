package com.example.boardgamebuddt.models;

public class Game {
    private String firebaseId;
    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int avgPlayTime;
    private int difficulty;
    private String category;
    private String learningStatus;
    private boolean isBorrowed;
    private boolean isUnplayed;
    private int totalPlayTime;
    private int playCount;
    private String rulesNote;

    public Game(){
    }

    public Game(String firebaseId, String name, int minPlayers, int maxPlayers, int avgPlayTime, int difficulty, String category){
        this.firebaseId = firebaseId;
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.avgPlayTime = avgPlayTime;
        this.difficulty = difficulty;
        this.category = category;
        this.learningStatus = "Need to Learn";
        this.isBorrowed = false;
        this.isUnplayed = true;
        this.totalPlayTime = 0;
        this.playCount = 0;
        this.rulesNote = "";
    }
    //Getters and Setters for FirebaseId
    public String getFirebaseId() {return firebaseId;}
    public void setFirebaseId(String firebaseId) {this.firebaseId = firebaseId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getMinPlayers() {return minPlayers;}
    public void setMinPlayers(int minPlayers) {this.minPlayers = minPlayers;}

    public  int getMaxPlayers() {return maxPlayers;}
    public void setMaxPlayers(int maxPlayers) {this.maxPlayers = maxPlayers;}

    public  int getAvgPlayTime() {return avgPlayTime;}
    public void setAvgPlayTime (int avgPlayTime) {this.avgPlayTime = avgPlayTime;}

    public int getDifficulty() {return difficulty;}
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public String getLearningStatus() {return learningStatus;}
    public void setLearningStatus(String learningStatus) {this.learningStatus = learningStatus;}

    public  boolean getIsBorrowed() {return isBorrowed;}
    public void setIsBorrowed(boolean isBorrowed) {this.isBorrowed = isBorrowed;}

    public  boolean getIsUnplayed() {return isUnplayed;}
    public void setIsUnplayed(boolean isUnplayed) {this.isUnplayed = isUnplayed;}

    public int getTotalPlayTime() {return totalPlayTime;}
    public void setTotalPlayTime(int totalPlayTime) {this.totalPlayTime = totalPlayTime;}

    public int getPlayCount() {return playCount;}
    public void setPlayCount(int playCount) {this.playCount = playCount;}

    public String getRulesNote() {return rulesNote;}
    public void setRulesNote(String rulesNote) {this.rulesNote = rulesNote;}
}
