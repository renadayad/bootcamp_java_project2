package com.example.exesrsies.model;

public class RequestApi {
    private String massege;
    private int statuse;

    public RequestApi(String massege, int statuse) {
        this.massege = massege;
        this.statuse = statuse;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public int getStatuse() {
        return statuse;
    }

    public void setStatuse(int statuse) {
        this.statuse = statuse;
    }
}




