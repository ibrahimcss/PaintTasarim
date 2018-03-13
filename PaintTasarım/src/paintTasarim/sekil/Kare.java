/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintTasarim.sekil;

import java.awt.Graphics;
import java.awt.Point;
import painttasarım.MyCanvas;

/**
 *
 * @author Lab
 */
public class Kare extends Sekil {

    public Kare(Point start, Point end, Ozellik ozellik) {
        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        int boyut = Math.min(width, height);
        if(ozellik.isDolu){
        g.fillRect(x, y, boyut, boyut);
        }else{
        g.drawRect(x, y, boyut, boyut);
        }
        
        
       
        
        
        /* if (bitisNoktasi.getX() > baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawRect((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()));
        } else if (baslangicNoktasi.getX() > bitisNoktasi.getX() && baslangicNoktasi.getY() > bitisNoktasi.getY()) {
            g.drawRect((int) bitisNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()));
        } else if (bitisNoktasi.getX() < baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawRect((int) bitisNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()));
        } else {
            g.drawRect((int) baslangicNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()),(int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()));
        }*/

    }

}
