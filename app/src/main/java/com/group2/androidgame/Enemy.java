package com.group2.androidgame;

import androidx.constraintlayout.core.widgets.Rectangle;

public class Enemy extends Rectangle {
    static final int W = 80;
    static final int H = 80;

    Enemy(int x, int y, int w, int h){
        this.x =x;
        this.y = y;
        width = W;
        height = H; //test
    }
}
