package Mstw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener_ extends KeyAdapter {

    //按下键盘
    @Override
    public void keyPressed(KeyEvent e){
        if (Mstw.game == null){
            return;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            Mstw.game.pressS();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            Mstw.game.pressD();
        }
        else if (e.getKeyCode() == KeyEvent.VK_F){
            Mstw.game.pressF();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Mstw.game.pressSpace();
        }
        else if (e.getKeyCode() == KeyEvent.VK_J){
            Mstw.game.pressJ();
        }
        else if (e.getKeyCode() == KeyEvent.VK_K){
            Mstw.game.pressK();
        }
        else if (e.getKeyCode() == KeyEvent.VK_L){
            Mstw.game.pressL();
        }
    }

    //释放键盘
    @Override
    public void keyReleased(KeyEvent e){
        if (Mstw.game == null){
            return;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            Mstw.game.releaseS();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            Mstw.game.releaseD();
        }
        else if (e.getKeyCode() == KeyEvent.VK_F){
            Mstw.game.releaseF();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Mstw.game.releaseSpace();
        }
        else if (e.getKeyCode() == KeyEvent.VK_J){
            Mstw.game.releaseJ();
        }
        else if (e.getKeyCode() == KeyEvent.VK_K){
            Mstw.game.releaseK();
        }
        else if (e.getKeyCode() == KeyEvent.VK_L){
            Mstw.game.releaseL();
        }
    }

}
