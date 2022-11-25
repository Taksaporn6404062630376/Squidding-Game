/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author USER
 */
public class hook extends JPanel{
    public ImageIcon imfire = new ImageIcon();
    public int y;
    public int x;
    public int count=0;
    hook(int x,int y){
        imfire = new ImageIcon(this.getClass().getResource("image/hook.png"));
        this.x=x;
        this.y=y;
    }

    public void move(){
        this.y+=1;
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,30,30));
    }
}
