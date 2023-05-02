package tukorea.ge.spgp2018182034.paladog.game;

import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.UI;

public class PlayScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();


    public PlayScene() {
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