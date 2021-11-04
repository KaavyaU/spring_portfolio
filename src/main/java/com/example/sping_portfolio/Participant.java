package com.example.sping_portfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int rank;
    private String username;
    private int amtRecycled;

    protected Participant() {} //Why 2 Constructors?


    public Participant(int rank, String username, int amtRecycled){
        this.rank = rank;
        this.username = username;
        this.amtRecycled = amtRecycled;
    }

    public int getRank() {
        return rank;
    }

    public String getUsername(){
        return username;
    }

    public int getAmtRecycled(){
        return amtRecycled;
    }

    public int updateAmt(int amt){
        return (amtRecycled += amt);
    }

    public int updateRank(int place){
        return (rank = place);
    }
}
