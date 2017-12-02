import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControl extends JFrame{
    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 1000,frmH = 800,MarioX = 500,MarioY = 596;
    private Timer t1 ;
    private ImageIcon mario = new ImageIcon("Image/m.png");
    private ImageIcon marioleft = new ImageIcon("Image/mleft.png");
    private ImageIcon marioup = new ImageIcon("Image/mup.png");
    private JLabel jlabMario = new JLabel(mario);
    private JLabel jlabGround = new JLabel();
    private JButton jbStart = new JButton("Start");
    private JLabel jlCount = new JLabel("Count");
    private JTextField jtxCount = new JTextField("0");
    private JLabel jlTime = new JLabel("Time :");
    private JTextField jtxTime = new JTextField("0");
    private JPanel jpnSouth = new JPanel(new GridLayout(1,7,3,3));
    private Container cp;
    private boolean cheak = true;
    private boolean cheak2 = false;
    public GameControl(){
        init();
    }
    private void init(){
        this.setTitle("Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setLayout(null);
        this.add(jlabMario);
        this.add(jlabGround);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        jlabMario.setBounds(MarioX,MarioY,50,75);
        jlabMario.setOpaque(true);
//        jlabMario.setBackground(Color.BLUE);
        jlabGround.setBounds(0,670,1000,40);
        jlabGround.setBackground(new Color(0x855E2C));
        jlabGround.setOpaque(true);
        jpnSouth.add(jbStart);
        jpnSouth.add(jlCount);
        jpnSouth.add(jtxCount);
        jpnSouth.add(jlTime);
        jpnSouth.add(jtxTime);
        cp.add(jpnSouth,BorderLayout.SOUTH);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        MarioX+=10;
                        jlabMario.setIcon(mario);
                        jlabMario.setLocation(MarioX,MarioY);

                        break;
                    case KeyEvent.VK_LEFT:
                        MarioX-=10;
                        jlabMario.setIcon(marioleft);
                        jlabMario.setLocation(MarioX,MarioY);
                        break;
                    case KeyEvent.VK_UP:
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
                if (MarioY > 496 && cheak) {
                    MarioY--;
                    if (MarioY == 496) {
                        cheak = false;
                    }
                    jlabMario.setLocation(MarioX, MarioY);
                }else{
                    MarioY++;
                    if (MarioY==596) {
                        cheak = true;
                        t1.stop();
                        jlabMario.setIcon(mario);
                    }

                    jlabMario.setLocation(MarioX, MarioY);
                }
            }
        });
    }



}
