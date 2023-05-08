package tukorea.ge.spgp2018182034.paladog.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import tukorea.ge.spgp2018182034.paladog.R;
import tukorea.ge.spgp2018182034.paladog.framework.Ally;
import tukorea.ge.spgp2018182034.paladog.framework.Attack;
import tukorea.ge.spgp2018182034.paladog.framework.BaseScene;
import tukorea.ge.spgp2018182034.paladog.framework.Enemy;
import tukorea.ge.spgp2018182034.paladog.framework.Gauge;
import tukorea.ge.spgp2018182034.paladog.framework.IButtonReact;
import tukorea.ge.spgp2018182034.paladog.framework.IGameObject;
import tukorea.ge.spgp2018182034.paladog.framework.Metrics;
import tukorea.ge.spgp2018182034.paladog.framework.MovableUI;
import tukorea.ge.spgp2018182034.paladog.framework.Number;
import tukorea.ge.spgp2018182034.paladog.framework.Paladog;
import tukorea.ge.spgp2018182034.paladog.framework.UI;
import tukorea.ge.spgp2018182034.paladog.framework.UIButton;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;

public class PlayScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();
    private Paladog paladog;

    private float currFood;
    private float maxFood;
    private float currMP;
    private float maxMP;

    private Number foodNum;
    private Number mpNum;

    private Gauge foodGauge;

    private Gauge mpGauge;
    private final int bgResid[] = {
            R.mipmap.bg1,
            R.mipmap.bg2,
            R.mipmap.bg3
    };

    private final int ally1Resid[] = {
            R.drawable.ally1move,
            R.drawable.ally1move,
            R.drawable.ally1move,
            R.drawable.ally1move
    };
    private final int ally1FrameCnt[] = {
            12,12,12,12
    };
    private final int ally2Resid[] = {
            R.drawable.ally2move,
            R.drawable.ally2move,
            R.drawable.ally2move,
            R.drawable.ally2move
    };
    private final int ally2FrameCnt[] = {
            12,12,12,12
    };
    private final int ally3Resid[] = {
            R.drawable.ally3move,
            R.drawable.ally3move,
            R.drawable.ally3move,
            R.drawable.ally3move
    };
    private final int ally3FrameCnt[] = {
            12,12,12,12
    };
    public PlayScene(int stage) {

        Metrics.x_offset = 0;
        add(new MovableUI(bgResid[stage], 0.5f, 0.25f, 3, 0.6f, 1));
        add(new UI(R.mipmap.playui, 0.5f, 0.75f, 1, 0.6f, 1));
        add(new UIButton(R.mipmap.rightmove,R.mipmap.rightmove_pressed, 0.38f, 0.915f, 0.223f, 0.17f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                // 버튼이 안눌린 경우 팔라독의 상태를 바꾸어준다.
                if(eventType == MotionEvent.ACTION_UP) {
                    paladog.setReverse(false);
                    paladog.ChangeState(Unit.unitState.IDLE);
                }
                else if(eventType == MotionEvent.ACTION_DOWN) {
                    paladog.setReverse(false);
                    paladog.ChangeState(Unit.unitState.MOVE);
                }
            }
        }));
        add(new UIButton(R.mipmap.leftmove,R.mipmap.leftmove_pressed, 0.13f, 0.915f, 0.22f, 0.17f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                // 버튼이 안눌린 경우 팔라독의 상태를 바꾸어준다.
                if(eventType == MotionEvent.ACTION_UP) {
                    paladog.setReverse(false);
                    paladog.ChangeState(Unit.unitState.IDLE);
                }
                else if(eventType == MotionEvent.ACTION_DOWN) {
                    paladog.setReverse(true);
                    paladog.ChangeState(Unit.unitState.MOVE);
                }
            }
        }));

        add(new UIButton(R.mipmap.cancelbutton,R.mipmap.cancelbutton_pressed, 0.9f, 0.1f, 0.1f, 0.1f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {

                    BaseScene.popScene();
                }
            }
        }));

        add(new UIButton(R.mipmap.ally1button,R.mipmap.ally1button_pressed, 0.11f, 0.715f, 0.14f, 0.14f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    if(foodNum.getNumber() >= 10) {
                        foodNum.addNumber(-10);
                        add(new Ally(ally1Resid, ally1FrameCnt, 0.13f, 0.13f, 0.f, 0.4f - 0.13f / 2, 10.f, 0.35f, 1.f, 2.f));
                    }
                }
            }
        }));

        add(new UIButton(R.mipmap.ally2button,R.mipmap.ally2button_pressed, 0.3f, 0.715f, 0.14f, 0.14f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    if(foodNum.getNumber() >= 30) {
                        foodNum.addNumber(-30);
                        add(new Ally(ally2Resid, ally2FrameCnt, 0.2f, 0.23f, 0.0f, 0.4f - 0.23f / 2, 30.f, 0.1f, 2.f, 10.f));
                    }
                }
            }
        }));

        add(new UIButton(R.mipmap.ally3button,R.mipmap.ally3button_pressed, 0.49f, 0.715f, 0.14f, 0.14f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    if(foodNum.getNumber() >= 40) {
                        foodNum.addNumber(-40);
                        add(new Ally(ally3Resid, ally3FrameCnt, 0.2f, 0.23f, 0.0f, 0.4f - 0.23f / 2, 30.f, 0.8f, 2.f, 10.f));
                    }
                }
            }
        }));


        add(new UIButton(R.mipmap.atk1button,R.mipmap.atk1button_pressed, 0.58f, 0.91f, 0.1f, 0.2f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    if (mpNum.getNumber() > 1 && paladog.GetState() != Unit.unitState.ATTACK) {
                        paladog.attack();
                        mpNum.addNumber(-1);
                        add(new Attack(R.mipmap.atk1, 0.1f, 0.1f, paladog.getXPos(), paladog.getYPos() / Metrics.game_height - 0.06f, 1));
                    }
                }
            }
        }));

        int paladogRes[] = new int[4];
        int paladogFramecnt[] = new int[4];
        paladogRes[0] = R.drawable.paladogidle;
        paladogFramecnt[0] = 12;
        paladogRes[1] = R.drawable.paladogmove;
        paladogFramecnt[1] = 12;

        paladogRes[2] = R.drawable.paladogattack;
        paladogFramecnt[2] = 10;
        paladogRes[3] = R.drawable.paladogidle;
        paladogFramecnt[3] = 12;
        paladog = new Paladog(paladogRes, paladogFramecnt, 0.2f, 0.2f, 0.5f, 0.4f - 0.2f / 2, 100,  0.2f);

        foodNum = new Number(R.drawable.num, 0.313f, 0.55f, 0.04f, 0.04f, 50);
        mpNum = new Number(R.drawable.num, 0.9f, 0.55f, 0.04f, 0.04f, 10);

        foodGauge = new Gauge(R.mipmap.foodgauge, 0.21f, 0.568f, 0.24f, 0.03f, 1);
        mpGauge = new Gauge(R.mipmap.mpgauge, 0.79f, 0.568f, 0.24f, 0.03f, 1);

        add(foodGauge);
        add(mpGauge);
        add(foodNum);
        add(mpNum);

        //add(paladog);
    }

    @Override
    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
        paladog.update();
        checkCollision();
        foodNum.setNumber(Math.min(foodNum.getNumber() + Metrics.elapsedTime, 100));
        mpNum.setNumber(Math.min(mpNum.getNumber() + Metrics.elapsedTime * 0.5f, 100));
        foodGauge.setPercent(foodNum.getNumber());
        mpGauge.setPercent(mpNum.getNumber());

        for (IGameObject gobj : enemies) {
            Enemy enemy = (Enemy)gobj;
            if(enemy.isDead()) enemies.remove(gobj);
        }

        for (IGameObject gobj : allies) {
            Ally ally = (Ally)gobj;
            if(ally.isDead()) allies.remove(gobj);
        }
    }

    private void checkCollision() {
        Enemy forwardEnemy = null;
        Ally forwardAlly = null;

        if(allies.size() > 0)
            forwardAlly = (Ally)allies.get(0);
        if(enemies.size() > 0)
            forwardEnemy = (Enemy)enemies.get(0);

        if(attacks.size() > 0 && forwardEnemy != null) {
            IGameObject attack = attacks.get(0);
            if(attack.getDstRect().contains(forwardEnemy.getDstRect())) {
                attacks.remove(attack);
                forwardEnemy.ChangeState(Unit.unitState.DIE);
            }
        }

        if(forwardAlly != null) {
            for(IGameObject enemyObj : enemies) {
                Enemy enemy = (Enemy)enemyObj;
                // 이동하다 맨앞의 적을 만난경우
                if(enemy.GetState() == Unit.unitState.MOVE && forwardAlly.GetState() != Unit.unitState.DIE) {
                    if(enemy.getDstRect().contains(forwardAlly.getDstRect())) {
                        enemy.setTargetUnit(forwardAlly);
                    }
                }
            }
        }

        if(forwardEnemy != null) {
            for(IGameObject allyObj : allies) {
                Ally ally = (Ally)allyObj;
                // 이동하다 맨앞의 적을 만난경우
                if(ally.GetState() == Unit.unitState.MOVE && forwardEnemy.GetState() != Unit.unitState.DIE) {
                    if(ally.getDstRect().contains(forwardEnemy.getDstRect())) {
                        ally.setTargetUnit(forwardEnemy);
                    }
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(super.onTouchEvent(event)) {
            return true;
        }
        return true;
    }
    private float t = 1.0f;
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(paladog.getReverse()) {
            canvas.save();
            t-=0.001f;

            canvas.scale(-1, 1);
            paladog.draw(canvas);

            canvas.restore();
        }
        else {
            paladog.draw(canvas);
        }

    }
}