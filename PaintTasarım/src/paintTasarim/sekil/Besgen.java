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
public class Besgen extends Sekil {

    public Besgen(Point start, Point end, Ozellik ozellik) {
        super(start, end, ozellik);
    }

    @Override
    public void ciz(Graphics g) {
        super.ciz(g);
        int[] x = {(int) baslangicNoktasi.getX(),
            (int) Math.abs(baslangicNoktasi.getX() + (bitisNoktasi.getX() - baslangicNoktasi.getX()) / 4),
            (int) Math.abs(baslangicNoktasi.getX() + (bitisNoktasi.getX() - baslangicNoktasi.getX()) / 2),
            (int) bitisNoktasi.getX(), (int) Math.abs(baslangicNoktasi.getX() + (bitisNoktasi.getX() - baslangicNoktasi.getX())),
            (int) Math.abs(baslangicNoktasi.getX() + (bitisNoktasi.getX() - baslangicNoktasi.getX()) / 2)
        };

        int[] y = {(int) bitisNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getY() + (bitisNoktasi.getY() - baslangicNoktasi.getY()) / 4),
            (int) baslangicNoktasi.getY(), (int) Math.abs(baslangicNoktasi.getY() + (bitisNoktasi.getY() - baslangicNoktasi.getY()) / 4),
            (int) bitisNoktasi.getY(), (int) bitisNoktasi.getY()};

        g.drawPolygon(x, y, 6);

    }

}
