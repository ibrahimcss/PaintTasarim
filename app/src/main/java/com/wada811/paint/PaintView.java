package com.wada811.paint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.wada811.paint.drawings.Drawing;
import com.wada811.paint.drawings.Eraser;
import com.wada811.paint.helper.ScreenInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This is our main View class.
 */
public class PaintView extends View {

    private Context context;
    private Bitmap bitmap;
    private Canvas canvas;
    private boolean isMoving;
    private Drawing drawing;
    private float penX, penY;
    private int bgColor;


    /**
     * Set the shape that is drawing.
     *
     * @param drawing Which shape to drawing current.
     */
    public void setDrawing(Drawing drawing){
        this.drawing = drawing;
    }

    public PaintView(Context context){
        super(context);
        context = context;
        // Get the information about the screen.
        ScreenInfo screenInfo = new ScreenInfo((Activity)context);

        /**
         * Create a bitmap with the size of the screen.
         */
        bitmap = Bitmap.createBitmap(
            screenInfo.getWidthPixels(), screenInfo.getHeightPixels(), Bitmap.Config.ARGB_8888
        );

        canvas = new Canvas(bitmap);

        // Set the background color
        canvas.drawColor(getResources().getColor(R.color.color_default_bg));

        isMoving = false;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // Draw the bitmap
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.DITHER_FLAG));

        // Call the drawing's draw() method.
        if(drawing != null && isMoving == true){
            drawing.draw(canvas);
        }

        if(!(drawing instanceof Eraser)){
            // Drawing a brush icon in this view.
            Bitmap pen = BitmapFactory.decodeResource(
                getResources(), R.drawable.pen
            );
            canvas.drawBitmap(
                pen, penX, penY - pen.getHeight(), new Paint(Paint.DITHER_FLAG)
            );
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                fingerDown(x, y);
                reDraw();
                break;
            case MotionEvent.ACTION_MOVE:
                fingerMove(x, y);
                reDraw();
                break;
            case MotionEvent.ACTION_UP:
                fingerUp(x, y);
                reDraw();
                break;
        }

        return true;
    }

    /**
     * Refresh the view, the view's onDraw() method will be called.
     */
    private void reDraw(){
        invalidate();
    }

    /**
     * Handles the action of finger up.
     *
     * @param x coordinate
     * @param y coordinate
     */
    private void fingerUp(float x, float y){
        penX = 0;
        penY = 0;

        drawing.fingerUp(x, y, canvas);
        isMoving = false;
    }

    /**
     * Handles the action of finger Move.
     *
     * @param x coordinate
     * @param y coordinate
     */
    private void fingerMove(float x, float y){
        penX = x;
        penY = y;
        isMoving = true;

        drawing.fingerMove(x, y, canvas);
    }

    /**
     * Handles the action of finger down.
     *
     * @param x coordinate
     * @param y coordinate
     */
    private void fingerDown(float x, float y){
        isMoving = false;
        drawing.fingerDown(x, y, canvas);
    }

    /**
     * Check the sdcard is available or not.
     */
    public void saveBitmap(){
        String state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){
            saveToSdcard();
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            Toast.makeText(
                context, getResources().getString(R.string.tip_sdcard_is_read_only), Toast.LENGTH_LONG
            ).show();
        }else{
            Toast.makeText(
                context, getResources().getString(
                    R.string.tip_sdcard_is_not_available
                ), Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void changeBgColor(int color){
        canvas.drawColor(color);
        reDraw();
    }

    /**
     * Clear the drawing in the canvas.
     */
    public void clearCanvas(){
        canvas.drawColor(getResources().getColor(R.color.color_default_bg));
        reDraw();
    }

    /**
     * Save the bitmap to sdcard.
     */
    private void saveToSdcard(){
        File sdcard_path = Environment.getExternalStorageDirectory();
        String myFloder = getResources().getString(
            R.string.folder_name_in_sdcard
        );
        File paintpad = new File(sdcard_path + "/" + myFloder + "/");
        try{
            if(!paintpad.exists()){
                paintpad.mkdirs();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        // Set format
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

        // Get date
        Date date = Calendar.getInstance().getTime();

        // Get formatted time stamp
        String timeStamp = format.format(date);

        String suffixName = ".png";

        String fullPath = "";
        fullPath = sdcard_path + "/" + myFloder + "/" + timeStamp + suffixName;
        try{
            Toast.makeText(
                context, getResources().getString(R.string.tip_save_to) + fullPath, Toast.LENGTH_LONG
            ).show();
            bitmap.compress(
                Bitmap.CompressFormat.PNG, 100, new FileOutputStream(fullPath)
            );
        }catch(FileNotFoundException e){
            Toast.makeText(
                context, getResources().getString(R.string.tip_sava_failed) + fullPath, Toast.LENGTH_LONG
            ).show();
            e.printStackTrace();
        }
    }
}
