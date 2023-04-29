package tukorea.ge.spgp2018182034.paladog.framework;


import android.graphics.Canvas;
import android.os.Handler;
import android.view.MotionEvent;

import java.util.ArrayList;


public class BaseScene {
    private static ArrayList<BaseScene> stack = new ArrayList<>();
    public static float frameTime;
    protected static Handler handler = new Handler();

    protected ArrayList<IGameObject> UISprites = new ArrayList<>();
    protected ArrayList<IGameObject> attacks = new ArrayList<>();
    protected ArrayList<IGameObject> minions = new ArrayList<>();
    protected ArrayList<IGameObject> enemies = new ArrayList<>();

    public static BaseScene getTopScene() {
        int top = stack.size() - 1;
        if (top < 0) return null;
        return stack.get(top);
    }

    public static void popAll() {
        while (!stack.isEmpty()) {
            BaseScene scene = getTopScene();
            scene.popScene();
        }
    }

    public int pushScene() {
        stack.add(this);
        return stack.size();
    }

    public void popScene() {
        stack.remove(this);
        // TODO: additional callback should be called
    }

    public void add(IGameObject gobj) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                addCaseType(gobj);
            }
        });
    }

    public void update(long elapsedNanos) {
        frameTime = elapsedNanos / 1_000_000_000f;
        for (IGameObject gobj : UISprites) {
            gobj.update();
        }
        for (IGameObject gobj : attacks) {
            gobj.update();
        }
        for (IGameObject gobj : minions) {
            gobj.update();
        }
        for (IGameObject gobj : enemies) {
            gobj.update();
        }
    }

    public void draw(Canvas canvas) {


        for (IGameObject gobj : minions) {
            gobj.draw(canvas);
        }
        for (IGameObject gobj : enemies) {
            gobj.draw(canvas);
        }
        for (IGameObject gobj : attacks) {
            gobj.draw(canvas);
        }
        for (IGameObject gobj : UISprites) {
            gobj.draw(canvas);
        }
    }

    private void removeCaseType(IGameObject object) {
        if(object instanceof UI)
            UISprites.remove(object);
        else if(object instanceof Enemy)
            enemies.remove(object);
        else if(object instanceof Minion)
            minions.remove(object);
    }

    private void addCaseType(IGameObject object) {
        if(object instanceof UI)
            UISprites.add(object);
        else if(object instanceof Enemy)
            enemies.add(object);
        else if(object instanceof Minion)
            minions.add(object);
    }
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void removeObject(IGameObject gobj) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                removeCaseType(gobj);
            }
        });
    }

}
