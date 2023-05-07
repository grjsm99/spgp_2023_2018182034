package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;

public class Sprite {
    // 단일 스프라이트
    private static final String TAG = Sprite.class.getSimpleName();
    protected Bitmap bitmap;
    protected RectF dstRect = new RectF();
    protected float x, y, width, height;

    public Sprite(int bitmapResId, float cx, float cy, float width, float height) {

        this.x = cx * Metrics.game_width;
        this.y = cy * Metrics.game_height;
        this.width = width * Metrics.game_width;
        this.height = height * Metrics.game_height;

        if (bitmapResId != 0) {
            setBitmapResource(bitmapResId);
        }
        fixDstRect(this.x, this.y);

        Log.v(TAG, "Created " + this.getClass().getSimpleName() + "@" + System.identityHashCode(this));
    }

    public void setBitmapResource(int bitmapResId) {
        bitmap = BitmapManager.get(bitmapResId);
    }

    public void fixDstRect(float nx, float ny) {
        float half_width = width / 2;
        float half_height = height / 2;
        dstRect.set(nx - half_width, ny - half_height, nx + half_width, ny + half_height);
    }
    public void fixDstRect(float nx, float ny, float w, float h) {
        float half_width = w / 2;
        float half_height = h / 2;
        dstRect.set(nx - half_width, ny - half_height, nx + half_width, ny + half_height);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, dstRect, null);
    }

}
