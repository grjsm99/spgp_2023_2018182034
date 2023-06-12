package tukorea.ge.spgp2018182034.paladog.game;

import android.renderscript.Float2;

import tukorea.ge.spgp2018182034.paladog.game.Minion;

public class Enemy extends Minion {
    public Enemy(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount,resSizeRate, xSize, ySize, xPos, yPos, hp, moveSpeed, atkSpped, dmg);
    }

    @Override
    public void update() {
        super.update();
    }
}
