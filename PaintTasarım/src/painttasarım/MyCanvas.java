    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painttasarım;

import paintTasarim.sekil.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab
 */
public class MyCanvas extends Canvas implements MouseMotionListener, MouseListener {
     int secilen ;
     Color cizgiRenk;
    int doluRenk = 2;
    boolean isDolu = false;
    int kalinlik;

    ArrayList<Sekil> List = new ArrayList();
    ArrayList<Sekil> silinenlist = new ArrayList<>();
   

    //Siyah, Beyaz, Sarı, Kırmızı, Mavi, Gri, Pembe, Magenta, Cyan

    boolean isSecimEnabled = false;
   void setKalinlik(int kalinlik) {
        this.kalinlik = kalinlik;
    }
    public enum CIZIM_MODU {
        KARE(Kare.class), DIKDORTGEN (Dikdortgen.class), COKLUCIZGI(CokluCizgi.class), CIZGI(Cizgi.class), OVAL(Oval.class), YAY(Yay.class), YILDIZ(Yildiz.class),
        UCGEN(Ucgen.class), DIKUCGEN(DikUcgen.class), YUVARLAKDORTGEN(YuvarlakDortgen.class), BESGEN(Besgen.class),ROKET(Roket.class);
        
        private final Class<?> className;
        CIZIM_MODU(Class<?> className)
        {
            this.className = className;
        }
        public Class<?> getClassName()
        {
            return className;
        }
    }
    
 

    CIZIM_MODU suankiMod = CIZIM_MODU.CIZGI;
    ArrayList<Sekil> list = new ArrayList();

    public MyCanvas() {
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);       
    }
    
    public void temizle() {
        if (!List.isEmpty()) {
            List.clear();

            repaint();
            JOptionPane.showMessageDialog(null, null, "ekran temizlendi", WIDTH);
        } else {
            JOptionPane.showMessageDialog(null, null, "ekran temizlendi", WIDTH);
        }
    }

    public void geriAl() {
        if (!List.isEmpty()) {
            Sekil remove = List.remove(List.size() - 1);

            silinenlist.add(remove);
            //System.out.println(silinenlist);
            repaint();
        } else {
            JOptionPane.showMessageDialog(null, null, "ekran temiz", WIDTH);
        }
 
        }
    public void ileriAl(){
    /*List.add(silinenlist.get(silinenlist.indexOf(this)));
    repaint();*///çözülemedi
    }
     public void renkSec(){
      cizgiRenk = JColorChooser.showDialog(this, "RENK SEC", cizgiRenk);
       

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        for (Sekil sekil : List) {
            sekil.ciz(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         if(isSecimEnabled)
              return;
        
        if (!List.isEmpty()) {
           if (suankiMod == CIZIM_MODU.COKLUCIZGI && List.get(List.size() - 1) instanceof CokluCizgi) {
                CokluCizgi cg = (CokluCizgi) List.get(List.size() - 1);
                cg.addPoint(e.getPoint());
 
            }
           else
           {
                Sekil cg = List.get(List.size() - 1);
                cg.setBitisNoktasi(e.getPoint());
           }
            repaint(500);
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("Moved:"+e.getX() + " " + e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
        try
        {
            if(isSecimEnabled)
            {
                Rectangle rect = new Rectangle(e.getPoint(), new Dimension(8, 8));
                for(Sekil sekil : List)
                {
                    if(!sekil.intersects(rect))
                    {
                    } else {
                        sekil.ozellik.isSecili = true;
                    }
                }
            }
            else
            {
          Ozellik ozellik = new Ozellik();
        ozellik.cizgiRengi = cizgiRenk;
        ozellik.isDolu = isDolu;
        ozellik.kalinlik=kalinlik;
                Sekil yeni = (Sekil) suankiMod.getClassName().getConstructor(Point.class, Point.class, Ozellik.class).newInstance(e.getPoint(), e.getPoint(), ozellik);
                List.add(yeni);
            }
            repaint();
        } catch (Exception ex) {
            Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
