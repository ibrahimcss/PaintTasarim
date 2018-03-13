/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintTasarim.sekil;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;

/**
 *
 * @author Lab
 */
public abstract class Sekil extends Rectangle {

    protected Point baslangicNoktasi, bitisNoktasi;

    public Ozellik ozellik;
    final static float dash1[] = {10.0f};
    final static BasicStroke dashed
            = new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f);

    public Sekil(Point start, Point end, Ozellik ozellik) {
        this.baslangicNoktasi = start;
        this.bitisNoktasi = end;
        this.ozellik = ozellik;
    }

    public void ciz(Graphics g) {
        g.setColor(ozellik.cizgiRengi);
        if (ozellik.isSecili) {
            Graphics2D g2 = (Graphics2D) g;
            Stroke stroke = g2.getStroke();
            g2.setStroke(dashed);
            g2.drawRect(x - 5, y - 5, width + 10, height + 10);
            g2.setStroke(stroke);
        }
    }

    public void guncelle() {
        this.x = Math.min(baslangicNoktasi.x, bitisNoktasi.x);
        this.y = Math.min(baslangicNoktasi.y, bitisNoktasi.y);
        this.width = Math.abs(baslangicNoktasi.x - bitisNoktasi.x);
        this.height = Math.abs(baslangicNoktasi.y - bitisNoktasi.y);
    }

    public void setBitisNoktasi(Point bitisNoktasi) {
        this.bitisNoktasi = bitisNoktasi;
        guncelle();
    }

}
