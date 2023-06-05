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
    private float spawnMaxCooldown1;
    private float spawnMaxCooldown2;
    private float spawnMaxCooldown3;
    private float spawnCooldown1;
    private float spawnCooldown2;
    private float spawnCooldown3;
    private Gauge foodGauge;

    private Gauge mpGauge;

    private Gauge paladogGauge;

    private boolean done = false;
    private float resultTime = 3.f;

    public PlayScene(int stage) {
        this.stage = stage;
        Sound.playMusic(R.raw.bg_stage);
        Sound.playEffect(R.raw.start_battle);

        spawnMaxCooldown1 = 6.0f - (float)stage / 3.0f;
        spawnMaxCooldown2 = 35.0f - (float)stage * 2.0f;
        spawnMaxCooldown3 = 8.0f - (float)stage / 2.0f;
        spawnCooldown1 = spawnMaxCooldown1;
        spawnCooldown2 = spawnMaxCooldown2;
        spawnCooldown3 = spawnMaxCooldown3;
        Metrics.x_offset = 0;
        add(new MovableUI(resInfo.bgResid[stage], 0.5f, 0.25f, 3, 0.62f, 1));
        add(new MovableUI(resInfo.enemybaseResid[0], 2.0f, 0.2f, 0.3f, 0.5f, 1));
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
                        Sound.playEffect(R.raw.unit_create);
                        foodNum.addNumber(-10);
                        add(new Ally(resInfo.ally1Resid, resInfo.ally1FrameCnt, resInfo.ally1sizeRate, 0.13f, 0.13f, 0.0f, 0.4f, 20.f, 0.5f, 1.f, 10.f));
                    }
                }
            }
        }));

        add(new UIButton(R.mipmap.ally2button,R.mipmap.ally2button_pressed, 0.3f, 0.715f, 0.14f, 0.14f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    Sound.playEffect(R.raw.buttonclick);
                    if(foodNum.getNumber() >= 30) {
                        Sound.playEffect(R.raw.unit_create);
                        foodNum.addNumber(-30);
                        add(new Ally(resInfo.ally2Resid, resInfo.ally2FrameCnt,resInfo.ally2sizeRate, 0.2f, 0.23f, 0.0f, 0.4f, 300.f, 0.25f, 3.f, 5.f));
                    }
                }
            }
        }));

        add(new UIButton(R.mipmap.ally3button,R.mipmap.ally3button_pressed, 0.49f, 0.715f, 0.14f, 0.14f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    Sound.playEffect(R.raw.buttonclick);
                    if(foodNum.getNumber() >= 40) {
                        Sound.playEffect(R.raw.unit_create);
                        foodNum.addNumber(-40);
                        add(new Ally(resInfo.ally3Resid, resInfo.ally3FrameCnt, resInfo.ally3sizeRate,0.2f, 0.23f, 0.0f, 0.4f, 50.f, 1.f, 1.f, 20.f));
                    }
                }
            }
        }));


        add(new UIButton(R.mipmap.atk1button,R.mipmap.atk1button_pressed, 0.58f, 0.91f, 0.1f, 0.2f, 1, new IButtonReact() {
            @Override
            public void onClick(MotionEvent event) {
                int eventType = event.getAction();
                if(eventType == MotionEvent.ACTION_UP) {
                    Sound.playEffect(R.raw.buttonclick);
                    if (mpNum.getNumber() > 5 && paladog.GetState() != Unit.unitState.ATTACK) {
                        paladog.attack();
                        mpNum.addNumber(-5);
                        Sound.playEffect(R.raw.paladogattack);
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
                    Sound.playEffect(R.raw.buttonclick);
                    if (mpNum.getNumber() >= 5 && foodNum.getNumber() < 95) {
                        paladog.attack();
                        mpNum.addNumber(-5);
                        foodNum.addNumber(5);

                    }
                }
            }
        }));


        paladog = new Paladog(resInfo.paladogRes, resInfo.paladogFramecnt, resInfo.ally3sizeRate, 0.2f, 0.2f, 0.5f, 0.4f, 100,  4.0f);

        foodNum = new Number(R.drawable.num, 0.313f, 0.55f, 0.04f, 0.04f, 10);
        mpNum = new Number(R.drawable.num, 0.9f, 0.55f, 0.04f, 0.04f, 10);

        foodGauge = new Gauge(R.mipmap.foodgauge, 0.21f, 0.568f, 0.24f, 0.03f, 1);
        mpGauge = new Gauge(R.mipmap.mpgauge, 0.79f, 0.568f, 0.24f, 0.03f, 1);
        paladogGauge = new Gauge(R.mipmap.hpgauge, 0.79f, 0.38f, 0.24f, 0.03f, 1);

        add(foodGauge);
        add(mpGauge);
        add(foodNum);
        add(mpNum);
        add(paladogGauge);

        //add(paladog);
    }

    @Override
    public void update(long elapsedNanos) {

        super.update(elapsedNanos);

        paladog.update();
        float xpos, pPos = paladog.getXPos() / Metrics.game_width;
        if(pPos >= 0.5f && pPos <= 1.5f) xpos = 0.5f;
        else {
            if(pPos > 1.5f) xpos = pPos-1.0f;
            else xpos = pPos;
        }
        paladogGauge.setDstRect(xpos * Metrics.game_width, paladog.getYPos() - 1.6f);
        paladogGauge.setPercent(paladog.getHP());


        checkCollision();
        foodNum.setNumber(Math.min(foodNum.getNumber() + Metrics.elapsedTime * 2.0f, 100));
        mpNum.setNumber(Math.min(mpNum.getNumber() + Metrics.elapsedTime * 2.5f, 100));
        foodGauge.setPercent(foodNum.getNumber());
        mpGauge.setPercent(mpNum.getNumber());

        for (IGameObject gobj : enemies) {
            Enemy enemy = (Enemy)gobj;
            if(enemy.isDead()) removeObject(gobj);
        }

        for (IGameObject gobj : allies) {
            Ally ally = (Ally)gobj;
            if(ally.isDead()) removeObject(gobj);
            if(ally.getXPos() > 1.95f * Metrics.game_width) {
                UIButtons.clear();
                add(new UI(R.mipmap.clear, 0.5f, 0.5f, 1, 1, 1));
                done = true;
            }
        }
        if(done) {
            resultTime -= Metrics.elapsedTime;
            if(resultTime <= 0) popScene();
        }


        if(paladog.getHP() <= 0) popScene();
        spawnCooldown1 -= Metrics.elapsedTime;
        if(spawnCooldown1 < 0) {
            spawnCooldown1 = spawnMaxCooldown1;
            add(new Enemy(resInfo.enemy1Resid, resInfo.enemy1FrameCnt, resInfo.enemy1sizeRate, 0.12f, 0.2f, 2.0f, 0.4f, 50, -0.5f, 3.f, 5.f));
        }

        spawnCooldown2 -= Metrics.elapsedTime;
        if(spawnCooldown2 < 0) {
            spawnCooldown2 = spawnMaxCooldown2;
            add(new Enemy(resInfo.enemy2Resid, resInfo.enemy2FrameCnt, resInfo.enemy2sizeRate, 0.18f, 0.3f, 2.0f, 0.4f, 300, -0.25f, 5.f, 25.f));
        }

        spawnCooldown3 -= Metrics.elapsedTime;
        if(spawnCooldown3 < 0) {
            spawnCooldown3 = spawnMaxCooldown3;
            add(new Enemy(resInfo.enemy3Resid, resInfo.enemy3FrameCnt, resInfo.enemy3sizeRate, 0.1f, 0.18f, 2.0f, 0.4f, 20, -0.8f, 3.f, 10.f));
        }
    }

    private void checkCollision() {
        if(attacks.size() > 0) {
            IGameObject attack = attacks.get(0);
            for(IGameObject enemyObj : enemies) {
                Enemy enemy = (Enemy)enemyObj;
                if(enemy.GetState() != Unit.unitState.DIE && Unit.intersect(attack.getDstRect(),enemy.getDstRect())) {
                    enemy.attacked(20);
                    removeObject(attack);
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