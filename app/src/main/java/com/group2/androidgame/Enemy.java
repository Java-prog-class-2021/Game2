package com.group2.androidgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.constraintlayout.core.widgets.Rectangle;

public class Enemy extends Rectangle {
    static private Bitmap enemySprite;
    double enemyX, enemyY;

    Enemy(Bitmap sprite, double x, double y){
        enemySprite = sprite;
        enemyX = x;
        enemyY = y;
    }
    public void draw (Canvas canvas) {
        canvas.drawBitmap(enemySprite, (int)enemyX, (int)enemyY, null);
    }
    public void update(int pos) {
        enemyY += 10;
        if (enemyY <= 0) {
            GameView.enemyList.remove(pos);
        }
    }
}
