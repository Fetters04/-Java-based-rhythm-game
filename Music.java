package Mstw;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread{

    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    //重载构造函数，传入参数为名字和是否循环
    public Music(String name, boolean isLoop){
        try {
            this.isLoop = isLoop;

            //创建一个File对象
            file = new File(Main.class.getResource("../music/"+name).toURI());
            //创建一个输入流
            fis = new FileInputStream(file);
            //创建一个缓冲流
            bis = new BufferedInputStream(fis);
            //创建播放器对象,将文件的缓冲输入流传入进去
            player = new Player(bis);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getTime(){
        if (player == null)
            return 0;
        return player.getPosition();
    }

    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }

    @Override
    public void run() {
        try {
            do{
                player.play();                      //用播放方法进行播放

                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isLoop);                         //循环播放,直到有终止条件isLoop = false
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
