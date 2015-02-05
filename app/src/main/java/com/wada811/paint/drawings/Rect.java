package com.wada811.paint.drawings;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.wada811.paint.tools.Brush;

/**
 * A rectangle.
 */
public class Rect extends Drawing {

    protected RectF rect;

    public Rect(){
        rect = new RectF();
    }

    @Override
    public void draw(Canvas canvas){
        rect.set(this.startX, this.startY, this.stopX, this.stopY);
        rect.sort();
        canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, Brush.getPen());
    }


}
