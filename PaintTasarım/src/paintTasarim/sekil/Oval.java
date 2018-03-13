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
 * @author HP
 */
public class Oval extends Sekil {

    public Oval(Point start, Point end,Ozellik ozellik) {
        super(start, end,ozellik);

    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        if(ozellik.isDolu){
        
          if (bitisNoktasi.getX() > baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.fillOval((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (baslangicNoktasi.getX() > bitisNoktasi.getX() && baslangicNoktasi.getY() > bitisNoktasi.getY()) {
            g.fillOval((int) bitisNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (bitisNoktasi.getX() < baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.fillOval((int) bitisNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else {
            g.fillOval((int) baslangicNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        }
        }else{
         if (bitisNoktasi.getX() > baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawOval((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (baslangicNoktasi.getX() > bitisNoktasi.getX() && baslangicNoktasi.getY() > bitisNoktasi.getY()) {
            g.drawOval((int) bitisNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else if (bitisNoktasi.getX() < baslangicNoktasi.getX() && bitisNoktasi.getY() > baslangicNoktasi.getY()) {
            g.drawOval((int) bitisNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        } else {
            g.drawOval((int) baslangicNoktasi.getX(), (int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getX() - bitisNoktasi.getX()), (int) Math.abs(baslangicNoktasi.getY() - bitisNoktasi.getY()));
        }
        }
       
    }

}
