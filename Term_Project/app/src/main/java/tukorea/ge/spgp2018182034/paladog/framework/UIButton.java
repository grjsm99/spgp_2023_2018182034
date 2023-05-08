package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

public class UIButton extends UI implements IButtonReact {

    private final IButtonReact react;
    private final RectF rect;

    private boolean ispressed = false;
    private final Sprite pressedSprite;

    public UIButton(int bitmapResId, int pressedResId, float cx, float cy, float width, float height, int frameCount, IButtonReact react) {
        super(bitmapResId, cx, cy, width, height, frameCount);
        if(pressedResId != -1) pressedSprite = new Sprite(pressedResId, cx, cy, width, height);
        else pressedSprite = null;
        this.react = react;
        rect = new RectF(cx - width/2, cy - height/2, cx + width/2, cy+height/2);
    }

    @Override
    public void onClick(MotionEvent event) {

        react.onClick(event);

        int eventType = event.getAction();
        if(eventType == MotionEvent.ACTION_DOWN) {
            if(pressedSprite != null) ispressed = true;
        }
        else if (eventType == MotionEvent.ACTION_UP){
            ispressed = false;
        }
        Log.v("Button", "Button Pressed");
    }

    public boolean isClick(float x, float y) {
        return rect.contains(x, y);
    }

    public void releasePressed() {
        ispressed = false;
    }

    @Override
    public void draw(Canvas canvas) {
        if(ispressed) {
            if(pressedSprite != null) pressedSprite.draw(canvas);
        }
        else animSprite.draw(canvas);
    }


}

