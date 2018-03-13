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
 * @author Lab
 */
public class Dikdortgen extends Sekil {

    public Dikdortgen(Point start, Point end, Ozellik ozellik) {
        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
       
         if(ozellik.isDolu){
        g.fillRect(x, y, width, height);
        }else{
         g.drawRect(x, y, width, height);
        }
       

        /*if (bitisNoktasi.getX() > baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawRect((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (baslangicNoktasi.getX() > bitisNoktasi.getX() && baslangicNoktasi.getY() > bitisNoktasi.getY()) {
            g.drawRect((int) bitisNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (bitisNoktasi.getX() < baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawRect((int) bitisNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else {
            g.drawRect((int) baslangicNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        }*/
    }

}
