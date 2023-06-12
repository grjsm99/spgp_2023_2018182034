package tukorea.ge.spgp2018182034.paladog.game;

import android.renderscript.Float2;

import tukorea.ge.spgp2018182034.paladog.game.Minion;

// 식량으로 소환하는 아군 유닛
public class Ally extends Minion {
    
    public Ally(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount, resSizeRate, xSize, ySize, xPos, yPos, hp, moveSpeed, atkSpped, dmg);
    }
}
