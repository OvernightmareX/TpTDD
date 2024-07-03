package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Frame {
    private int score = 0;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        rolls = new ArrayList<>();
    }

    public boolean canMakeRoll(){
        if(lastFrame)
            return rolls.size() < 2 || (rolls.size() == 2 && (score >= 10 && score <= 20));

        return rolls.size() < 2 && score != 10;
    }

    public void makeRoll(){
        if(!canMakeRoll())
            return;

        Roll roll = new Roll(generateur.randomPin(10 - (score % 10)));
        rolls.add(roll);
        score += roll.getPins();
    }
}
