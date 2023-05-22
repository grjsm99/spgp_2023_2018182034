package tukorea.ge.spgp2018182034.paladog.framework;

import android.renderscript.Float2;
import android.util.Log;

import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;

public class Enemy extends Minion {
    public Enemy(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount,resSizeRate, xSize, ySize, xPos, yPos, hp, moveSpeed, atkSpped, dmg);
    }

    @Override
    public void update() {
        super.update();
    }
}
