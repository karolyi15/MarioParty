package Controllers.Models;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice(){
        this.random=new Random();
    }

    public int throwDice(){
        return this.random.nextInt(6);
    }
}
