package com.example.sping_portfolio.controllers.LucasPackage;

import java.util.ArrayList;

public class LucasRecurse extends LucasNumbers{
    public LucasRecurse(int nth){
        super(nth);
        algoName = "Recurse";
    }

    public ArrayList calculate(){
            initRecurse(sequenceSize, new int[]{2, 1});
            return lucasSequence;
        }
    public void initRecurse(int limit, int [] seq){
        if (limit == 0) return;
        lucasSequence.add(sequenceSize-limit, seq[0]);
        // observe this syntax and function, many think of recursion as another way to do iteration
        initRecurse(--limit, new int[]{seq[1], seq[0] + seq[1]});
    }
}
