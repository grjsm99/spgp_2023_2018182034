package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Float2;
import android.util.Log;


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

    private final boolean loop[] = {
        true,
        true,
        false,
        false
    };
    protected float x = 0;
    protected float y = 0;      // 월드 좌표값
    protected float spriteY[];
    // 단독으로 생성자 호출 불가. => ally, enemy, paladog으로 만들어야함
    protected Unit(int[] resID, int[] resFrameCount, Float2[] resSizeRate, float xSize, float ySize, float xPos, float yPos, float hp, float moveSpeed) {
        animSprites = new AnimSprite[4];
        currState = unitState.IDLE;
        spriteY = new float[unitState.NUM.ordinal()];
        float dRectSizeX;
        float dRectSizeY;
        for(int i=0; i<4; ++i)
        {
            dRectSizeX = xSize * resSizeRate[i].x;
            dRectSizeY = ySize * resSizeRate[i].y;
            // yPos는 캐릭터 이미지가 그려질 위치의 맨 아래부분을 기준으로 함
            animSprites[i] = new AnimSprite(resID[i], xPos, yPos - dRectSizeY / 2, dRectSizeX, dRectSizeY, resFrameCount[i], loop[i]);
        }
        x = xPos * Metrics.game_width;
        float tmp = 0;
        for(int i=0; i<4; ++i) {
            tmp+= resSizeRate[i].y;
            spriteY[i] = ( yPos - (ySize * resSizeRate[i].y) / 2) * Metrics.game_height;
        }
        y = ( yPos - (ySize * resSizeRate[0].y) / 2) * Metrics.game_height;

        this.moveSpeed = moveSpeed;
        this.hp = hp;
    }
    @Override
    public void update() {
        // 현재 그려지고 있는 상태의 sprite만 위치를 업데이트 해준다.
        if(currState == unitState.MOVE) {
            x += moveSpeed * Metrics.elapsedTime;
        }
        animSprites[currState.ordinal()].fixDstRect(x, spriteY[currState.ordinal()]);
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
    public float getHP() { return hp; }
    @Override
    public RectF getDstRect() { return animSprites[currState.ordinal()].dstRect; }

    public void attacked(float dmg) {
        hp -= dmg;
        if(hp <= 0) ChangeState(unitState.DIE);
    }
}
