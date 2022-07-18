package Mstw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Mstw extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private int mouseX,mouseY;
    private boolean isGameScreen = false;

    //从路径中获取图片
    //背景图片
    private Image Background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();
    //上边界
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

    //制作按钮基础图标和鼠标访问图标
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
    private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
    private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
    private ImageIcon hardButtonBasicImage = new ImageIcon((Main.class.getResource("../images/hardButtonBasic.png")));
    private ImageIcon hardButtonEnteredImage = new ImageIcon((Main.class.getResource("../images/hardButtonEntered.png")));
    private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
    private ImageIcon leftSelectedButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftSelectedButtonBasic.png"));
    private ImageIcon leftSelectedButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftSelectedButtonEntered.png"));
    private ImageIcon rightSelectedButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightSelectedButtonBasic.png"));
    private ImageIcon rightSelectedButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightSelectedButtonEntered.png"));

    //设置按钮
    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);
    private JButton backButton = new JButton(backButtonBasicImage);
    private JButton leftSelectedButton = new JButton(leftSelectedButtonBasicImage);
    private JButton rightSelectedButton = new JButton(rightSelectedButtonBasicImage);

    private boolean isMainScreen = false;

    //创建数组列表来保存可选择的不同歌曲
    ArrayList<Track> trackList = new ArrayList<Track>();
    //音乐对应标题图片
    private Image titleImage;
    //选择不同音乐开始的不同封面
    private Image selectedImage;
    //所选择的bgm
    private Music selectedMusic;
    private int nowSelected = 0;
    //定义Music变量introMusic,传入首界面bgm
    Music introMusic = new Music("bgm.mp3",true);

    public static Game game;

    //构造方法
    public Mstw(){
        //将不同歌曲的属性加入到音乐列表中,并且便于组织
        trackList.add(new Track("Celebrate TitleImage.png", "Celebrate startImage.png", "gameBackground.jpg","Celebrate1.mp3", "Celebrate1.mp3", "Celebrate - Joakim Karud"));
        trackList.add(new Track("Future Funk TitleImage.png", "Future Funk startImage.png", "gameBackground.jpg","Future Funk1.mp3", "Future Funk1.mp3", "Future Funk - Joakim Karud"));

        //设置GUI界面
        setFocusable(true);                                 //设置屏幕焦点，以便于监听键盘
        setUndecorated(true);
        setTitle("Melodic sound travels the world");        //设置界面标题
        setSize(Main.screen_width,Main.screen_height);      //设置界面大小
        setResizable(true);                                 //设置窗口可以由用户自由调节大小
        setLocationRelativeTo(null);                        //设置窗口相对于指定组件的位置,null为屏幕中央
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //设置界面执行程序可关闭
        setVisible(true);                                   //设置界面可见
        setBackground(new Color(0, 0, 0, 0));   //设置背景颜色
        setLayout(null);                                    //设置布局为空


        //执行线程,播放音乐
        introMusic.start();


        
        //设置右上角退出按钮
        quitButton.setBounds(1850, 0, 30, 30);  //设置按钮位置
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(quitButton);

        //设置上边界,并且可以移动它
        menuBar.setBounds(0, 0, 1920, 30);
        menuBar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);

        //设置离开EXIT按钮
        exitButton.setBounds(1100, 780, 169, 99);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //设置按钮反应时间
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);

        //设置开始Start按钮
        startButton.setBounds(650, 780, 169, 99);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //设置按钮反应时间
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //调用相应函数
                enterMain();
           }
        });
        add(startButton);

        //设置左选择按钮
        leftSelectedButton.setVisible(false);
        leftSelectedButton.setBounds(350, 450, 100, 100);
        leftSelectedButton.setBorderPainted(false);
        leftSelectedButton.setContentAreaFilled(false);
        leftSelectedButton.setFocusPainted(false);
        leftSelectedButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                leftSelectedButton.setIcon(leftSelectedButtonBasicImage);
                leftSelectedButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                leftSelectedButton.setIcon(leftSelectedButtonEnteredImage);
                leftSelectedButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                selectLift();   //按左选按钮调用selectLift函数
            }
        });
        add(leftSelectedButton);

        //设置右选择按钮
        rightSelectedButton.setVisible(false);
        rightSelectedButton.setBounds(1470, 450, 100, 100);
        rightSelectedButton.setBorderPainted(false);
        rightSelectedButton.setContentAreaFilled(false);
        rightSelectedButton.setFocusPainted(false);
        rightSelectedButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                rightSelectedButton.setIcon(rightSelectedButtonBasicImage);
                rightSelectedButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                rightSelectedButton.setIcon(rightSelectedButtonEnteredImage);
                rightSelectedButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                selectRight();  //按右选按钮调用selectRight函数
            }
        });
        add(rightSelectedButton);

        //设置简单按钮
        easyButton.setVisible(false);
        easyButton.setBounds(550, 800, 300, 150);  //设置按钮位置
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                Main.scout = 0;
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //开始游戏，难度为Easy
                gameStart(nowSelected,"Easy");
            }
        });
        add(easyButton);

        //设置困难按钮
        hardButton.setVisible(false);
        hardButton.setBounds(1070, 800, 300, 150);  //设置按钮位置
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                Main.scout = 0;
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //开始游戏，难度为Hard
                gameStart(nowSelected,"Hard");
            }
        });
        add(hardButton);

        //设置返回按钮
        backButton.setBounds(20, 50, 100, 100);
        backButton.setVisible(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e){
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            //鼠标访问
            @Override
            public void mouseEntered(MouseEvent e){
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            //鼠标点击
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //设置按钮反应时间
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //返回上一个界面
                backMain(); //返回界面函数
            }
        });
        add(backButton);

    }

    //重写Graphics类的paint方法进行绘图
    public void paint(Graphics g){
        //创建一幅用于双缓冲，可以在屏幕外绘制的图像
        screenImage = createImage(Main.screen_width,Main.screen_height);
        //得到一个Graphics对象
        screenGraphic = screenImage.getGraphics();
        //调用screenDraw方法进行绘画
        screenDraw((Graphics2D) screenGraphic);
        //Graphics对象g调用drawImage方法,要加载的图像为screenImage,绘制图像矩阵左上角的位置为(0,0),容器为空
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics2D g) {

        //Graphics对象g调用drawImage方法,要加载的图像为introBackground,绘制图像矩阵左上角的位置为(0,0),容器为空
        g.drawImage(Background,0,0,null);
        //如果是游戏选择界面的话就绘制图片和标题
        if (isMainScreen){
            g.drawImage(selectedImage, 710, 250, null);
            g.drawImage(titleImage, 710, 150, null);
        }
        //如果进入到游戏屏幕，才能实现游戏功能
        if (isGameScreen){
            game.screenDraw(g);
        }
        paintComponents(g);
        try{
            Thread.sleep(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        //重绘图像
        this.repaint();

    }
    //根据当前所选择的音乐变换bgm和图片
    public void selectTrack(int nowSelected){
        if (selectedMusic != null){
            selectedMusic.close();
        }
        titleImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    //向左选择的函数
    public void selectLift(){
        //如果是第一首再按左就跳到最后一首
        if (nowSelected == 0){
            nowSelected = trackList.size() - 1;
        }
        else {
            nowSelected --;
        }
        selectTrack(nowSelected);   //调用方法实现歌曲和图片的切换
    }
    //向右选择的函数
    public void selectRight(){
        //如果是最后一首再按左就跳到第一首
        if (nowSelected == trackList.size() - 1){
            nowSelected = 0;
        }
        else {
            nowSelected ++;
        }
        selectTrack(nowSelected);   //调用方法实现歌曲和图片的切换
    }

    //开始游戏执行的函数，参数为选择的难度
    public void gameStart(int nowSelected,String difficulty){
        if (selectedMusic != null){
            selectedMusic.close();
        }
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        backButton.setVisible(true);
        leftSelectedButton.setVisible(false);
        rightSelectedButton.setVisible(false);
        Background = new ImageIcon(Main.class.getResource("../images/gameBackground.jpg")).getImage();
        isGameScreen = true;
        isMainScreen = false;
        //接收键盘事件
        addKeyListener(new KeyListener_());
        //对于不同歌曲传入不同参数
        game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
        game.start();
        //始终捕捉键盘焦点
        setFocusable(true);
    }

    //点击返回按钮返回上一个界面的函数
    public void backMain(){
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        backButton.setVisible(false);
        leftSelectedButton.setVisible(true);
        rightSelectedButton.setVisible(true);
        Background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        isMainScreen = true;    //返回的第二个界面是游戏选择界面
        selectTrack(nowSelected);
        //第二个界面不是正式游戏界面
        isGameScreen = false;
        //关闭游戏中的音乐
        game.close();
    }

    public void enterMain(){
        //点击开始按钮后隐藏start和exit按钮
        startButton.setVisible(false);
        exitButton.setVisible(false);
        //点击开始按钮后显示easy和hard按钮和左右选择按钮
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        leftSelectedButton.setVisible(true);
        rightSelectedButton.setVisible(true);
        Background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        //进入到游戏主界面(选择界面)
        isMainScreen = true;
        //点击开始按钮关闭第一个页面的bgm
        introMusic.close();
        //默认点击开始首先进入第一首歌
        selectTrack(0);
    }

}
