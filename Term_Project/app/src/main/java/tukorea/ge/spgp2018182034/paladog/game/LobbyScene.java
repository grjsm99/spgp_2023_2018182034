package tukorea.ge.spgp2018182034.paladog.game;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.Metrics;
import tukorea.ge.spgp2018182034.paladog.framework.UI;

public class LobbyScene extends BaseScene {


    public LobbyScene() {
        add(new UI(R.mipmap.lobby, Metrics.game_width/2, Metrics.game_height/2, 1, 1, false));
    }

    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
    }

}
