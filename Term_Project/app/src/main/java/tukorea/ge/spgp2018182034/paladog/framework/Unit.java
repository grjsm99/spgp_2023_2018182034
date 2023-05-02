package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;



public class Unit implements IGameObject {

    private enum unitState {
        IDLE,
        MOVE,
        ATTACK,
        DIE,
        NUM,
    }
    protected AnimSprite[] animSprites;
    protected unitState currState;
    protected float moveSpeed;
    protected float hp;
    protected float atkSpeed;
    
    protected float x;
    protected float y;      // 월드 좌표값

    // 단독으로 생성자 호출 불가. => minion, enemy로 만들어야함
    protected Unit(int[] resID, int[] resFrameCount, float xSize, float ySize, float xPos, float yPos) {
        for(int i=0; i<4; ++i)
            animSprites[i] = new AnimSprite(resID[i], xPos, yPos, xSize, ySize, resFrameCount[i], true);
    }
    @Override
    public void update() {
        // 현재 그려지고 있는 상태의 sprite만 위치를 업데이트 해준다.
        if(currState == unitState.MOVE) {
            x += moveSpeed * Metrics.elapsedTime;
            animSprites[currState.ordinal()].fixDstRect(x, y);
        }
    }

    public void ChangeState(unitState state) {
        // 해당 상태로 바꾼후 처음부터 다시 실행한다. (loop가 없는 animSprite의 경우)
        currState = state;
        update();
        animSprites[currState.ordinal()].ResetFrame();
    }

    @Override
    public void draw(Canvas canvas) {
        animSprites[currState.ordinal()].draw(canvas);
    }

}
