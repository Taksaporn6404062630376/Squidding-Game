/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class homegame extends JPanel{
        private final ImageIcon feild = new ImageIcon(this.getClass().getResource("image/bg.jpg"));
	private final ImageIcon exit = new ImageIcon(this.getClass().getResource("image/exit.jpg"));
	private final ImageIcon starts = new ImageIcon(this.getClass().getResource("image/start.jpg"));
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
	homegame(){
            setLayout(null);
            BExit1.setBounds(500, 500, 300,100);
            add(BExit1);
            add(BStart);
            BStart.setBounds(500,350,300,100);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);	
	}
}
