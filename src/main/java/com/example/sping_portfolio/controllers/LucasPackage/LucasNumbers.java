package com.example.sping_portfolio.controllers.LucasPackage;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public abstract class LucasNumbers {
    protected int currentTerm;
    protected int nextTerm;
    public int sequenceSize;
    public ArrayList<Integer> lucasSequence;
    public String algoName;
    public Duration timeElapsed;
    public LucasNumbers(){
        this(20);
    }
    public LucasNumbers(int nth){
        sequenceSize = nth;
        currentTerm = 2;
        nextTerm = 1;
        lucasSequence = new ArrayList<>();
        Instant start = Instant.now();  // time capture -- start
        this.calculate();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);

    }
    abstract ArrayList calculate();

    /*
    public void print() {
        println("Sequence Size = " + this.sequenceSize);
        ConsoleMethods.println("Lucas Numbers are ");
        for (int i=0 ; i<this.sequenceSize; i++ ) {
            ConsoleMethods.println(this.lucasSequence.get(i));
        }
    }

     */
}

