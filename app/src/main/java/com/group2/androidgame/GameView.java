package com.group2.androidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;
import java.util.Queue;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    MainThread thread;

    //These are the sprites for the ship and lasers
    private final Bitmap shipSprite = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.spaceship), 200, 200, false);
    private final Bitmap laserSprite = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.laser), 100, 160, false);
    private final Bitmap asteroidSprite = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.asteroid), 125, 125, false);
    static Queue<Laser> laserList = new LinkedList<>();
    static Queue<Enemy> enemyList = new LinkedList<>();
    Ship ship = new Ship(shipSprite);

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    //Called by MainThread class, updates every frame, about 60 times per second
    public void update() {
        for (Laser laser : laserList) {
            laser.update();
        }
        for (Enemy enemy : enemyList) {
            enemy.update();
        }
    }

    //things that need to happen every 10 frames, roughly once every tenth of a second
    public void update10() {
        //laserList.add(new Laser(laserSprite));
        laserList.add(new Laser(laserSprite));
        enemyList.add(new Enemy(asteroidSprite));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.BLACK);
            //Go through arraylist and draw each
            Ship.draw(canvas);
            for (Laser laser : laserList) {
                laser.draw(canvas);
            }
            for (Enemy enemy : enemyList) {
                enemy.draw(canvas);
            }

        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    //Ship follows where you touch on screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
            Ship.update(event.getX()-100, event.getY()-100);
            invalidate();
            return true;
    }


}
