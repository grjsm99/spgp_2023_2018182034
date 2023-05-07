package tukorea.ge.spgp2018182034.paladog.game;


import android.util.Log;
import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.IButtonReact;
import tukorea.ge.spgp2018182034.paladog.framework.UI;
import tukorea.ge.spgp2018182034.paladog.framework.UIButton;

public class MainScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();


    public MainScene() {
        add(new UI(R.mipmap.stagebg, 0.5f, 0.5f, 1, 1, 1));
        add(new UIButton(R.mipmap.stage1button, R.mipmap.stage1button, 0.2f, 0.3f, 0.2f, 0.15f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                new PlayScene(0).pushScene();
            }
        }));

        add(new UIButton(R.mipmap.stage2button, R.mipmap.stage2button, 0.45f, 0.3f, 0.2f, 0.15f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                new PlayScene(1).pushScene();
            }
        }));

        add(new UIButton(R.mipmap.stage3button, R.mipmap.stage3button, 0.7f, 0.3f, 0.2f, 0.15f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                new PlayScene(2).pushScene();
            }
        }));

        add(new UIButton(R.mipmap.cancelbutton,R.mipmap.cancelbutton_pressed, 0.92f, 0.12f, 0.1f, 0.1f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {

                    BaseScene.popScene();
                }
            }
        }));

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
