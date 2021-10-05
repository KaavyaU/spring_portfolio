package com.example.sping_portfolio.controllers.LucasPackage;

import java.util.ArrayList;
import java.util.stream.Stream;

public class LucasStream extends LucasNumbers{
    public LucasStream(int nth){
        super(nth);
        algoName = "Stream";
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
            Stream.iterate(new int[]{2, 1}, f -> new int[]{f[1], f[0] + f[1]})
                    .limit(super.sequenceSize)
                    .forEach(f -> lucasSequence.add(0, f[0]));
            return lucasSequence;
        }
    }
}
