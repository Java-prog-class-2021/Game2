package com.group2.androidgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ship {
    private static Bitmap image;
    static double shipX, shipY;

    Ship (Bitmap sprite) {
        image = sprite;
        shipX = 440;
        shipY = 860;
    }

    //draw and update methods
    public static void draw(Canvas canvas) {
        canvas.drawBitmap(image, (int)shipX, (int)shipY, null);
    }

    public static void update(double x, double y) {
        shipX = x;
        shipY = y;
    }
}
