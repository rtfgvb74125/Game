import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame {
    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 1000, frmH = 400, MarioX = 500, MarioY = 300,GuguX = 950,GuguY = 300,BrickX = 600,BrickY = 300;
    private int c = 0, t =0;
    private Timer marioUP;
    private Timer guguRun;
    private Timer gameTime;
    private ImageIcon mariomini = new ImageIcon("Image/mini.png");
    private ImageIcon mariominileft = new ImageIcon("Image/minileft.png");
    private ImageIcon mario = new ImageIcon("Image/m.png");
    private ImageIcon marioleft = new ImageIcon("Image/mleft.png");
    private ImageIcon marioup = new ImageIcon("Image/mup.png");
    private ImageIcon marioupleft = new ImageIcon("Image/mupleft.png");
    private ImageIcon bigup = new ImageIcon("Image/bigup.png");
    private ImageIcon bigupleft = new ImageIcon("Image/bigupleft.png");
    private ImageIcon gugu = new ImageIcon("Image/mario_gugu.png");
    private ImageIcon brick = new ImageIcon("Image/brick.png");
    private JLabel jlabMario = new JLabel(mariomini);
    private JLabel jlabBigM = new JLabel(marioleft);
    private JLabel jlabGugu = new JLabel(gugu);
    private JLabel jlabbrick = new JLabel(brick);
    private JLabel jlabGround = new JLabel();
    private JButton jbStart = new JButton("Start");
    private JLabel jlCount = new JLabel("Coin");
    private JTextField jtxCount = new JTextField("0");
    private JLabel jlTime = new JLabel("Time :");
    private JTextField jtxTime = new JTextField("0");
    private JPanel jpnSouth = new JPanel(new GridLayout(1, 9, 3, 3));
    //    private JLabel jlabrick[] = new JLabel[20];
//    private int data[] = new int[20];
//    private JPanel jpGround = new JPanel(new GridLayout(1,20,0,0));
    private Container cp;
    private boolean cheak = true;
    private boolean cheak2 = false;
    private boolean cImage = true;

    public test() {
        init();
    }

    private void init() {
        this.setTitle("Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW / 2 - frmW / 2, ScreenH / 2 - frmH / 2, frmW, frmH);
        this.setLayout(null);
//        this.setResizable(false);
        this.add(jlabMario);
        this.add(jlabGround);
        this.add(jlabGugu);
        this.add(jlabBigM);
        this.add(jlabbrick);
        jtxCount.setEditable(false);
        jtxTime.setEditable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                guguRun.start();
                gameTime.start();
            }
        });
        jlabBigM.setVisible(false);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        cp.setBackground(Color.CYAN);
        jlabMario.setBounds(MarioX, MarioY, 50, 50);
        jlabGugu.setBounds(GuguX, GuguY, 50, 50);
        jlabbrick.setBounds(BrickX,BrickY,50,50);
        jlabMario.setBackground(Color.BLUE);
        jlabGround.setBounds(0, 870, 1000, 100);
        jlabGround.setBackground(new Color(0x855E2C));
        jlabGround.setOpaque(true);
        jtxCount.setEnabled(true);
        jtxTime.setEnabled(true);
//        jpnSouth.add(jbStart);
        jpnSouth.add(jlCount);
        jpnSouth.add(jtxCount);
        jpnSouth.add(jlTime);
        jpnSouth.add(jtxTime);
        cp.add(jpnSouth, BorderLayout.NORTH);
//        cp.add(jpGround,BorderLayout.SOUTH);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        if(MarioX < 950){
                            MarioX += 10;
                            if (cImage) {
                                jlabMario.setIcon(mariomini);
                                jlabMario.setLocation(MarioX, MarioY);
                                jlabBigM.setIcon(mario);
                                jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                            } else {
                                jlabMario.setIcon(marioup);
                                jlabMario.setLocation(MarioX, MarioY);
                                jlabBigM.setIcon(bigup);
                            }
                            gugubig();
                            jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                        }
                        System.out.println(jlabMario.getX()+"\t"+(jlabMario.getY()-25));
                        break;
                    case KeyEvent.VK_LEFT:
                        if(MarioX > 0){
                            MarioX -= 10;
                            if (cImage) {
                                jlabMario.setIcon(mariominileft);
                                jlabMario.setLocation(MarioX, MarioY);
                                jlabBigM.setIcon(marioleft);
                                jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                            } else {
                                jlabMario.setIcon(marioupleft);
                                jlabMario.setLocation(MarioX, MarioY);
                                jlabBigM.setIcon(bigupleft);
                            }
                            gugubig();
                            jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                        }
                        System.out.println(jlabMario.getX()+"\t"+(jlabMario.getY()-25));
                        break;
                    case KeyEvent.VK_UP:
                        cImage = false;
                        marioUP.start();
                        jlabMario.setIcon(marioup);
                        jlabBigM.setIcon(bigup);
                        gugubig();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        marioUP = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MarioY > 200 && cheak) {
                    MarioY--;
                    if (MarioY == 200) {
                        cheak = false;
                    }
                    jlabMario.setLocation(MarioX, MarioY);
                    jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                } else {
                    MarioY++;
                    if (MarioY == 300) {
                        cheak = true;
                        marioUP.stop();
                        jlabMario.setIcon(mariomini);
                        jlabBigM.setIcon(mario);
                        cImage = true;
                    }

                    jlabMario.setLocation(MarioX, MarioY);
                    jlabBigM.setLocation(jlabMario.getX(),jlabMario.getY()-25);
                }
            }
        });

        guguRun = new Timer(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuguX--;
                jlabGugu.setLocation(GuguX,GuguY);
                gugubig();
                System.out.println(GuguX);
//                guguRun.stop();
            }
        });

        gameTime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t++;
                jtxTime.setText(Integer.toString(t));
            }
        });

//        for(int i = 0;i<20;i++){
//            jlabrick[i] = new JLabel();
//            jlabrick[i].setIcon(brick);
//            jpGround.add(jlabground[i]);
//        }
    }
    private void gugubig(){
        if((MarioX>=GuguX && MarioX<=GuguX+50) && (MarioY<=GuguY && MarioY>=GuguY-50)){
            jlabBigM.setBounds(GuguX,GuguY-25,50,75);
            jlabBigM.setVisible(true);
//            this.add(jlabBigM);
            System.out.println(jlabMario.getX()+"\t"+(jlabMario.getY()-25));
            jlabMario.setVisible(false);
            jlabGugu.setVisible(false);
            guguRun.stop();
        }
    }
    private void stopbrick(){

    }
}




