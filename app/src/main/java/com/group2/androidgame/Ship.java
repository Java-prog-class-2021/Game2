package com.group2.androidgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ship {
    private static Bitmap image;
    static double shipX, shipY;
    int width, height;

    Ship (Bitmap sprite) {
        image = sprite;
        shipX = 440;
        shipY = 860;
        width = 100;
        height = 100;
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
