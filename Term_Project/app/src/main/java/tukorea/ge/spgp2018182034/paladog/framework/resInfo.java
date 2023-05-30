package tukorea.ge.spgp2018182034.paladog.framework;

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
            R.drawable.ally1move
    };
    public static final Float2 ally1sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.7f, 1.9f),

            new Float2(1.0f, 1.0f),
    };
    public static final int ally1FrameCnt[] = {
            12,12,16,12
    };
    public static final Float2 ally2sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),
    };
    public static final int ally2Resid[] = {
            R.drawable.ally2move,
            R.drawable.ally2move,
            R.drawable.ally2move,
            R.drawable.ally2move
    };
    public static final int ally2FrameCnt[] = {
            12,12,12,12
    };
    public static final int ally3Resid[] = {
            R.drawable.ally3move,
            R.drawable.ally3move,
            R.drawable.ally3move,
            R.drawable.ally3move
    };
    public static final int ally3FrameCnt[] = {
            12,12,12,12
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
            R.drawable.ally1attack,
            R.drawable.enemy1move
    };
    public static final Float2 enemy1sizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.7f, 1.9f),

            new Float2(1.0f, 1.0f),
    };
    public static final int enemy1FrameCnt[] = {
            12,12,16,12
    };

    public static final int enemybaseResid[] = {
            R.mipmap.enemybase,
            R.mipmap.enemybase,
            R.mipmap.enemybase,
            R.mipmap.enemybase
    };
    public static final Float2 enemybasesizeRate[] = {
            new Float2(1.0f, 1.0f),
            new Float2(1.0f, 1.0f),

            new Float2(1.7f, 1.9f),

            new Float2(1.0f, 1.0f),
    };
    public static final int enemybaseFrameCnt[] = {
            1,1,1,1
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
