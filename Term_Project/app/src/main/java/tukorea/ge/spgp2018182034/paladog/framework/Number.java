package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.graphics.RectF;

public class Number extends UI {

    private float num;
    private float baseX;
    private float baseY;

    private float letterInterval;
    public Number(int bitmapResId, float cx, float cy, float width, float height, float num) {
        super(bitmapResId, cx, cy, width, height, 10);
        this.num = num;

        baseX = cx * Metrics.game_width;
        baseY = cy * Metrics.game_height;
        letterInterval = width;
    }


    public void setNumber(float number) { num = number; }

    @Override
    public void draw(Canvas canvas) {
        float dist = 0.f;
        int temp = (int)num;
        while(temp != 0) {
            animSprite.fixDstRect(baseX + dist, baseY);
            animSprite.drawFrame(canvas, temp % 10);
            temp/=10;
            dist -= letterInterval * Metrics.game_width * 0.9f;
        }
    }

    public void addNumber(float number) { num += number; }
    public float getNumber() { return num; }

}
