package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import tukorea.ge.spgp2018182034.paladog.R;


public class AnimSprite extends Sprite {

    private final int frameCount;
    protected Rect srcRect = new Rect();
    protected long createdOn;
    protected int frameWidth, frameHeight;
    protected float fps = 30.f;

    protected boolean isLoop;

    public AnimSprite(int bitmapResId, float cx, float cy, float width, float height, int frameCount, boolean isLoop) {
        super(bitmapResId, cx, cy, width, height);
        int imageWidth = bitmap.getWidth();
        frameHeight = bitmap.getHeight();
        if (frameCount == 0) {
            frameWidth = frameHeight;
            this.frameCount = imageWidth / frameHeight;
        } else {
            frameWidth = imageWidth / frameCount;
            this.frameCount = frameCount;
        }

        if(bitmapResId == R.drawable.paladogidle)
            Log.v("z", imageWidth + "입니다");
        // 이미지는 항상 1줄이여야함
        this.isLoop = isLoop;
        srcRect.set(0, 0, frameWidth, frameHeight);
        createdOn = System.currentTimeMillis();
    }

    @Override
    public void setBitmapResource(int bitmapResId) {
        bitmap = BitmapManager.get(bitmapResId);
        createdOn = System.currentTimeMillis();     // 첫 프레임부터 실행되도록 함
    }
    public void setFPS(int fps) {
        this.fps = fps;
    }

    @Override
    public void draw(Canvas canvas) {
        long now = System.currentTimeMillis();
        float time = (now - createdOn) / 1000.0f;
        // isLoop시 해당 스프라이트 애니메이션을 반복, 아닐경우 마지막 프레임에서 멈춘다.
        int frameIndex = isLoop ? Math.round(time * fps) % frameCount : Math.min(Math.round(time * fps), frameCount-1);
        srcRect.set(frameIndex * frameWidth, 0, (frameIndex + 1) * frameWidth, frameHeight);
        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }

    public void drawFrame(Canvas canvas, int frame) {
        srcRect.set(frame * frameWidth, 0, (frame + 1) * frameWidth, frameHeight);
        canvas.drawBitmap(bitmap, srcRect, dstRect, null);
    }

    public void ResetFrame() {
        createdOn = System.currentTimeMillis();
    }
}
