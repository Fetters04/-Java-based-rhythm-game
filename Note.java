package Mstw;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread{
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
    private int x, y = 600 - (1000 / Main.sleep_time * Main.note_speed) * Main.reach_time;
    private String noteType;
    private boolean proceeded = true;

    public boolean isProceeded() {
        return proceeded;
    }

    public String getNoteType(){
        return noteType;
    }

    public void close() {
        proceeded = false;
    }

    public Note(String noteType){
        if(noteType.equals("S")){
            x = 424;
        }
        if(noteType.equals("D")){
            x = 578;
        }
        if(noteType.equals("F")){
            x = 732;
        }
        if(noteType.equals("Space")){
            x = 886;
        }
        if(noteType.equals("J")){
            x = 1040;
        }
        if(noteType.equals("K")){
            x = 1194;
        }
        if(noteType.equals("L")){
            x = 1348;
        }
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(noteBasicImage, x, y, null);
    }
    //方块下落函数
    public void drop(){
        y += Main.note_speed;   //以一个速度下落
        //方块超出判定区就消失,并且算Miss
        if (y > 965){
            System.out.println("Miss");
            close();
        }
    }

    @Override
    public void run(){
        try{
            while (true){
                drop();
                if (proceeded){
                    Thread.sleep(Main.sleep_time);
                }
                else {
                    interrupt();
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String judge(){
        if (y > 935){
            System.out.println("Late");
            Main.scout += 10;
            close();
            return "Late";
        }
        else if (y > 915){
            System.out.println("Good");
            Main.scout += 20;
            close();
            return "Good";
        }
        else if (y > 895){
            System.out.println("Prefect");
            Main.scout += 40;
            close();
            return "Prefect";
        }
        else if (y > 875){
            System.out.println("Early");
            Main.scout += 10;
            close();
            return "Early";
        }
        return "None";
    }

    public int getY(){
        return y;
    }

}
