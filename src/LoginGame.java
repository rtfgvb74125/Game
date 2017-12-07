import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginGame extends JFrame{
    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 600,frmH = 500,MarioX = 300,MarioY = 380;
    private JButton jbtnStart = new JButton("START");
    private Container cp;
    private ImageIcon MarioR = new ImageIcon("Image/mini.png");
    private ImageIcon MarioL = new ImageIcon("Image/minileft.png");
    private JLabel jlabground = new JLabel();
    private JLabel Mario = new JLabel(MarioR);
    private JLabel Title1 = new JLabel("SUPER");
    private JLabel Title2 = new JLabel("MARIO");
    private Boolean cheak = true;
    private Timer t1;
    public LoginGame(){
        init();
    }
    private void init(){
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setBackground(Color.CYAN);
        this.setLayout(null);
        this.add(jlabground);
        this.add(Mario);
        this.add(Title1);
        this.add(Title2);
        this.add(jbtnStart);
        jlabground.setBounds(0,430,600,40);
        jlabground.setOpaque(true);
        jlabground.setBackground(new Color(142, 90, 52));
        Mario.setBounds(MarioX,MarioY,50,50);
        jbtnStart.setBounds(150,150,300,50);
        Title1.setBounds(90,10,300,100);
        Title1.setHorizontalAlignment(SwingConstants.CENTER);
        Title1.setFont(new Font(null,Font.BOLD,35));
        Title2.setBounds(250,50,300,100);
        Title2.setHorizontalAlignment(SwingConstants.CENTER);
        Title2.setFont(new Font(null,Font.BOLD,35));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                t1.start();
            }
        });
        jbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameControl gamec = new GameControl();
                gamec.setVisible(true);
                dispose();
            }
        });
        t1 = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(MarioX<550 & cheak){
                        MarioX++;
                        if(MarioX==550){
                            cheak = false;
                        }
                        Mario.setLocation(MarioX,MarioY);
                    }else {
                        MarioX--;
                        if(MarioX==0){
                            cheak = true;
                        }
                        Mario.setLocation(MarioX,MarioY);
                    }
            }
        });
    }
}
