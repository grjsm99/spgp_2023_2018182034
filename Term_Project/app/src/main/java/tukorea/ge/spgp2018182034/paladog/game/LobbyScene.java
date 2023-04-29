package tukorea.ge.spgp2018182034.paladog.game;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.Metrics;
import tukorea.ge.spgp2018182034.paladog.framework.UI;

public class LobbyScene extends BaseScene {


    public LobbyScene() {
        add(new UI(R.mipmap.lobby, 0.5f, 0.5f, 1, 1, 1));
    }

    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
    }

}
