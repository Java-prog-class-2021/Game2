package com.group2.androidgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Laser {
    static private Bitmap laserSprite;
    double posX, posY;
    private final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    Laser(Bitmap sprite) {
        laserSprite = sprite;
        posX = Ship.shipX+75;
        posY = Ship.shipY;
    }

    //draw and update methods for the laser object
    public void draw (Canvas canvas) {
        canvas.drawBitmap(laserSprite, (int)posX, (int)posY, null);
    }
    public void update() {
        posY-= 20;
        if (posY < -200 ) {
            GameView.laserList.remove(pos);
        }
    }
}
