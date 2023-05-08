package tukorea.ge.spgp2018182034.paladog.framework;

import android.graphics.Canvas;
import android.graphics.RectF;

public interface IGameObject {

    public void update();
    public void draw(Canvas canvas);
    public RectF getDstRect();
}
