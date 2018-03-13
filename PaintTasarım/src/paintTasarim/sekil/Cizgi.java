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
public class Cizgi extends Sekil {

    public Cizgi(Point start, Point end, Ozellik ozellik) {
        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        
        g.drawLine((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) bitisNoktasi.getX(), (int) bitisNoktasi.getY());

    }

}
