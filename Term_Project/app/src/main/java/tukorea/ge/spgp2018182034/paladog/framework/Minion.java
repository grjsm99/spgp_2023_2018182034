package tukorea.ge.spgp2018182034.paladog.framework;

import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;
// 아군 및 적군 유닛들에 대한 클래스
public class Minion extends Unit {
    protected float atkSpeed;
    protected float atkCooldown;
    protected float dmg;
    protected Unit targetUnit;      // 공격을 가할 목표

    protected float dieTime = 1.5f;
    public Minion(int[] resID, int[] resFrameCount, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount, xSize, ySize, xPos, yPos, hp, moveSpeed);
        this.atkSpeed = atkSpped;
        this.dmg = dmg;
    }

    @Override
    public void update() {
        super.update();
        // 타겟이 죽으면 타겟지정을 해제한다.
        if(targetUnit != null && targetUnit.getHP() <= 0)
            targetUnit = null;

        if(currState == unitState.MOVE) {
            x += moveSpeed * Metrics.elapsedTime;
            animSprites[currState.ordinal()].fixDstRect(x, y);
        }
        if(currState == unitState.DIE) {
            dieTime -= Metrics.elapsedTime;
        }
        if(currState == unitState.ATTACK) {
            atkCooldown -= Metrics.elapsedTime;

            if(atkCooldown < 0) {
                // 공격 애니메이션을 실행하고 현재타겟에게 데미지를 준다.
                animSprites[currState.ordinal()].ResetFrame();
                atkCooldown = atkSpeed;
            }
            if(animSprites[currState.ordinal()].getCurrFrameIndex() == 5  && targetUnit != null) {
                targetUnit.attacked(dmg);
            }
        }
    }


    public boolean isDead() { return dieTime < 0; }

    public boolean hasTarget() { return targetUnit != null; }

    public void setTargetUnit(Unit target) {
        targetUnit = target;
    }
}
