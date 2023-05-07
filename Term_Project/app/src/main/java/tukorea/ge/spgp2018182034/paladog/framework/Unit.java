package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;


// 움직이며 상태가 있는 게임 오브젝트들
public class Unit implements IGameObject {

    public enum unitState {
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

    
    protected float x = 0;
    protected float y = 0;      // 월드 좌표값

    // 단독으로 생성자 호출 불가. => ally, enemy, paladog으로 만들어야함
    protected Unit(int[] resID, int[] resFrameCount, float xSize, float ySize, float xPos, float yPos) {
        animSprites = new AnimSprite[4];
        currState = unitState.IDLE;
        for(int i=0; i<4; ++i)
             animSprites[i] = new AnimSprite(resID[i], xPos, yPos, xSize, ySize, resFrameCount[i], true);
        x = xPos;
        y = yPos;
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

    public unitState GetState() {
        return currState;
    }

    @Override
    public void draw(Canvas canvas) {
        animSprites[currState.ordinal()].draw(canvas);
    }

    public float getXPos() { return x; }
    public float getYPos() { return y; }

}
