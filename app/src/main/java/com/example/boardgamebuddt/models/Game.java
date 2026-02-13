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
    //setters
    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setAvgPlayTime(int avgPlayTime) {
        this.avgPlayTime = avgPlayTime;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLearningStatus(String learningStatus) {
        this.learningStatus = learningStatus;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setUnplayed(boolean unplayed) {
        isUnplayed = unplayed;
    }

    public void setTotalPlayTime(int totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public void setRulesNote(String rulesNote) {
        this.rulesNote = rulesNote;
    }
    //Getters

    public String getFirebaseId() {
        return firebaseId;
    }

    public String getName() {
        return name;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getAvgPlayTime() {
        return avgPlayTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public String getLearningStatus() {
        return learningStatus;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean isUnplayed() {
        return isUnplayed;
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    public int getPlayCount() {
        return playCount;
    }

    public String getRulesNote() {
        return rulesNote;
    }
}
