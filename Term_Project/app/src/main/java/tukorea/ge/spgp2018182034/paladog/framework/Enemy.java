package tukorea.ge.spgp2018182034.paladog.framework;

import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;

public class Enemy extends Minion {
    public Enemy(int[] resID, int[] resFrameCount, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount, xSize, ySize, xPos, yPos, hp, moveSpeed, atkSpped, dmg);
    }
}
