package com.example.sping_portfolio.controllers.LucasPackage;


import java.util.ArrayList;

public class LucasWhile extends LucasNumbers {
    public LucasWhile (int nth){
        super(nth);
        algoName = "While";
    }
    public ArrayList calculate(){
        if (sequenceSize == 1){
            lucasSequence.add(0,currentTerm);
            return lucasSequence;
        }
        else if(sequenceSize == 2){
            lucasSequence.add(0,currentTerm);
            lucasSequence.add(1,nextTerm);
            return lucasSequence;
        }
        else{
            int counter = 2;
            lucasSequence.add(0,currentTerm);
            lucasSequence.add(1,nextTerm);
            while (counter < sequenceSize){
                lucasSequence.add(counter, currentTerm + nextTerm);
                int temp = currentTerm;
                currentTerm = nextTerm;
                nextTerm += temp;
                counter += 1;
            }
            return lucasSequence;
        }
    }
}
