/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

/**
 *
 * @author USER
 */
public class badsquid {

    Image img;
    public int x = 0;
    public int y = (int) ((Math.random() * 200) +450);
    public int count = 0;

    badsquid() {
        String imageLocation = "image/badsq.png";
        URL imageURL1 = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x += 2;
                if (x >= 1100) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 50, 50));
    }
}
