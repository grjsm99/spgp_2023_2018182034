package tukorea.ge.spgp2018182034.paladog.framework;

import tukorea.ge.spgp2018182034.paladog.framework.Sprite;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;

public class Minion extends Sprite implements Unit {
    public Minion(int bitmapResId, float cx, float cy, float width, float height, boolean isAnim) {
        super(bitmapResId, cx, cy, width, height, isAnim);
    }
}
