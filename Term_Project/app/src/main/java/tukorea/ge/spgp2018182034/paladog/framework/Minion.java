package tukorea.ge.spgp2018182034.paladog.framework;

import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;
// 아군 및 적군 유닛들에 대한 클래스
public class Minion extends Unit {
    protected float atkSpeed;
    protected Unit targetUnit;
    public Minion(int[] resID, int[] resFrameCount, float xSize, float ySize, float xPos, float yPos) {
        super(resID, resFrameCount, xSize, ySize, xPos, yPos);
    }

    @Override
    public void update() {
        super.update();

    }
}
