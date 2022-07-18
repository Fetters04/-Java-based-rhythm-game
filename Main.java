package Mstw;

//用来执行整个程序的主类
public class Main {

    public static final int screen_width = 1920;    //设置宽度
    public static final int screen_height = 1080;   //设置高度
    public static final int sleep_time = 10;        //设置下落间隔时间
    public static final int reach_time = 2;         //用来调整的时间
    public static int note_speed = 3;         //设置方块下落速度
    public static int scout;                        //游戏中的得分数
    //执行整个程序的主函数
    public static void main(String[] args) {

        new Mstw();

    }
}
