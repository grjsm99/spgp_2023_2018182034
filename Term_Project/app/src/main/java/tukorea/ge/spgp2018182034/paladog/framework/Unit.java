package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;

public class Unit implements IGameObject {

    protected AnimSprite animState;
    protected float moveSpeed;
    protected float atkSpeed;

    // 단독으로 생성자 호출 불가.
    protected Unit(float cx, float cy, float width, float height) {

    }
    @Override
    public void update() {

    }

    public void ChangeAnim(int resourceId) {

    }

    @Override
    public void draw(Canvas canvas) {
        animState.draw(canvas);
    }

}
