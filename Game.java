package Mstw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {

    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    //每个按键控制一个区域
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image blueFlareImage;
    private Image judgeImage;

    private String titleName;   //歌曲名称
    private String difficulty;  //难度
    private String musicTitle;  //歌曲MP3
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();


    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
    }


    public void screenDraw(Graphics2D g) {

        g.drawImage(gameInfoImage, 0, 1020, null);
        g.drawImage(judgementLineImage, 0, 920, null);   //方块判定界面
        //方块下落路径和间隙
        g.drawImage(noteRouteLineImage, 419, 0, null);
        g.drawImage(noteRouteSImage, 423, 0, null);
        g.drawImage(noteRouteLineImage, 573, 0, null);
        g.drawImage(noteRouteDImage, 577, 0, null);
        g.drawImage(noteRouteLineImage, 727, 0, null);
        g.drawImage(noteRouteFImage, 731, 0, null);
        g.drawImage(noteRouteLineImage, 881, 0, null);
        g.drawImage(noteRouteSpaceImage, 885, 0, null);
        g.drawImage(noteRouteLineImage, 1035, 0, null);
        g.drawImage(noteRouteJImage, 1039, 0, null);
        g.drawImage(noteRouteLineImage, 1189, 0, null);
        g.drawImage(noteRouteKImage, 1193, 0, null);
        g.drawImage(noteRouteLineImage, 1343, 0, null);
        g.drawImage(noteRouteLImage, 1347, 0, null);
        g.drawImage(noteRouteLineImage, 1497, 0, null);

        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (note.getY() > 960){
                judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
            }
            if (!note.isProceeded()){
                noteList.remove(i);
                i--;
            }
            else {
                note.screenDraw(g);
            }
        }

        //设置白色字体
        g.setColor(Color.white);
        //让字体平滑
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 30, 1065);
        g.drawString(difficulty, 1800, 1065);
        //设置字母位置和颜色
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.setColor(Color.GREEN);
        g.drawString("S", 498, 950);
        g.drawString("D", 652, 950);
        g.drawString("F", 806, 950);
        g.drawString("Space", 920, 950);
        g.drawString("J", 1110, 950);
        g.drawString("K", 1268, 950);
        g.drawString("L", 1422, 950);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        //显示当前得分
        g.drawString(" "+Main.scout, 920, 1065);
        if(Main.scout >= 1000){
            Main.note_speed = 6;
        }
        g.drawImage(blueFlareImage, 360, 500, null);
        g.drawImage(judgeImage, 780, 730, null);
    }

    //按下键盘上相应键的行为的函数,按下和松开
    //S
    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //D
    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //F
    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //Space
    public void pressSpace() {
        judge("Space");
        noteRouteSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //J
    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //K
    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    //L
    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("PressedKeyboardMusic.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    //下落方块
    public void dropNotes(String titleName) {
//        noteList.add(new Note(425, 600));
//        noteList.add(new Note(579, 555));
//        noteList.add(new Note(733, 500));
//        noteList.add(new Note(887, 340));
//        noteList.add(new Note(1041, 480));
//        noteList.add(new Note(1195, 650));
//        noteList.add(new Note(1349, 340));
        Beat[] beats = null;
        //根据选择的歌曲和难度制定节拍
        if (titleName.equals("Celebrate - Joakim Karud") && difficulty.equals("Easy")){
            int startTime = 2750 - Main.reach_time * 1000;  //设置起始时间
            int gap = 150;     //用来制定节拍的间隔
            beats = new Beat[]{
                    //节拍学习过程
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 2, "D"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "S"),
                    new Beat(startTime + gap * 10, "D"),
                    new Beat(startTime + gap * 12 - 80, "S"),
                    new Beat(startTime + gap * 14 - 130, "D"),
                    new Beat(startTime + gap * 15, "F"),
                    new Beat(startTime + gap * 18, "J"),
                    new Beat(startTime + gap * 20 - 80, "K"),
                    new Beat(startTime + gap * 22 - 130, "L"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 25, "J"),
                    new Beat(startTime + gap * 26, "K"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 28, "Space"),

//                    new Beat(startTime + gap * 36, "D"),
//                    new Beat(startTime + gap * 38, "S"),
//                    new Beat(startTime + gap * 40, "D"),
//                    new Beat(startTime + gap * 42, "S"),
//                    new Beat(startTime + gap * 44, "D"),
//                    new Beat(startTime + gap * 46, "S"),
//                    new Beat(startTime + gap * 48, "D"),
//                    new Beat(startTime + gap * 50, "F"),
//                    new Beat(startTime + gap * 52, "J"),
//                    new Beat(startTime + gap * 54, "K"),
//                    new Beat(startTime + gap * 56, "L"),
//                    new Beat(startTime + gap * 58, "J"),
//                    new Beat(startTime + gap * 60, "K"),
//                    new Beat(startTime + gap * 62, "J"),
//                    new Beat(startTime + gap * 64, "K"),
//                    new Beat(startTime + gap * 66, "L"),
//                    new Beat(startTime + gap * 68, "Space"),
//                    new Beat(startTime + gap * 70, "D"),
//                    new Beat(startTime + gap * 72, "S"),
//                    new Beat(startTime + gap * 74, "D"),
//                    new Beat(startTime + gap * 76, "S"),
//                    new Beat(startTime + gap * 78, "D"),
//                    new Beat(startTime + gap * 80, "S"),
//                    new Beat(startTime + gap * 82, "D"),
//                    new Beat(startTime + gap * 84, "F"),
//                    new Beat(startTime + gap * 86, "J"),

                    new Beat(startTime + gap * 88, "S"),
                    new Beat(startTime + gap * 90, "D"),
                    new Beat(startTime + gap * 92, "S"),
                    new Beat(startTime + gap * 94, "D"),
                    new Beat(startTime + gap * 96, "J"),
                    new Beat(startTime + gap * 98, "K"),
                    new Beat(startTime + gap * 100, "J"),
                    new Beat(startTime + gap * 102, "K"),
                    new Beat(startTime + gap * 104, "D"),
                    new Beat(startTime + gap * 106, "F"),
                    new Beat(startTime + gap * 108, "L"),
                    new Beat(startTime + gap * 110, "Space"),
                    new Beat(startTime + gap * 112, "S"),
                    new Beat(startTime + gap * 114, "J"),

                    new Beat(startTime + gap * 116, "K"),
                    new Beat(startTime + gap * 118, "L"),
                    new Beat(startTime + gap * 120, "J"),
                    new Beat(startTime + gap * 122, "K"),
                    new Beat(startTime + gap * 124, "J"),
                    new Beat(startTime + gap * 126, "K"),
                    new Beat(startTime + gap * 128, "L"),
                    new Beat(startTime + gap * 130, "Space"),
                    new Beat(startTime + gap * 132, "D"),
                    new Beat(startTime + gap * 134, "S"),
                    new Beat(startTime + gap * 136, "D"),
                    new Beat(startTime + gap * 138, "S"),
                    new Beat(startTime + gap * 140, "D"),
                    new Beat(startTime + gap * 142, "S"),
                    new Beat(startTime + gap * 144, "K"),
                    new Beat(startTime + gap * 146, "L"),
                    new Beat(startTime + gap * 148, "J"),
                    new Beat(startTime + gap * 150, "K"),
                    new Beat(startTime + gap * 152, "J"),
                    new Beat(startTime + gap * 154, "K"),
                    new Beat(startTime + gap * 156, "L"),
                    new Beat(startTime + gap * 158, "Space"),
                    new Beat(startTime + gap * 160, "S"),
                    new Beat(startTime + gap * 162, "D"),
                    new Beat(startTime + gap * 164, "F"),
                    new Beat(startTime + gap * 166, "J"),
                    new Beat(startTime + gap * 168, "K"),
                    new Beat(startTime + gap * 170, "L"),

                    new Beat(startTime + gap * 172, "S"),
                    new Beat(startTime + gap * 174, "D"),
                    new Beat(startTime + gap * 176, "S"),
                    new Beat(startTime + gap * 178, "J"),
                    new Beat(startTime + gap * 180, "K"),
                    new Beat(startTime + gap * 182, "J"),
                    new Beat(startTime + gap * 184, "D"),
                    new Beat(startTime + gap * 186, "F"),
                    new Beat(startTime + gap * 188, "D"),
                    new Beat(startTime + gap * 190, "K"),
                    new Beat(startTime + gap * 192, "L"),
                    new Beat(startTime + gap * 194, "K"),
                    new Beat(startTime + gap * 196, "Space"),
                    new Beat(startTime + gap * 198, "S"),
                    new Beat(startTime + gap * 200, "D"),
                    new Beat(startTime + gap * 202, "F"),

                    new Beat(startTime + gap * 204, "D"),
                    new Beat(startTime + gap * 206, "S"),
                    new Beat(startTime + gap * 208, "K"),
                    new Beat(startTime + gap * 210, "L"),
                    new Beat(startTime + gap * 212, "J"),
                    new Beat(startTime + gap * 214, "K"),
                    new Beat(startTime + gap * 216, "J"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 220, "L"),
                    new Beat(startTime + gap * 222, "Space"),
                    new Beat(startTime + gap * 224, "D"),
                    new Beat(startTime + gap * 226, "S"),
                    new Beat(startTime + gap * 228, "D"),
                    new Beat(startTime + gap * 230, "S"),
                    new Beat(startTime + gap * 232, "D"),
                    new Beat(startTime + gap * 234, "S"),

                    new Beat(startTime + gap * 236, "K"),
                    new Beat(startTime + gap * 238, "L"),
                    new Beat(startTime + gap * 240, "J"),
                    new Beat(startTime + gap * 242, "K"),
                    new Beat(startTime + gap * 244, "J"),
                    new Beat(startTime + gap * 246, "K"),
                    new Beat(startTime + gap * 248, "L"),
                    new Beat(startTime + gap * 250, "Space"),
                    new Beat(startTime + gap * 252, "S"),
                    new Beat(startTime + gap * 254, "D"),
                    new Beat(startTime + gap * 256, "S"),
                    new Beat(startTime + gap * 258, "J"),
                    new Beat(startTime + gap * 260, "K"),
                    new Beat(startTime + gap * 262, "J"),
                    new Beat(startTime + gap * 264, "Space"),

                    new Beat(startTime + gap * 266, "S"),
                    new Beat(startTime + gap * 268, "D"),
                    new Beat(startTime + gap * 270, "S"),
                    new Beat(startTime + gap * 272, "D"),
                    new Beat(startTime + gap * 274, "S"),
                    new Beat(startTime + gap * 276, "D"),
                    new Beat(startTime + gap * 278 - 80, "S"),
                    new Beat(startTime + gap * 280 - 130, "D"),
                    new Beat(startTime + gap * 281, "F"),
                    new Beat(startTime + gap * 284, "J"),
                    new Beat(startTime + gap * 286 - 80, "K"),
                    new Beat(startTime + gap * 288 - 130, "L"),
                    new Beat(startTime + gap * 289, "J"),
                    new Beat(startTime + gap * 290, "K"),
                    new Beat(startTime + gap * 291, "J"),
                    new Beat(startTime + gap * 292, "K"),
                    new Beat(startTime + gap * 293, "L"),
                    new Beat(startTime + gap * 294, "Space"),

                    new Beat(startTime + gap * 296, "D"),
                    new Beat(startTime + gap * 298, "S"),
                    new Beat(startTime + gap * 300, "K"),
                    new Beat(startTime + gap * 302, "L"),
                    new Beat(startTime + gap * 304, "J"),
                    new Beat(startTime + gap * 306, "K"),
                    new Beat(startTime + gap * 308, "J"),
                    new Beat(startTime + gap * 310, "K"),
                    new Beat(startTime + gap * 312, "L"),
                    new Beat(startTime + gap * 314, "Space"),
                    new Beat(startTime + gap * 316, "D"),
                    new Beat(startTime + gap * 318, "S"),
                    new Beat(startTime + gap * 320, "D"),
                    new Beat(startTime + gap * 322, "S"),
                    new Beat(startTime + gap * 324, "D"),
                    new Beat(startTime + gap * 326, "S"),

                    new Beat(startTime + gap * 328, "K"),
                    new Beat(startTime + gap * 330, "L"),
                    new Beat(startTime + gap * 332, "J"),
                    new Beat(startTime + gap * 334, "K"),
                    new Beat(startTime + gap * 336, "J"),
                    new Beat(startTime + gap * 338, "K"),
                    new Beat(startTime + gap * 340, "L"),
                    new Beat(startTime + gap * 342, "Space"),
                    new Beat(startTime + gap * 344, "S"),
                    new Beat(startTime + gap * 346, "D"),
                    new Beat(startTime + gap * 348, "S"),
                    new Beat(startTime + gap * 350, "J"),
                    new Beat(startTime + gap * 352, "K"),
                    new Beat(startTime + gap * 354, "J"),
                    new Beat(startTime + gap * 356, "Space"),
            };
        }
        else if (titleName.equals("Celebrate - Joakim Karud") && difficulty.equals("Hard")){
            int startTime = 2750 - Main.reach_time * 1000;
            int gap = 125;     //用来制定节拍的间隔
            Main.note_speed = 4;
            beats = new Beat[]{
                    //节拍学习过程
                    new Beat(startTime, "S"),
                    new Beat(startTime, "J"),
                    new Beat(startTime + gap * 2, "D"),
                    new Beat(startTime + gap * 2, "K"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 4, "J"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 6, "K"),
                    new Beat(startTime + gap * 8, "S"),
                    new Beat(startTime + gap * 8, "J"),
                    new Beat(startTime + gap * 10, "D"),
                    new Beat(startTime + gap * 10, "K"),
                    new Beat(startTime + gap * 12 - 80, "S"),
                    new Beat(startTime + gap * 12 - 80, "J"),

                    new Beat(startTime + gap * 14 - 130, "D"),
                    new Beat(startTime + gap * 14 - 130, "K"),
                    new Beat(startTime + gap * 15, "F"),
                    new Beat(startTime + gap * 15, "L"),
                    new Beat(startTime + gap * 18, "J"),
                    new Beat(startTime + gap * 18, "S"),
                    new Beat(startTime + gap * 20 - 80, "K"),
                    new Beat(startTime + gap * 20 - 80, "D"),
                    new Beat(startTime + gap * 22 - 130, "L"),
                    new Beat(startTime + gap * 22 - 130, "F"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 23, "F"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 24, "D"),
                    new Beat(startTime + gap * 25, "J"),
                    new Beat(startTime + gap * 25, "F"),
                    new Beat(startTime + gap * 26, "K"),
                    new Beat(startTime + gap * 26, "D"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 28, "Space"),

                    new Beat(startTime + gap * 36, "D"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "D"),
                    new Beat(startTime + gap * 42, "S"),
                    new Beat(startTime + gap * 44, "D"),
                    new Beat(startTime + gap * 46, "S"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "F"),
                    new Beat(startTime + gap * 52, "J"),
                    new Beat(startTime + gap * 54, "K"),
                    new Beat(startTime + gap * 56, "L"),
                    new Beat(startTime + gap * 58, "J"),
                    new Beat(startTime + gap * 60, "K"),
                    new Beat(startTime + gap * 62, "J"),
                    new Beat(startTime + gap * 64, "K"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "Space"),
//                    new Beat(startTime + gap * 70, "D"),
//                    new Beat(startTime + gap * 72, "S"),
//                    new Beat(startTime + gap * 74, "D"),
//                    new Beat(startTime + gap * 76, "S"),
//                    new Beat(startTime + gap * 78, "D"),
//                    new Beat(startTime + gap * 80, "S"),
//                    new Beat(startTime + gap * 82, "D"),
//                    new Beat(startTime + gap * 84, "F"),
//                    new Beat(startTime + gap * 86, "J"),

                    new Beat(startTime + gap * 88, "S"),
                    new Beat(startTime + gap * 89, "D"),
                    new Beat(startTime + gap * 90, "S"),
                    new Beat(startTime + gap * 91, "D"),
                    new Beat(startTime + gap * 92, "J"),
                    new Beat(startTime + gap * 93, "K"),
                    new Beat(startTime + gap * 94, "J"),
                    new Beat(startTime + gap * 95, "K"),
                    new Beat(startTime + gap * 96, "D"),
                    new Beat(startTime + gap * 97, "F"),
                    new Beat(startTime + gap * 98, "L"),
                    new Beat(startTime + gap * 99, "Space"),
                    new Beat(startTime + gap * 100, "S"),
                    new Beat(startTime + gap * 101, "J"),
                    new Beat(startTime + gap * 102, "S"),
                    new Beat(startTime + gap * 103, "D"),
                    new Beat(startTime + gap * 104, "S"),
                    new Beat(startTime + gap * 105, "D"),
                    new Beat(startTime + gap * 106, "J"),
                    new Beat(startTime + gap * 107, "K"),
                    new Beat(startTime + gap * 108, "J"),
                    new Beat(startTime + gap * 109, "K"),
                    new Beat(startTime + gap * 110, "D"),
                    new Beat(startTime + gap * 111, "F"),
                    new Beat(startTime + gap * 112, "L"),
                    new Beat(startTime + gap * 114, "Space"),
                    new Beat(startTime + gap * 114, "F"),
                    new Beat(startTime + gap * 114, "J"),

                    new Beat(startTime + gap * 116, "K"),
                    new Beat(startTime + gap * 118, "L"),
                    new Beat(startTime + gap * 120, "J"),
                    new Beat(startTime + gap * 122, "K"),
                    new Beat(startTime + gap * 124, "J"),
                    new Beat(startTime + gap * 126, "K"),
                    new Beat(startTime + gap * 128, "L"),
                    new Beat(startTime + gap * 130, "Space"),
                    new Beat(startTime + gap * 132, "D"),
                    new Beat(startTime + gap * 132, "K"),
                    new Beat(startTime + gap * 134, "S"),
                    new Beat(startTime + gap * 134, "L"),
                    new Beat(startTime + gap * 136, "D"),
                    new Beat(startTime + gap * 136, "K"),
                    new Beat(startTime + gap * 138, "S"),
                    new Beat(startTime + gap * 138, "L"),
                    new Beat(startTime + gap * 140, "D"),
                    new Beat(startTime + gap * 140, "K"),
                    new Beat(startTime + gap * 142, "S"),
                    new Beat(startTime + gap * 142, "L"),
                    new Beat(startTime + gap * 144, "K"),
                    new Beat(startTime + gap * 144, "D"),
                    new Beat(startTime + gap * 146, "S"),
                    new Beat(startTime + gap * 146, "L"),
                    new Beat(startTime + gap * 148, "F"),
                    new Beat(startTime + gap * 148, "J"),
                    new Beat(startTime + gap * 150, "D"),
                    new Beat(startTime + gap * 150, "K"),
                    new Beat(startTime + gap * 152, "F"),
                    new Beat(startTime + gap * 152, "J"),
                    new Beat(startTime + gap * 154, "D"),
                    new Beat(startTime + gap * 154, "K"),
                    new Beat(startTime + gap * 156, "F"),
                    new Beat(startTime + gap * 156, "L"),
                    new Beat(startTime + gap * 158, "Space"),
                    new Beat(startTime + gap * 160, "S"),
                    new Beat(startTime + gap * 160, "L"),
                    new Beat(startTime + gap * 162, "D"),
                    new Beat(startTime + gap * 162, "K"),
                    new Beat(startTime + gap * 164, "F"),
                    new Beat(startTime + gap * 164, "J"),
                    new Beat(startTime + gap * 166, "J"),
                    new Beat(startTime + gap * 166, "F"),
                    new Beat(startTime + gap * 168, "K"),
                    new Beat(startTime + gap * 168, "D"),
                    new Beat(startTime + gap * 170, "L"),
                    new Beat(startTime + gap * 170, "S"),

                    new Beat(startTime + gap * 172, "S"),
                    new Beat(startTime + gap * 174, "D"),
                    new Beat(startTime + gap * 176, "S"),
                    new Beat(startTime + gap * 178, "J"),
                    new Beat(startTime + gap * 180, "K"),
                    new Beat(startTime + gap * 182, "J"),
                    new Beat(startTime + gap * 184, "D"),
                    new Beat(startTime + gap * 186, "F"),
                    new Beat(startTime + gap * 188, "D"),
                    new Beat(startTime + gap * 190, "K"),
                    new Beat(startTime + gap * 192, "L"),
                    new Beat(startTime + gap * 194, "K"),
                    new Beat(startTime + gap * 196, "Space"),
                    new Beat(startTime + gap * 196, "D"),
                    new Beat(startTime + gap * 196, "F"),
                    new Beat(startTime + gap * 196, "J"),
                    new Beat(startTime + gap * 196, "K"),

                    new Beat(startTime + gap * 198, "S"),
                    new Beat(startTime + gap * 200, "D"),
                    new Beat(startTime + gap * 202, "F"),
                    new Beat(startTime + gap * 204, "D"),
                    new Beat(startTime + gap * 206, "S"),
                    new Beat(startTime + gap * 208, "K"),
                    new Beat(startTime + gap * 210, "L"),
                    new Beat(startTime + gap * 212, "J"),
                    new Beat(startTime + gap * 214, "K"),
                    new Beat(startTime + gap * 216, "J"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 220, "L"),
                    new Beat(startTime + gap * 222, "Space"),
                    new Beat(startTime + gap * 224, "D"),
                    new Beat(startTime + gap * 224, "K"),
                    new Beat(startTime + gap * 226, "S"),
                    new Beat(startTime + gap * 226, "L"),
                    new Beat(startTime + gap * 228, "D"),
                    new Beat(startTime + gap * 228, "K"),
                    new Beat(startTime + gap * 230, "S"),
                    new Beat(startTime + gap * 230, "L"),
                    new Beat(startTime + gap * 232, "D"),
                    new Beat(startTime + gap * 232, "K"),
                    new Beat(startTime + gap * 234, "S"),
                    new Beat(startTime + gap * 234, "L"),
                    new Beat(startTime + gap * 236, "K"),
                    new Beat(startTime + gap * 236, "D"),
                    new Beat(startTime + gap * 238, "L"),
                    new Beat(startTime + gap * 238, "S"),
                    new Beat(startTime + gap * 240, "J"),
                    new Beat(startTime + gap * 240, "F"),
                    new Beat(startTime + gap * 242, "K"),
                    new Beat(startTime + gap * 242, "D"),
                    new Beat(startTime + gap * 244, "J"),
                    new Beat(startTime + gap * 244, "F"),
                    new Beat(startTime + gap * 246, "K"),
                    new Beat(startTime + gap * 246, "D"),
                    new Beat(startTime + gap * 248, "L"),
                    new Beat(startTime + gap * 248, "F"),
                    new Beat(startTime + gap * 250, "Space"),
                    new Beat(startTime + gap * 252, "S"),
                    new Beat(startTime + gap * 254, "D"),
                    new Beat(startTime + gap * 256, "S"),
                    new Beat(startTime + gap * 258, "J"),
                    new Beat(startTime + gap * 260, "K"),
                    new Beat(startTime + gap * 262, "J"),
                    new Beat(startTime + gap * 264, "Space"),

                    new Beat(startTime + gap * 266, "S"),
                    new Beat(startTime + gap * 268, "D"),
                    new Beat(startTime + gap * 270, "S"),
                    new Beat(startTime + gap * 272, "D"),
                    new Beat(startTime + gap * 274, "S"),
                    new Beat(startTime + gap * 276, "D"),
                    new Beat(startTime + gap * 278 - 80, "S"),
                    new Beat(startTime + gap * 280 - 130, "D"),
                    new Beat(startTime + gap * 281, "F"),
                    new Beat(startTime + gap * 284, "J"),
                    new Beat(startTime + gap * 286 - 80, "K"),
                    new Beat(startTime + gap * 288 - 130, "L"),
                    new Beat(startTime + gap * 289, "J"),
                    new Beat(startTime + gap * 290, "K"),
                    new Beat(startTime + gap * 291, "J"),
                    new Beat(startTime + gap * 292, "K"),
                    new Beat(startTime + gap * 293, "L"),
                    new Beat(startTime + gap * 294, "Space"),

                    new Beat(startTime + gap * 296, "D"),
                    new Beat(startTime + gap * 298, "S"),
                    new Beat(startTime + gap * 300, "K"),
                    new Beat(startTime + gap * 302, "L"),
                    new Beat(startTime + gap * 304, "J"),
                    new Beat(startTime + gap * 306, "K"),
                    new Beat(startTime + gap * 308, "J"),
                    new Beat(startTime + gap * 310, "K"),
                    new Beat(startTime + gap * 312, "L"),
                    new Beat(startTime + gap * 314, "Space"),
                    new Beat(startTime + gap * 316, "D"),
                    new Beat(startTime + gap * 316, "K"),
                    new Beat(startTime + gap * 318, "S"),
                    new Beat(startTime + gap * 318, "L"),
                    new Beat(startTime + gap * 320, "D"),
                    new Beat(startTime + gap * 320, "K"),
                    new Beat(startTime + gap * 322, "S"),
                    new Beat(startTime + gap * 322, "L"),
                    new Beat(startTime + gap * 324, "D"),
                    new Beat(startTime + gap * 324, "K"),
                    new Beat(startTime + gap * 326, "S"),
                    new Beat(startTime + gap * 326, "L"),
                    new Beat(startTime + gap * 328, "K"),
                    new Beat(startTime + gap * 328, "D"),
                    new Beat(startTime + gap * 330, "L"),
                    new Beat(startTime + gap * 330, "S"),
                    new Beat(startTime + gap * 332, "J"),
                    new Beat(startTime + gap * 332, "F"),
                    new Beat(startTime + gap * 334, "K"),
                    new Beat(startTime + gap * 334, "D"),
                    new Beat(startTime + gap * 336, "J"),
                    new Beat(startTime + gap * 336, "F"),
                    new Beat(startTime + gap * 338, "K"),
                    new Beat(startTime + gap * 338, "D"),
                    new Beat(startTime + gap * 340, "L"),
                    new Beat(startTime + gap * 340, "S"),
                    new Beat(startTime + gap * 342, "Space"),

                    new Beat(startTime + gap * 344, "S"),
                    new Beat(startTime + gap * 346, "D"),
                    new Beat(startTime + gap * 348, "S"),
                    new Beat(startTime + gap * 350, "J"),
                    new Beat(startTime + gap * 352, "K"),
                    new Beat(startTime + gap * 354, "J"),
                    new Beat(startTime + gap * 356, "Space"),
                    new Beat(startTime + gap * 356, "S"),
                    new Beat(startTime + gap * 356, "D"),
                    new Beat(startTime + gap * 356, "F"),
                    new Beat(startTime + gap * 356, "J"),
                    new Beat(startTime + gap * 356, "K"),
                    new Beat(startTime + gap * 356, "L"),

            };
        }
        else if (titleName.equals("Future Funk - Joakim Karud") && difficulty.equals("Easy")){
            int startTime = 2750 - Main.reach_time * 1000;  //设置起始时间
            int gap = 150;     //用来制定节拍的间隔
            beats = new Beat[]{
                    //节拍学习过程
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 2, "D"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "S"),
                    new Beat(startTime + gap * 10, "D"),
                    new Beat(startTime + gap * 12 - 80, "S"),
                    new Beat(startTime + gap * 14 - 130, "D"),
                    new Beat(startTime + gap * 15, "F"),
                    new Beat(startTime + gap * 18, "J"),
                    new Beat(startTime + gap * 20 - 80, "K"),
                    new Beat(startTime + gap * 22 - 130, "L"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 25, "J"),
                    new Beat(startTime + gap * 26, "K"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 28, "Space"),

                    new Beat(startTime + gap * 88, "S"),
                    new Beat(startTime + gap * 90, "D"),
                    new Beat(startTime + gap * 92, "S"),
                    new Beat(startTime + gap * 94, "D"),
                    new Beat(startTime + gap * 96, "J"),
                    new Beat(startTime + gap * 98, "K"),
                    new Beat(startTime + gap * 100, "J"),
                    new Beat(startTime + gap * 102, "K"),
                    new Beat(startTime + gap * 104, "D"),
                    new Beat(startTime + gap * 106, "F"),
                    new Beat(startTime + gap * 108, "L"),
                    new Beat(startTime + gap * 110, "Space"),
                    new Beat(startTime + gap * 112, "S"),
                    new Beat(startTime + gap * 114, "J"),

                    new Beat(startTime + gap * 116, "K"),
                    new Beat(startTime + gap * 118, "L"),
                    new Beat(startTime + gap * 120, "J"),
                    new Beat(startTime + gap * 122, "K"),
                    new Beat(startTime + gap * 124, "J"),
                    new Beat(startTime + gap * 126, "K"),
                    new Beat(startTime + gap * 128, "L"),
                    new Beat(startTime + gap * 130, "Space"),
                    new Beat(startTime + gap * 132, "D"),
                    new Beat(startTime + gap * 134, "S"),
                    new Beat(startTime + gap * 136, "D"),
                    new Beat(startTime + gap * 138, "S"),
                    new Beat(startTime + gap * 140, "D"),
                    new Beat(startTime + gap * 142, "S"),
                    new Beat(startTime + gap * 144, "K"),
                    new Beat(startTime + gap * 146, "L"),
                    new Beat(startTime + gap * 148, "J"),
                    new Beat(startTime + gap * 150, "K"),
                    new Beat(startTime + gap * 152, "J"),
                    new Beat(startTime + gap * 154, "K"),
                    new Beat(startTime + gap * 156, "L"),
                    new Beat(startTime + gap * 158, "Space"),
                    new Beat(startTime + gap * 160, "S"),
                    new Beat(startTime + gap * 162, "D"),
                    new Beat(startTime + gap * 164, "F"),
                    new Beat(startTime + gap * 166, "J"),
                    new Beat(startTime + gap * 168, "K"),
                    new Beat(startTime + gap * 170, "L"),

                    new Beat(startTime + gap * 172, "S"),
                    new Beat(startTime + gap * 174, "D"),
                    new Beat(startTime + gap * 176, "S"),
                    new Beat(startTime + gap * 178, "J"),
                    new Beat(startTime + gap * 180, "K"),
                    new Beat(startTime + gap * 182, "J"),
                    new Beat(startTime + gap * 184, "D"),
                    new Beat(startTime + gap * 186, "F"),
                    new Beat(startTime + gap * 188, "D"),
                    new Beat(startTime + gap * 190, "K"),
                    new Beat(startTime + gap * 192, "L"),
                    new Beat(startTime + gap * 194, "K"),
                    new Beat(startTime + gap * 196, "Space"),
                    new Beat(startTime + gap * 198, "S"),
                    new Beat(startTime + gap * 200, "D"),
                    new Beat(startTime + gap * 202, "F"),

                    new Beat(startTime + gap * 204, "D"),
                    new Beat(startTime + gap * 206, "S"),
                    new Beat(startTime + gap * 208, "K"),
                    new Beat(startTime + gap * 210, "L"),
                    new Beat(startTime + gap * 212, "J"),
                    new Beat(startTime + gap * 214, "K"),
                    new Beat(startTime + gap * 216, "J"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 220, "L"),
                    new Beat(startTime + gap * 222, "Space"),
                    new Beat(startTime + gap * 224, "D"),
                    new Beat(startTime + gap * 226, "S"),
                    new Beat(startTime + gap * 228, "D"),
                    new Beat(startTime + gap * 230, "S"),
                    new Beat(startTime + gap * 232, "D"),
                    new Beat(startTime + gap * 234, "S"),

                    new Beat(startTime + gap * 236, "K"),
                    new Beat(startTime + gap * 238, "L"),
                    new Beat(startTime + gap * 240, "J"),
                    new Beat(startTime + gap * 242, "K"),
                    new Beat(startTime + gap * 244, "J"),
                    new Beat(startTime + gap * 246, "K"),
                    new Beat(startTime + gap * 248, "L"),
                    new Beat(startTime + gap * 250, "Space"),
                    new Beat(startTime + gap * 252, "S"),
                    new Beat(startTime + gap * 254, "D"),
                    new Beat(startTime + gap * 256, "S"),
                    new Beat(startTime + gap * 258, "J"),
                    new Beat(startTime + gap * 260, "K"),
                    new Beat(startTime + gap * 262, "J"),
                    new Beat(startTime + gap * 264, "Space"),

                    new Beat(startTime + gap * 266, "S"),
                    new Beat(startTime + gap * 268, "D"),
                    new Beat(startTime + gap * 270, "S"),
                    new Beat(startTime + gap * 272, "D"),
                    new Beat(startTime + gap * 274, "S"),
                    new Beat(startTime + gap * 276, "D"),
                    new Beat(startTime + gap * 278 - 80, "S"),
                    new Beat(startTime + gap * 280 - 130, "D"),
                    new Beat(startTime + gap * 281, "F"),
                    new Beat(startTime + gap * 284, "J"),
                    new Beat(startTime + gap * 286 - 80, "K"),
                    new Beat(startTime + gap * 288 - 130, "L"),
                    new Beat(startTime + gap * 289, "J"),
                    new Beat(startTime + gap * 290, "K"),
                    new Beat(startTime + gap * 291, "J"),
                    new Beat(startTime + gap * 292, "K"),
                    new Beat(startTime + gap * 293, "L"),
                    new Beat(startTime + gap * 294, "Space"),

                };
        }
        else if (titleName.equals("Future Funk - Joakim Karud") && difficulty.equals("Hard")){
            int startTime = 2750 - Main.reach_time * 1000;  //设置起始时间
            int gap = 150;     //用来制定节拍的间隔
            beats = new Beat[]{
                    //节拍学习过程
                    new Beat(startTime, "S"),
                    new Beat(startTime, "J"),
                    new Beat(startTime + gap * 2, "D"),
                    new Beat(startTime + gap * 2, "K"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 4, "J"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 6, "K"),
                    new Beat(startTime + gap * 8, "S"),
                    new Beat(startTime + gap * 8, "J"),
                    new Beat(startTime + gap * 10, "D"),
                    new Beat(startTime + gap * 10, "K"),
                    new Beat(startTime + gap * 12 - 80, "S"),
                    new Beat(startTime + gap * 12 - 80, "J"),

                    new Beat(startTime + gap * 14 - 130, "D"),
                    new Beat(startTime + gap * 14 - 130, "K"),
                    new Beat(startTime + gap * 15, "F"),
                    new Beat(startTime + gap * 15, "L"),
                    new Beat(startTime + gap * 18, "J"),
                    new Beat(startTime + gap * 18, "S"),
                    new Beat(startTime + gap * 20 - 80, "K"),
                    new Beat(startTime + gap * 20 - 80, "D"),
                    new Beat(startTime + gap * 22 - 130, "L"),
                    new Beat(startTime + gap * 22 - 130, "F"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 23, "F"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 24, "D"),
                    new Beat(startTime + gap * 25, "J"),
                    new Beat(startTime + gap * 25, "F"),
                    new Beat(startTime + gap * 26, "K"),
                    new Beat(startTime + gap * 26, "D"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 27, "L"),
                    new Beat(startTime + gap * 28, "Space"),

                    new Beat(startTime + gap * 36, "D"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "D"),
                    new Beat(startTime + gap * 42, "S"),
                    new Beat(startTime + gap * 44, "D"),
                    new Beat(startTime + gap * 46, "S"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "F"),
                    new Beat(startTime + gap * 52, "J"),
                    new Beat(startTime + gap * 54, "K"),
                    new Beat(startTime + gap * 56, "L"),
                    new Beat(startTime + gap * 58, "J"),
                    new Beat(startTime + gap * 60, "K"),
                    new Beat(startTime + gap * 62, "J"),
                    new Beat(startTime + gap * 64, "K"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "Space"),

                    new Beat(startTime + gap * 88, "S"),
                    new Beat(startTime + gap * 89, "D"),
                    new Beat(startTime + gap * 90, "S"),
                    new Beat(startTime + gap * 91, "D"),
                    new Beat(startTime + gap * 92, "J"),
                    new Beat(startTime + gap * 93, "K"),
                    new Beat(startTime + gap * 94, "J"),
                    new Beat(startTime + gap * 95, "K"),
                    new Beat(startTime + gap * 96, "D"),
                    new Beat(startTime + gap * 97, "F"),
                    new Beat(startTime + gap * 98, "L"),
                    new Beat(startTime + gap * 99, "Space"),
                    new Beat(startTime + gap * 100, "S"),
                    new Beat(startTime + gap * 101, "J"),
                    new Beat(startTime + gap * 102, "S"),
                    new Beat(startTime + gap * 103, "D"),
                    new Beat(startTime + gap * 104, "S"),
                    new Beat(startTime + gap * 105, "D"),
                    new Beat(startTime + gap * 106, "J"),
                    new Beat(startTime + gap * 107, "K"),
                    new Beat(startTime + gap * 108, "J"),
                    new Beat(startTime + gap * 109, "K"),
                    new Beat(startTime + gap * 110, "D"),
                    new Beat(startTime + gap * 111, "F"),
                    new Beat(startTime + gap * 112, "L"),
                    new Beat(startTime + gap * 114, "Space"),
                    new Beat(startTime + gap * 114, "F"),
                    new Beat(startTime + gap * 114, "J"),

                    new Beat(startTime + gap * 116, "K"),
                    new Beat(startTime + gap * 118, "L"),
                    new Beat(startTime + gap * 120, "J"),
                    new Beat(startTime + gap * 122, "K"),
                    new Beat(startTime + gap * 124, "J"),
                    new Beat(startTime + gap * 126, "K"),
                    new Beat(startTime + gap * 128, "L"),
                    new Beat(startTime + gap * 130, "Space"),
                    new Beat(startTime + gap * 132, "D"),
                    new Beat(startTime + gap * 132, "K"),
                    new Beat(startTime + gap * 134, "S"),
                    new Beat(startTime + gap * 134, "L"),
                    new Beat(startTime + gap * 136, "D"),
                    new Beat(startTime + gap * 136, "K"),
                    new Beat(startTime + gap * 138, "S"),
                    new Beat(startTime + gap * 138, "L"),
                    new Beat(startTime + gap * 140, "D"),
                    new Beat(startTime + gap * 140, "K"),
                    new Beat(startTime + gap * 142, "S"),
                    new Beat(startTime + gap * 142, "L"),
                    new Beat(startTime + gap * 144, "K"),
                    new Beat(startTime + gap * 144, "D"),
                    new Beat(startTime + gap * 146, "S"),
                    new Beat(startTime + gap * 146, "L"),
                    new Beat(startTime + gap * 148, "F"),
                    new Beat(startTime + gap * 148, "J"),
                    new Beat(startTime + gap * 150, "D"),
                    new Beat(startTime + gap * 150, "K"),
                    new Beat(startTime + gap * 152, "F"),
                    new Beat(startTime + gap * 152, "J"),
                    new Beat(startTime + gap * 154, "D"),
                    new Beat(startTime + gap * 154, "K"),
                    new Beat(startTime + gap * 156, "F"),
                    new Beat(startTime + gap * 156, "L"),
                    new Beat(startTime + gap * 158, "Space"),
                    new Beat(startTime + gap * 160, "S"),
                    new Beat(startTime + gap * 160, "L"),
                    new Beat(startTime + gap * 162, "D"),
                    new Beat(startTime + gap * 162, "K"),
                    new Beat(startTime + gap * 164, "F"),
                    new Beat(startTime + gap * 164, "J"),
                    new Beat(startTime + gap * 166, "J"),
                    new Beat(startTime + gap * 166, "F"),
                    new Beat(startTime + gap * 168, "K"),
                    new Beat(startTime + gap * 168, "D"),
                    new Beat(startTime + gap * 170, "L"),
                    new Beat(startTime + gap * 170, "S"),

                    new Beat(startTime + gap * 172, "S"),
                    new Beat(startTime + gap * 174, "D"),
                    new Beat(startTime + gap * 176, "S"),
                    new Beat(startTime + gap * 178, "J"),
                    new Beat(startTime + gap * 180, "K"),
                    new Beat(startTime + gap * 182, "J"),
                    new Beat(startTime + gap * 184, "D"),
                    new Beat(startTime + gap * 186, "F"),
                    new Beat(startTime + gap * 188, "D"),
                    new Beat(startTime + gap * 190, "K"),
                    new Beat(startTime + gap * 192, "L"),
                    new Beat(startTime + gap * 194, "K"),
                    new Beat(startTime + gap * 196, "Space"),
                    new Beat(startTime + gap * 196, "D"),
                    new Beat(startTime + gap * 196, "F"),
                    new Beat(startTime + gap * 196, "J"),
                    new Beat(startTime + gap * 196, "K"),

                    new Beat(startTime + gap * 198, "S"),
                    new Beat(startTime + gap * 200, "D"),
                    new Beat(startTime + gap * 202, "F"),
                    new Beat(startTime + gap * 204, "D"),
                    new Beat(startTime + gap * 206, "S"),
                    new Beat(startTime + gap * 208, "K"),
                    new Beat(startTime + gap * 210, "L"),
                    new Beat(startTime + gap * 212, "J"),
                    new Beat(startTime + gap * 214, "K"),
                    new Beat(startTime + gap * 216, "J"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 220, "L"),
                    new Beat(startTime + gap * 222, "Space"),
                    new Beat(startTime + gap * 224, "D"),
                    new Beat(startTime + gap * 224, "K"),
                    new Beat(startTime + gap * 226, "S"),
                    new Beat(startTime + gap * 226, "L"),
                    new Beat(startTime + gap * 228, "D"),
                    new Beat(startTime + gap * 228, "K"),
                    new Beat(startTime + gap * 230, "S"),
                    new Beat(startTime + gap * 230, "L"),
                    new Beat(startTime + gap * 232, "D"),
                    new Beat(startTime + gap * 232, "K"),
                    new Beat(startTime + gap * 234, "S"),
                    new Beat(startTime + gap * 234, "L"),
                    new Beat(startTime + gap * 236, "K"),
                    new Beat(startTime + gap * 236, "D"),
                    new Beat(startTime + gap * 238, "L"),
                    new Beat(startTime + gap * 238, "S"),
                    new Beat(startTime + gap * 240, "J"),
                    new Beat(startTime + gap * 240, "F"),
                    new Beat(startTime + gap * 242, "K"),
                    new Beat(startTime + gap * 242, "D"),
                    new Beat(startTime + gap * 244, "J"),
                    new Beat(startTime + gap * 244, "F"),
                    new Beat(startTime + gap * 246, "K"),
                    new Beat(startTime + gap * 246, "D"),
                    new Beat(startTime + gap * 248, "L"),
                    new Beat(startTime + gap * 248, "F"),
                    new Beat(startTime + gap * 250, "Space"),
                    new Beat(startTime + gap * 252, "S"),
                    new Beat(startTime + gap * 254, "D"),
                    new Beat(startTime + gap * 256, "S"),
                    new Beat(startTime + gap * 258, "J"),
                    new Beat(startTime + gap * 260, "K"),
                    new Beat(startTime + gap * 262, "J"),
                    new Beat(startTime + gap * 264, "Space"),

                    new Beat(startTime + gap * 266, "S"),
                    new Beat(startTime + gap * 268, "D"),
                    new Beat(startTime + gap * 270, "S"),
                    new Beat(startTime + gap * 272, "D"),
                    new Beat(startTime + gap * 274, "S"),
                    new Beat(startTime + gap * 276, "D"),
                    new Beat(startTime + gap * 278 - 80, "S"),
                    new Beat(startTime + gap * 280 - 130, "D"),
                    new Beat(startTime + gap * 281, "F"),
                    new Beat(startTime + gap * 284, "J"),
                    new Beat(startTime + gap * 286 - 80, "K"),
                    new Beat(startTime + gap * 288 - 130, "L"),
                    new Beat(startTime + gap * 289, "J"),
                    new Beat(startTime + gap * 290, "K"),
                    new Beat(startTime + gap * 291, "J"),
                    new Beat(startTime + gap * 292, "K"),
                    new Beat(startTime + gap * 293, "L"),
                    new Beat(startTime + gap * 294, "Space"),

            };
        }
        gameMusic.start();

        int i = 0;
        while (i < beats.length && !isInterrupted()){
            boolean dropped = false;
            if (beats[i].getTime() <= gameMusic.getTime()){
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if (!dropped ){
                try {
                    Thread.sleep(5);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //判定方块函数
    public void  judge(String input){
        for (int i = 0; i < noteList.size(); i++) {
               Note note = noteList.get(i);
               if (input.equals(note.getNoteType())){
                   judgeEvent(note.judge());
                   break;
               }
        }
    }
    //判断事件，判断显示等级
    public void judgeEvent(String judge){
        if (!judge.equals("None")){
            blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
        }
        if(judge.equals("Miss")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
        }
        else if(judge.equals("Late")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
        }
        else if(judge.equals("Early")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
        }
        else if(judge.equals("Good")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
        }
        else if(judge.equals("Prefect")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgePrefect.png")).getImage();
        }
    }

}