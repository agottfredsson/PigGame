package com.company;
import java.util.Random;

public class Die {
    Random rn = new Random();

    public int roll(){
        return rn.nextInt(6 ) + 1;
    }
}
