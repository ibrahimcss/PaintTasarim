package com.wada811.paint.drawings;

import android.graphics.Canvas;
import com.wada811.paint.tools.Brush;

/**
 * A straight line.
 */
public class StraightLine extends Drawing {

    @Override
    public void draw(Canvas canvas){
        canvas.drawLine(
            this.startX, this.startY, this.stopX, this.stopY, Brush.getPen()
        );
    }
}
