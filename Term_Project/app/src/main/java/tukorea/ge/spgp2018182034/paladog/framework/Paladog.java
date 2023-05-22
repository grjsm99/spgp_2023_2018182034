package tukorea.ge.spgp2018182034.paladog.framework;

import android.renderscript.Float2;
import android.util.Log;

public class Paladog extends Unit {


    private boolean reverse = false;
    private float attackMotionTime = -1;
    public Paladog(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed) {

        super(resID, resFrameCount,resSizeRate, xSize, ySize, xPos, yPos, hp, moveSpeed);

    }

    @Override
    public void update() {
        animSprites[currState.ordinal()].fixDstRect(x, y);

        if(currState == unitState.MOVE) {
            int sign = reverse ? -1 : 1;
            x += moveSpeed * Metrics.elapsedTime * sign;
            x = Math.min(Math.max(x, 0), 2.0f * Metrics.game_width);
            animSprites[currState.ordinal()].fixDstRect(x * sign, y);

            // 팔라독의 위치에 따라 PlayScene의 카메라를 옮겨준다.
            Metrics.x_offset = -Math.round(Math.min(Math.max((x/Metrics.game_width)-0.5f, 0), 1.0f) * Metrics.view_width);

        }

        if(currState == unitState.ATTACK) {

            attackMotionTime -= Metrics.elapsedTime;

            if (attackMotionTime < 0) {

                currState = unitState.IDLE;
            }
        }
    }

    public boolean getReverse() { return reverse; }
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
        update();
    }

    public void attack() {
        attackMotionTime = 1.0f / 3.0f;
        setReverse(false);
        ChangeState(unitState.ATTACK);

    }
}
