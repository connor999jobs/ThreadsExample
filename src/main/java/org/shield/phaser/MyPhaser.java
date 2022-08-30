package org.shield.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser  {

    int nums;

    public MyPhaser(int parties, int phaseCount) {
        super(parties);
        nums = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Фаза " + phase + " завершена. \n");
        if (phase == nums || registeredParties == 0) {
            return true;
        }
        return false;
    }
}
