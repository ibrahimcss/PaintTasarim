/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintTasarim.sekil;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Teknosa
 */
public class YuvarlakDortgen extends Sekil {

    public YuvarlakDortgen(Point start, Point end, Ozellik ozellik) {
        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        
         if(ozellik.isDolu){
                 g.fillRoundRect(x, y, width, height, 50, 50);

        }else{
         g.drawRoundRect(x, y, width, height, 50, 50);
        }
       
    
    }

}
