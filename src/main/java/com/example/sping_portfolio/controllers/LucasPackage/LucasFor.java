package com.example.sping_portfolio.controllers.LucasPackage;

import java.util.ArrayList;

public class LucasFor extends LucasNumbers {
    public LucasFor(int nth){
        super(nth);
        algoName = "For";
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
            lucasSequence.add(0,currentTerm);
            lucasSequence.add(1,nextTerm);

            for(int i = 2; i < sequenceSize; i++){
                lucasSequence.add(i, currentTerm + nextTerm);
                int temp = currentTerm;
                currentTerm = nextTerm;
                nextTerm += temp;
            }
            return lucasSequence;
        }
    }
}
