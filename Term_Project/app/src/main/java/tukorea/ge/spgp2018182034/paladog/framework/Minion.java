package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.renderscript.Float2;
import android.util.Log;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;
// 아군 및 적군 유닛들에 대한 클래스
public class Minion extends Unit {
    protected float atkSpeed;
    protected float atkCooldown = 0.f;
    protected float dmg;
    protected Unit targetUnit;      // 공격을 가할 목표

    protected Gauge hpGauge;
    protected float yConVel = 5.f;
    protected float xConVel = 1.f;
    protected boolean isattack = false;
    protected float dieTime = 2.5f;
    public Minion(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed, float atkSpped, float dmg) {
        super(resID, resFrameCount, resSizeRate, xSize, ySize, xPos, yPos, hp, moveSpeed);
        this.atkSpeed = atkSpped;
        this.dmg = dmg;
        currState = unitState.MOVE;
        hpGauge = new Gauge(R.mipmap.hpgauge, -1.0f, 0.0f, 0.06f, 0.01f, 1);
    }

    @Override
    public void update() {
        super.update();
        if(currState == unitState.MOVE) {
            if(targetUnit != null) {
                ChangeState(unitState.ATTACK);
            }
            else {
                x += moveSpeed * Metrics.elapsedTime;
                x = Math.min(Math.max(x, 0), 2.0f * Metrics.game_width);
                animSprites[currState.ordinal()].fixDstRect(x, y);
            }

        }
        if(currState == unitState.DIE) {
            yConVel -= 14.f * Metrics.elapsedTime;
            spriteY[currState.ordinal()] = Math.min(spriteY[currState.ordinal()] - yConVel * Metrics.elapsedTime, y);
            if(dieTime > 2.0f) x -= moveSpeed / Math.abs(moveSpeed) * 5.f * Metrics.elapsedTime;
            dieTime -= Metrics.elapsedTime;
        }

        if(currState == unitState.ATTACK) {
            atkCooldown -= Metrics.elapsedTime;
            // 타겟이 죽으면 타겟지정을 해제한다.
            if(targetUnit != null && targetUnit.getHP() <= 0)
            {
                targetUnit = null;
                currState = unitState.MOVE;
            }
            if(atkCooldown < 0) {
                // 공격 애니메이션을 실행하고 현재타겟에게 데미지를 준다.
                isattack = false;
                if(targetUnit != null && !intersect(getDstRect(), targetUnit.getDstRect())) {
                    targetUnit = null;
                    currState = unitState.MOVE;
                }
                else {
                    animSprites[currState.ordinal()].ResetFrame();
                    atkCooldown = atkSpeed;
                }
            }
            if(animSprites[currState.ordinal()].getCurrFrameIndex() == 9  && targetUnit != null && !isattack) {
                if(!intersect(getDstRect(), targetUnit.getDstRect())) {
                    targetUnit = null;
                    currState = unitState.MOVE;
                }
                else {
                    Sound.playEffect(R.raw.minionattacks);
                    targetUnit.attacked(dmg);
                    isattack = true;
                }
            }

        }
        hpGauge.setPercent(hp / maxHP * 100);
        hpGauge.setDstRect(x, y - 0.8f);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        hpGauge.draw(canvas);
    }

    public boolean isDead() { return dieTime < 0; }

    public boolean hasTarget() { return targetUnit != null; }

    public void setTargetUnit(Unit target) {
        targetUnit = target;
    }
}
