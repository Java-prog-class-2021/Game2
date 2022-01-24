package com.group2.androidgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Lasers {
    private final Bitmap image;
    private final int x;
    private int y;
    private final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public Lasers(Bitmap bmp) {
        image = bmp;
        x = 100;
        y = 100;
    }

    public void update () {
        y++;
    }
}
