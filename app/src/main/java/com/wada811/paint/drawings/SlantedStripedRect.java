package com.wada811.paint.drawings;


import android.graphics.Canvas;
import android.graphics.RectF;
import com.wada811.paint.tools.Brush;

public class SlantedStripedRect extends Rect {

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        float stripePadding = 15.0f;
        drawSlantedStripes(canvas, rect, stripePadding);
    }

    private void drawSlantedStripes(Canvas canvas, RectF rect, float stripeOffset){
        float _stripeOffset = 0.0f;
        int stripeVerticallyCount = (int)(rect.width() / stripeOffset);
        int stripeHorizontallyCount = (int)(rect.height() / stripeOffset);
        int stripeMinCount = Math.min(stripeVerticallyCount, stripeHorizontallyCount);
        int stripeMaxCount = Math.max(stripeVerticallyCount, stripeHorizontallyCount);
        float half_circumferential = rect.width() + rect.height();
        for(int stripeIndex = 0; _stripeOffset <= half_circumferential; stripeIndex++, _stripeOffset += stripeOffset){
            if(stripeIndex <= stripeMinCount){
                canvas.drawLine(
                    rect.left,
                    rect.top + _stripeOffset,
                    rect.left + _stripeOffset,
                    rect.top,
                    Brush.getPen()
                );
            }else if(stripeIndex <= stripeMaxCount){
                if(stripeMinCount == stripeVerticallyCount){ // 縦長長方形
                    canvas.drawLine(
                        rect.left,
                        rect.top + _stripeOffset,
                        rect.right,
                        rect.top + _stripeOffset - rect.width(),
                        Brush.getPen()
                    );
                }else{ // 横長長方形
                    canvas.drawLine(
                        rect.left + _stripeOffset - rect.height(),
                        rect.bottom,
                        rect.left + _stripeOffset,
                        rect.top,
                        Brush.getPen()
                    );
                }
            }else{
                if(stripeMinCount == stripeVerticallyCount){ // 縦長長方形
                    canvas.drawLine(
                        rect.left + _stripeOffset - rect.height(),
                        rect.bottom,
                        rect.right,
                        rect.top + _stripeOffset - rect.width(),
                        Brush.getPen()
                    );
                }else{ // 横長長方形
                    canvas.drawLine(
                        rect.left + _stripeOffset - rect.height(),
                        rect.bottom,
                        rect.right,
                        rect.top + _stripeOffset - rect.width(),
                        Brush.getPen()
                    );
                }
            }
        }
    }
}
