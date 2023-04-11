package tukorea.ge.spgp2018182034.paladog.framework;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements Choreographer.FrameCallback {
    private static final String TAG = GameView.class.getSimpleName();
    public static Resources res;
    //    private Ball ball1, ball2;
    protected Paint fpsPaint;
    protected Paint borderPaint;

    protected boolean running;

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        GameView.res = getResources();

        running = true;
        Choreographer.getInstance().postFrameCallback(this);
    }

    private long previousNanos;
    @Override
    public void doFrame(long nanos) {
        if (previousNanos != 0) {
            long elapsedNanos = nanos - previousNanos;
            BaseScene scene = BaseScene.getTopScene();
            if (scene != null) {
                scene.update(elapsedNanos);
            }
        }
        previousNanos = nanos;
        invalidate();
        if (running) {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float view_ratio = (float)w / (float)h;
        float game_ratio = Metrics.game_width / Metrics.game_height;
        if (view_ratio > game_ratio) {
            Metrics.x_offset = (int) ((w - h * game_ratio) / 2);
            Metrics.y_offset = 0;
            Metrics.scale = h / Metrics.game_height;
        } else {
            Metrics.x_offset = 0;
            Metrics.y_offset = (int)((h - w / game_ratio) / 2);
            Metrics.scale = w / Metrics.game_width;
        }

        Log.v(TAG, "w" + w + " h  " + h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(Metrics.x_offset, Metrics.y_offset);
        canvas.scale(Metrics.scale, Metrics.scale);

        BaseScene scene = BaseScene.getTopScene();
        if (scene != null) {
            scene.draw(canvas);
        }
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean handled = BaseScene.getTopScene().onTouchEvent(event);
        if (handled) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void pauseGame() {
        running = false;
    }

    public void resumeGame() {
        if (running) {
            return;
        }
        previousNanos = 0;
        running = true;
        Choreographer.getInstance().postFrameCallback(this);
    }
}