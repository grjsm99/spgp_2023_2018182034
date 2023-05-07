package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;

public class Gauge extends UI {

    private float baseX;
    private float baseY;
    private float baseWidth;
    private float baseHeight;
    float gaugePercent;
    public Gauge(int bitmapResId, float cx, float cy, float width, float height, int frameCount) {
        super(bitmapResId, cx, cy, width, height, frameCount);
        baseX = cx * Metrics.game_width;
        baseY = cy * Metrics.game_height;
        baseWidth = width * Metrics.game_width;
        baseHeight = height * Metrics.game_height;
        setPercent(0);
    }

    public void setPercent(float percent) {
        // 게이지 퍼센트만큼 중점을 왼쪽으로 밀어주고, width값을 키워준다
        gaugePercent = percent;
        animSprite.fixDstRect(baseX - baseWidth / 200 * (100 - gaugePercent), baseY, baseWidth * gaugePercent / 100, baseHeight);
    }



}
