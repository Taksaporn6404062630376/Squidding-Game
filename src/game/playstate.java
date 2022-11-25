/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class playstate extends JPanel implements ActionListener{
    private final ImageIcon imgstate = new ImageIcon(this.getClass().getResource("image/bgstate.jpg"));
    private final ImageIcon scorepic = new ImageIcon(this.getClass().getResource("image/score.jpg"));
    private  ImageIcon restart = new ImageIcon(this.getClass().getResource("image/restart.jpg"));
    private  ImageIcon pause = new ImageIcon(this.getClass().getResource("image/pause.jpg"));
    private  ImageIcon resum = new ImageIcon(this.getClass().getResource("image/resume.jpg"));
    private  ImageIcon back = new ImageIcon(this.getClass().getResource("image/close.jpg"));
    boat boat = new boat();
    homegame hg = new homegame();
    ImageIcon feildover = new ImageIcon(this.getClass().getResource("image/bgover.jpg"));
    ImageIcon exitover = new ImageIcon(this.getClass().getResource("image/exit.jpg"));
    ImageIcon rstart = new ImageIcon(this.getClass().getResource("image/start.jpg"));
    JButton BStartover = new JButton(rstart);
    JButton BExitover = new JButton(exitover);
    private JLabel score = new JLabel();
    public JButton BPause = new JButton(pause);
    public JButton BExithome = new JButton(back);
    public JButton Bresum = new JButton(resum);
    public JButton Brestart = new JButton(restart);
    public ArrayList<hook> hook = new ArrayList<hook>();
    public ArrayList<squid> sq = new ArrayList<squid>();
    public ArrayList<badsquid> bsq = new ArrayList<badsquid>();
    public int times ;
    public int HP = 3;
    boolean timestart = true;
    boolean squidrun = false;
    public int scor = 0;
    boolean paralyze1 = false;
    int time_paralyze=5;
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{

                    Thread.sleep(10);

                }catch(Exception e){ }
                if(timestart == false){

                    repaint();

                }
            }
        }
    });
    Thread actor = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){}

                    repaint();

            }
        }
    });
    Thread tsq = new Thread(new Runnable(){
        public void run() {
            while(true){
                try{
                    if(squidrun == false){
                        Thread.sleep((long)(Math.random()*10000)+2000);

                    }

                }catch(InterruptedException e){
                    e.printStackTrace();

                }
                if(squidrun == false){
                    sq.add(new squid());

                }
            }
        }
    });

    Thread tbsq = new Thread(new Runnable(){
        public void run() {
            while(true){
                try{

                    if(squidrun==false){

                        Thread.sleep((long)(Math.random()*10000)+2000);
                    }

                }catch(InterruptedException e){
                    e.printStackTrace();

                }
                if(squidrun == false){
                    bsq.add(new badsquid());

                }
            }
        }
    });
    Thread paralyze = new Thread(new Runnable(){
        public void run(){
            while (true){
                if(time_paralyze < 1){
                    paralyze1 = false;
                    time_paralyze = 5;

                }
                try{

                    Thread.sleep(5000);

                }catch(InterruptedException e){e.printStackTrace();}
            }
        }
    });
    Thread t = new Thread(new Runnable(){
        public void run() {
            while(true){

                if(timestart == false){
                    times = (times-1) ;
                    if(paralyze1){
                        time_paralyze--;
                    }
                }
                try{

                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    });
    
    public playstate(){
        this.setFocusable(true);
        this.setLayout(null);
        BPause.setBounds(850,30,50,50);
        BPause.setBorderPainted(false);
        BExithome.setBounds(20,30,50,50);
        BExithome.setBorderPainted(false);
        Bresum.setBounds(910, 30, 50,50);
        Bresum.setBorderPainted(false);
        Brestart.setBounds(80, 30, 50,50);
        Brestart.setBorderPainted(false);
        BPause.addActionListener(this);
        BExithome.addActionListener(this);
        Bresum.addActionListener(this);
        BExithome.addActionListener(this);
        Brestart.addActionListener(this);
        this.add(BPause);
        this.add(BExithome);
        this.add(score);
        this.add(Bresum);
        this.add(Brestart);

        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(!paralyze1){
                    if(a==KeyEvent.VK_LEFT){
                        boat.x-=10;
                        boat.count++;
                    }
                    else if(a == KeyEvent.VK_RIGHT){
                        boat.x+=10;
                        boat.count++;
                    }

                    if(boat.count>3){
                        boat.count=0;
                    }
                    else if(a == KeyEvent.VK_DOWN){
                        boat.count=4;
                        hook.add(new hook(boat.x+30,350));
                    }
                }
            }
            public void keyReleased(KeyEvent e){
                boat.count=0;
            }
        });
        boat.x = (int)(Math.random() * 800);
        time.start();
        actor.start();
        t.start();
        tsq.start();
        tbsq.start();
        paralyze.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgstate.getImage(),0,0,1000,800,this);
        if(times <= 0 || HP<=0){
            this.remove(BPause);
            this.remove(Bresum);
            this.setLayout(null);
        
            if(scor>0){
                g.drawImage(scorepic.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,100));
                g.drawString(""+scor,430,500);
            }
            else{
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
            }


        }else if(times <= 0 && HP<=0){
            this.remove(BPause);
            this.remove(Bresum);
            this.setLayout(null);
            g.drawImage(feildover.getImage(),0,0,1000,800,this);

            
        }else{
            g.drawImage(imgstate.getImage(),0,0,1000,800,this);
            if(paralyze1){
                g.setColor(Color.RED);
                g.setFont(new Font("Hobo Std",Font.BOLD,50));
            }else{
                g.drawImage(boat.bo.getImage(), boat.x, 170,370,240, this);
            }

            if(boat.x<0){

                boat.x=this.getWidth()+10;

            }
                if(boat.x>this.getWidth()){

                boat.x=20;

            }
            for(int i=0;i<hook.size();i++){
                hook ba = hook.get(i);

                g.drawImage(ba.imfire.getImage(), ba.x, ba.y,50,50, null);

                ba.move();
                ba.count++;

                if(ba.y<0){
                    hook.remove(i);
                }
            }
            //===============squid=============
            for(int i=0 ; i<sq.size();i++){
                g.drawImage(sq.get(i).getImage(),sq.get(i).getX(), sq.get(i).getY(),100,100,this);
            }

            for(int i=0 ; i<hook.size();i++){
                for(int j=0 ; j<sq.size();j++){
                    if(Intersect(hook.get(i).getbound(),sq.get(j).getbound())){
                        sq.remove(j);
                        hook.remove(i);
                        scor += 20;
                    }
                }
            }

            //============badsquid=============
            for(int i=0 ; i<bsq.size();i++){
                g.drawImage(bsq.get(i).getImage(), bsq.get(i).getX(), bsq.get(i).getY(),100,100,this);

            }
            for(int i=0 ; i<hook.size();i++){
                for(int j=0 ; j<bsq.size();j++){
                    if(Intersect(hook.get(i).getbound(), bsq.get(j).getbound())){
                        bsq.remove(j);
                        hook.remove(i);
                        scor -=20;
                        HP=HP-1;
                    }
                }
            }
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
            g.setColor(Color.BLUE);
            g.drawString("SCORE = "+scor,100, 150);
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
            g.setColor(Color.BLACK);
            g.drawString("Time: "+times,450,150);
            g.setColor(Color.RED);
            g.drawString("HP "+HP,750,150);
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
        return (a.intersects(b));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== BStartover){
            this.setSize(1000,800);
            this.add(hg);
            this.setLocation(null);
            timestart = true;
            squidrun = true;

        }else if(e.getSource() == BExitover){
            System.exit(0);

        }
    }
}