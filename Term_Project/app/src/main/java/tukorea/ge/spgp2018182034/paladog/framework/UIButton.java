package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class UIButton extends UI implements IButtonReact {

    private final IButtonReact react;
    private final RectF rect;
    public UIButton(int bitmapResId, float cx, float cy, float width, float height, int frameCount, IButtonReact react) {
        super(bitmapResId, cx, cy, width, height, frameCount);
        this.react = react;
        rect = new RectF(cx - width/2, cy - height/2, cx + width/2, cy+height/2);
    }

    @Override
    public void onClick(int eventType) {
        react.onClick(eventType);
        Log.v("Button", "Button Pressed");
    }

    public boolean isClick(float x, float y) {
        return rect.contains(x, y);
    }

}

