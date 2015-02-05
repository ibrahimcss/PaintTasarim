package com.wada811.paint.drawings;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.wada811.paint.tools.Brush;

/**
 * A circle.
 */
public class Circle extends Drawing {

    protected RectF rect;

    public Circle(){
        rect = new RectF();
    }

    @Override
    public void draw(Canvas canvas){
        rect.set(this.startX, this.startY, this.stopX, this.stopY);
        rect.sort();
        canvas.drawCircle(
            rect.centerX(),
            rect.centerY(),
            Math.max(rect.width(), rect.height()) / 2.0f,
            Brush.getPen()
        );
    }
}
