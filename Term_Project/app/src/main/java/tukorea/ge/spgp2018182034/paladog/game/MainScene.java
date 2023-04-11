package tukorea.ge.spgp2018182034.paladog.game;


import android.util.Log;
import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;

public class MainScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();


    public MainScene() {

    }

    @Override
    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
        checkCollision();
    }

    private void checkCollision() {

    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {

        }
        return super.onTouchEvent(event);
    }
}
