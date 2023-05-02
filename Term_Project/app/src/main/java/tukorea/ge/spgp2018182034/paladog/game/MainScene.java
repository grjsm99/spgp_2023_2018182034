package tukorea.ge.spgp2018182034.paladog.game;


import android.util.Log;
import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.UI;

public class MainScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();


    public MainScene() {
        add(new UI(R.mipmap.papermap, 0.5f, 0.5f, 1, 1, 1));
    }

    @Override
    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
        checkCollision();
    }

    private void checkCollision() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
