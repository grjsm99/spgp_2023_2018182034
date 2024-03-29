package tukorea.ge.spgp2018182034.paladog.game;

import android.renderscript.Float2;

import tukorea.ge.spgp2018182034.paladog.R;

public class resInfo {
    public static final int bgResid[] = {
            R.mipmap.bg1,
            R.mipmap.bg2,
            R.mipmap.bg3
    };

    public static final int ally1Resid[] = {
            R.drawable.ally1move,
            R.drawable.ally1move,
            R.drawable.ally1attack,
            R.drawable.ally1die
    };
    public static final Float2 ally1sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.7f, 1.9f),

            new Float2(1.0f, 1.0f),
    };
    public static final int ally1FrameCnt[] = {
            12,12,16,16
    };
    public static final Float2 ally2sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
            new Float2(1.05f, 1.05f),
            new Float2(1.0f, 1.0f),
    };
    public static final int ally2Resid[] = {
            R.drawable.ally2move,
            R.drawable.ally2move,
            R.drawable.ally2attack,
            R.drawable.ally2die
    };
    public static final int ally2FrameCnt[] = {
            12,12,10,16
    };
    public static final int ally3Resid[] = {
            R.drawable.ally3move,
            R.drawable.ally3move,
            R.drawable.ally3attack,
            R.drawable.ally3die
    };
    public static final int ally3FrameCnt[] = {
            12,12,10,16
    };
    public static final Float2 ally3sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
    };

    public static final int enemy1Resid[] = {
            R.drawable.enemy1move,
            R.drawable.enemy1move,
            R.drawable.enemy1attack,
            R.drawable.enemy1die
    };
    public static final Float2 enemy1sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.2f, 1.0f),

            new Float2(1.2f, 1.2f),
    };
    public static final int enemy1FrameCnt[] = {
            12,12,10,16
    };
    public static final int enemy2Resid[] = {
            R.drawable.enemy2move,
            R.drawable.enemy2move,
            R.drawable.enemy2attack,
            R.drawable.enemy2die
    };
    public static final Float2 enemy2sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.2f, 1.0f),

            new Float2(1.2f, 1.2f),
    };
    public static final int enemy2FrameCnt[] = {
            12,12,10,16
    };

    public static final int enemy3Resid[] = {
            R.drawable.enemy3move,
            R.drawable.enemy3move,
            R.drawable.enemy3attack,
            R.drawable.enemy3die
    };
    public static final Float2 enemy3sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.2f, 1.0f),

            new Float2(1.2f, 1.2f),
    };
    public static final int enemy3FrameCnt[] = {
            12,12,10,16
    };

    public static final int enemybaseResid[] = {
            R.mipmap.enemybase,
            R.mipmap.enemybase,
            R.mipmap.enemybase,
            R.mipmap.enemybase
    };


    public static final int paladogRes[] = {
            R.drawable.paladogidle, R.drawable.paladogmove,
            R.drawable.paladogattack,
            R.drawable.paladogidle


    };
    public static final int paladogFramecnt[] = {
            12, 12, 10, 12
    };


}
