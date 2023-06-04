package tukorea.ge.spgp2018182034.paladog.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.renderscript.Float2;
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
import tukorea.ge.spgp2018182034.paladog.framework.Sound;
import tukorea.ge.spgp2018182034.paladog.framework.UI;
import tukorea.ge.spgp2018182034.paladog.framework.UIButton;
import tukorea.ge.spgp2018182034.paladog.framework.Unit;
import tukorea.ge.spgp2018182034.paladog.framework.resInfo;


public class PlayScene extends BaseScene {
    private static final String TAG = MainScene.class.getSimpleName();
    private Paladog paladog;

    private float currFood;
    private float maxFood;
    private float currMP;
    private float maxMP;

    private Number foodNum;
    private Number mpNum;

    private int stage;
    private float spawnMaxCooldown;
    private float spawnCooldown;
    private Gauge foodGauge;

    private Gauge mpGauge;

    private Gauge paladogGauge;

    private Gauge enemyBaseGauge;

    private Enemy enemyBase;

    public PlayScene(int stage) {
        this.stage = stage;
        //Sound.playMusic(R.raw.bg_stage);
        Sound.playEffect(R.raw.start_battle);



        spawnMaxCooldown = 2.0f - (float)stage / 5.0f;
        spawnCooldown = spawnMaxCooldown;
        Metrics.x_offset = 0;
        add(new MovableUI(resInfo.bgResid[stage], 0.5f, 0.25f, 3, 0.6f, 1));
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
                    Sound.playEffect(R.raw.buttonclick);

                    if(foodNum.getNumber() >= 10) {
                        foodNum.addNumber(-10);
                        add(new Ally(resInfo.ally1Resid, resInfo.ally1FrameCnt, resInfo.ally1sizeRate, 0.13f, 0.13f, 0.0f, 0.4f, 10.f, 0.3f, 1.f, 2.f));
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
                        add(new Ally(resInfo.ally2Resid, resInfo.ally2FrameCnt,resInfo.ally2sizeRate, 0.2f, 0.23f, 0.0f, 0.4f, 100.f, 0.1f, 2.f, 10.f));
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
                        add(new Ally(resInfo.ally3Resid, resInfo.ally3FrameCnt, resInfo.ally3sizeRate,0.2f, 0.23f, 0.0f, 0.4f, 70.f, 0.8f, 2.f, 10.f));
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
                        add(new Attack(R.mipmap.atk1, 0.1f, 0.1f, paladog.getXPos() / Metrics.game_width, paladog.getYPos() / Metrics.game_height - 0.06f, 1));
                    }
                }
            }
        }));

        add(new UIButton(R.mipmap.atk2button,R.mipmap.atk2button_pressed, 0.74f, 0.91f, 0.1f, 0.2f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    if (mpNum.getNumber() >= 5 && foodNum.getNumber() < 95) {
                        paladog.attack();
                        mpNum.addNumber(-5);
                        foodNum.addNumber(5);

                    }
                }
            }
        }));

        enemyBase = new Enemy(resInfo.enemybaseResid, resInfo.enemybaseFrameCnt, resInfo.enemybasesizeRate,0.5f, 0.5f, 3.0f, 0.4f, 100, 0.0f, 9999.f, 0.f);
        paladog = new Paladog(resInfo.paladogRes, resInfo.paladogFramecnt, resInfo.ally3sizeRate, 0.2f, 0.2f, 0.5f, 0.4f, 100,  4.0f);

        foodNum = new Number(R.drawable.num, 0.313f, 0.55f, 0.04f, 0.04f, 95);
        mpNum = new Number(R.drawable.num, 0.9f, 0.55f, 0.04f, 0.04f, 10);

        foodGauge = new Gauge(R.mipmap.foodgauge, 0.21f, 0.568f, 0.24f, 0.03f, 1);
        mpGauge = new Gauge(R.mipmap.mpgauge, 0.79f, 0.568f, 0.24f, 0.03f, 1);
        paladogGauge = new Gauge(R.mipmap.hpgauge, 0.79f, 0.38f, 0.24f, 0.03f, 1);
        enemyBaseGauge = new Gauge(R.mipmap.hpgauge, 0.79f, 0.38f, 0.24f, 0.03f, 1);

        add(foodGauge);
        add(mpGauge);
        add(foodNum);
        add(mpNum);
        add(paladogGauge);
        add(enemyBase);
        add(enemyBaseGauge);
        //add(paladog);
    }

    @Override
    public void update(long elapsedNanos) {
        super.update(elapsedNanos);

        paladog.update();
        float xpos, pPos = paladog.getXPos() / Metrics.game_width;
        if(pPos >= 0.5f && pPos <= 2.5f) xpos = 0.5f;
        else {
            if(pPos > 2.5f) xpos = pPos-2.5f;
            else xpos = pPos;
        }
        paladogGauge.setDstRect(xpos * Metrics.game_width, paladog.getYPos() - 1.6f);
        paladogGauge.setPercent(paladog.getHP());

        enemyBaseGauge.setDstRect((pPos - 3.0f) * Metrics.game_width, enemyBase.getYPos() - 1.6f);
        enemyBaseGauge.setPercent(enemyBase.getHP());

        checkCollision();
        foodNum.setNumber(Math.min(foodNum.getNumber() + Metrics.elapsedTime, 100));
        mpNum.setNumber(Math.min(mpNum.getNumber() + Metrics.elapsedTime * 0.5f, 100));
        foodGauge.setPercent(foodNum.getNumber());
        mpGauge.setPercent(mpNum.getNumber());

        for (IGameObject gobj : enemies) {
            Enemy enemy = (Enemy)gobj;
            if(enemy.isDead()) removeObject(gobj);
        }

        for (IGameObject gobj : allies) {
            Ally ally = (Ally)gobj;
            if(ally.isDead()) removeObject(gobj);
        }

        spawnCooldown -= Metrics.elapsedTime;
        if(spawnCooldown < 0) {
            spawnCooldown = spawnMaxCooldown;

            add(new Enemy(resInfo.enemy1Resid, resInfo.enemy1FrameCnt, resInfo.enemy1sizeRate, 0.12f, 0.2f, 1.0f, 0.4f, 20, -0.5f, 3.f, 5.f));
        }
    }

    private void checkCollision() {
        Enemy forwardEnemy = null;
        Unit forwardAlly = null;
        float minX = 2.0f * Metrics.game_width, maxX = 0.f;
        float xPos;


        if(attacks.size() > 0) {
            IGameObject attack = attacks.get(0);
            for(IGameObject enemyObj : enemies) {
                Enemy enemy = (Enemy)enemyObj;
                if(Unit.intersect(attack.getDstRect(),enemy.getDstRect())) {
                    removeObject(attack);
                    enemy.ChangeState(Unit.unitState.DIE);
                }
            }

        }


        for(IGameObject enemyObj : enemies) {
            Enemy enemy = (Enemy)enemyObj;
            if(enemy.hasTarget() || enemy.GetState() == Unit.unitState.DIE) continue;

            if(enemy.GetState() == Unit.unitState.MOVE)  {
                if(Unit.intersect(paladog.getDstRect(), enemy.getDstRect()))
                    enemy.setTargetUnit(paladog);
                else
                for(IGameObject allyObj : allies) {
                    // 이동하다 적을 만난경우
                    Ally ally = (Ally)allyObj;
                    if(ally.GetState() != Unit.unitState.DIE)
                    {
                        if(Unit.intersect(enemy.getDstRect(),ally.getDstRect())) {
                            enemy.setTargetUnit(ally);
                        }
                    }
                }
            }


        }


        for(IGameObject allyObj : allies) {
            Ally ally = (Ally)allyObj;
            // 이동하다 적을 만난경우
            if(ally.hasTarget() || ally.GetState() == Unit.unitState.DIE) continue;
            for(IGameObject enemyObj : enemies) {
                Enemy enemy = (Enemy)enemyObj;
                if(ally.GetState() == Unit.unitState.MOVE && enemy.GetState() != Unit.unitState.DIE) {
                    if(Unit.intersect(ally.getDstRect(),enemy.getDstRect())) {
                        ally.setTargetUnit(enemy);
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