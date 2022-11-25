/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import javax.swing.*;
/**
 *
 * @author USER
 */
public class boat{
    public ImageIcon bo = new ImageIcon();
    public int x;
    public int count = 0;
    boat(){

//            String imageLocation = "b"+(i+1)+".jpg";
            bo = new ImageIcon(this.getClass().getResource("image/boat.png"));
        
    }
}
