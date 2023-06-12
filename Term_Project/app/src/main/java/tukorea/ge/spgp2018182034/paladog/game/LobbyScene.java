package tukorea.ge.spgp2018182034.paladog.game;

import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.IButtonReact;
import tukorea.ge.spgp2018182034.paladog.framework.MainScene;
import tukorea.ge.spgp2018182034.paladog.framework.UI;
import tukorea.ge.spgp2018182034.paladog.framework.UIButton;

public class LobbyScene extends BaseScene {


    public LobbyScene() {

        add(new UI(R.mipmap.lobbytitle, 0.5f, 0.5f, 1, 1, 1));
        add(new UIButton(R.mipmap.startbutton, R.mipmap.startbutton_pressed, 0.8f, 0.85f, 0.3f, 0.2f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    new MainScene().pushScene();
                }
            }
        }));
        add(new UI(R.drawable.paladogidle, 0.16f, 0.6f, 0.24f, 0.24f, 12));
    }

    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
