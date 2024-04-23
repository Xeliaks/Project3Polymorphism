package com.example.project3;
import com.example.project3.soundmakers.*;

import java.util.ArrayList;


public class TestSoundMakers {
    public static void main(String[] args) {
        ArrayList<SoundMaker> soundMakers = new ArrayList<>();

        soundMakers.add(new Cat());
        soundMakers.add(new Dog());
        soundMakers.add(new Cow());
        soundMakers.add(new Pig());
        soundMakers.add(new Bee());
        soundMakers.add(new Cricket());
        soundMakers.add(new Frog());

        for (SoundMaker soundMaker : soundMakers) {
            soundMaker.makeSound();
        }
    }
}
