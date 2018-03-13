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
public class Yay extends Sekil {

    public Yay(Point start, Point end, Ozellik ozellik) {

        super(start, end,ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        g.drawArc((int) baslangicNoktasi.getX(), (int) baslangicNoktasi.getY(), (int) Math.abs(bitisNoktasi.getX() - baslangicNoktasi.getX()),
                (int) Math.abs(bitisNoktasi.getY() - baslangicNoktasi.getY()), 30, 78);

    }

}
