import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControl extends JFrame {
    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 1000, frmH = 1000, MarioX = 500, MarioY = 820;
    private int c = 0;
    private Timer t1;
    private ImageIcon mariomini = new ImageIcon("Image/mini.png");
    private ImageIcon mariominileft = new ImageIcon("Image/minileft.png");
    private ImageIcon mario = new ImageIcon("Image/m.png");
    private ImageIcon marioleft = new ImageIcon("Image/mleft.png");
    private ImageIcon marioup = new ImageIcon("Image/mup.png");
    private ImageIcon marioupleft = new ImageIcon("Image/mupleft.png");
    private ImageIcon gugu = new ImageIcon("Image/mario_gugu.png");
    private ImageIcon brick = new ImageIcon("Image/brick.png");
    private JLabel jlabMario = new JLabel(mariomini);
    private JLabel jlabGugu = new JLabel(gugu);
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

    public GameControl() {
        init();
    }

    private void init() {
        this.setTitle("Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW / 2 - frmW / 2, ScreenH / 2 - frmH / 2, frmW, frmH);
        this.setLayout(null);
        this.add(jlabMario);
        this.add(jlabGround);
        this.add(jlabGugu);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        jlabMario.setBounds(MarioX, MarioY, 50, 50);
        jlabGugu.setBounds(0, 845, 25, 25);
        jlabMario.setBackground(Color.BLUE);
        jlabGround.setBounds(0, 870, 1000, 40);
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
                        MarioX += 10;
                        if (cImage) {
                            jlabMario.setIcon(mariomini);
                            jlabMario.setLocation(MarioX, MarioY);
                        } else {
                            jlabMario.setIcon(marioup);
                            jlabMario.setLocation(MarioX, MarioY);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        MarioX -= 10;
//                        if(MarioX <= 25 && MarioY>=845){
//                            jlabMario.setIcon(marioleft);
//                            jlabMario.setLocation(500,800);
//                            c++;
//                            jtxCount.setText(Integer.toString(c));
//
//                        }
                        if (cImage) {
                            jlabMario.setIcon(mariominileft);
                            jlabMario.setLocation(MarioX, MarioY);
                        } else {
                            jlabMario.setIcon(marioupleft);
                            jlabMario.setLocation(MarioX, MarioY);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        cImage = false;
                        t1.start();
                        jlabMario.setIcon(marioup);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        t1 = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MarioY > 596 && cheak) {
                    MarioY--;
                    if (MarioY == 596) {
                        cheak = false;
                    }
                    jlabMario.setLocation(MarioX, MarioY);
                } else {
                    MarioY++;
                    if (MarioY == 820) {
                        cheak = true;
                        t1.stop();
                        jlabMario.setIcon(mariomini);
                        cImage = true;
                    }

                    jlabMario.setLocation(MarioX, MarioY);
                }
            }
        });

//        for(int i = 0;i<20;i++){
//            jlabrick[i] = new JLabel();
//            jlabrick[i].setIcon(brick);
//            jpGround.add(jlabground[i]);
//        }
    }
}




