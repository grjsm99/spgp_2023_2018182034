package tukorea.ge.spgp2018182034.paladog.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import tukorea.ge.spgp2018182034.paladog.framework.AnimSprite;
import tukorea.ge.spgp2018182034.paladog.framework.IGameObject;
import tukorea.ge.spgp2018182034.paladog.framework.Metrics;

public class Attack implements IGameObject {

    protected float x = 0;
    protected float y = 0;      // 월드 좌표값

    private float atkSpeed;
    protected AnimSprite animSprite;
    public Attack(int bitmapResId, float xSize, float ySize, float xPos, float yPos, int frameCount) {
        animSprite = new AnimSprite(bitmapResId, xPos, yPos, xSize, ySize, frameCount, true);
        x = xPos;
        y = yPos;
        atkSpeed  = 0.2f;
    }

    @Override
    public void update() {
        x += atkSpeed * Metrics.elapsedTime;
        x = Math.min(x, 3.0f);
        animSprite.fixDstRect(x * Metrics.game_width, y* Metrics.game_height);

    }

    @Override
    public void draw(Canvas canvas) {
        animSprite.draw(canvas);
    }

    @Override
    public RectF getDstRect() { return animSprite.getDstRect(); }
}
