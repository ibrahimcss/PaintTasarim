/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintTasarim.sekil;

import java.awt.Point;
import java.awt.Graphics;

/**
 *
 * @author HP
 */
public class DikUcgen extends Sekil {

    public DikUcgen(Point start, Point end, Ozellik ozellik) {
        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {

        int x[] = {(int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getX(), (int) bitisNoktasi.getX()};
        int y[] = {(int) baslangicNoktasi.getY(), (int) bitisNoktasi.getY(), (int) bitisNoktasi.getY()};
       
         if(ozellik.isDolu){
        g.fillPolygon(x, y, 3);
        }else{
        g.drawPolygon(x, y, 3);
        }
        

    }

}
