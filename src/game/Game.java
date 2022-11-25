/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class Game extends JFrame implements ActionListener{
    public homegame homegames1 = new homegame();
    public playstate state = new playstate();
    public Game(){
        this.setSize(1000,800);
        this.add(homegames1);
        homegames1.BExit1.addActionListener(this);
        homegames1.BStart.addActionListener(this);
        state.BExithome.addActionListener(this);
        state.BPause.addActionListener(this);
        state.Bresum.addActionListener(this);
        state.Brestart.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== homegames1.BStart){
            this.setLocationRelativeTo(null);
            this.remove(homegames1);
            this.setSize(1000,800);
            this.add(state);
            state.requestFocusInWindow();
            state.timestart = false;
            state.scor=0;
            state.HP =3;
            state.times = 60;
            state.squidrun=false;
            state.timestart=false;

        }else if(e.getSource() == state.BExithome){
            this.remove(state);
            this.setLayout(null);
            this.add(homegames1);
        }else if(e.getSource() == homegames1.BExit1){

            System.exit(0);

        }else if(e.getSource() == state.BPause){
            this.setLocationRelativeTo(null);
            this.setSize(1000,800);
            this.add(state);
            state.requestFocusInWindow();
            state.t.suspend();
            state.time.suspend();
            state.actor.suspend();
            state.tsq.suspend();
            state.tbsq.suspend();
    
        }else if(e.getSource() == state.Bresum){
            this.setLocationRelativeTo(null);
            this.setSize(1000,800);
            this.add(state);
            state.requestFocusInWindow();
            state.t.resume();
            state.time.resume();
            state.actor.resume();
            state.tsq.resume();
            state.tbsq.resume();

        }
        else if(e.getSource() == state.Brestart){
            this.setLocationRelativeTo(null);
            this.setSize(1000,800);
            this.add(state);
            state.requestFocusInWindow();
            state.timestart = false;
            state.boat.x = (int)(Math.random() * 800);
            state.scor=0;
            state.HP =3;
            state.times = 60;
            state.squidrun=false;
            state.timestart=false;

        }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args) {
        JFrame jf = new Game();
        jf.setSize(1000,800);
        jf.setTitle("Squidding Game");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
