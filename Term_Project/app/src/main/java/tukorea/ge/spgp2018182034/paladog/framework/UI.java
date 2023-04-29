package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;

import tukorea.ge.spgp2018182034.paladog.framework.IGameObject;
import tukorea.ge.spgp2018182034.paladog.framework.Sprite;

public class UI implements IGameObject {

    protected AnimSprite animSprite;
    public UI(int bitmapResId, float cx, float cy, float width, float height, int frameCount) {
        animSprite = new AnimSprite(bitmapResId, cx, cy, width, height, frameCount, true);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        animSprite.draw(canvas);
    }
}