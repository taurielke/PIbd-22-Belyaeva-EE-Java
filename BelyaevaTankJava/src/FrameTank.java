import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class FrameTank extends JFrame{
    private JPanel panelTank;
    private Tank tank;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            FrameTank frameTank = new FrameTank();
            frameTank.setVisible(true);
        } );
    }

    public FrameTank(){
        super("Танк");

        setSize(1219, 721);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelTank = new JPanel();
        panelTank.setBounds(0, 0, 1219, 721);
        setContentPane(panelTank);
        panelTank.setLayout(null);

        Icon up = new ImageIcon("D:\\Java\\up.jpg");
        Icon left = new ImageIcon("D:\\Java\\left.jpg");
        Icon down = new ImageIcon("D:\\Java\\down.jpg");
        Icon right = new ImageIcon("D:\\Java\\right.jpg");

        JButton btnCreate = new JButton("Создать");
        JButton btnUp = new JButton(up);
        JButton btnDown = new JButton(down);
        JButton btnLeft = new JButton(left);
        JButton btnRight = new JButton(right);

        btnCreate.setBounds(12, 12, 91, 39);
        btnUp.setBounds(1048, 513, 70, 70);
        btnDown.setBounds(1048, 589, 70, 70);
        btnLeft.setBounds(972, 589, 70, 70);
        btnRight.setBounds(1124, 589, 70, 70);

        panelTank.add(btnCreate);
        panelTank.add(btnUp);
        panelTank.add(btnDown);
        panelTank.add(btnLeft);
        panelTank.add(btnRight);

        btnCreate.addActionListener(e -> {
            Random rnd = new Random();
            tank = new Tank();
            int weaponAmount = rnd.nextInt(3)+1;
            tank.Init(rnd.nextInt(200) + 100, rnd.nextInt(1000)+1000, Color.BLACK, Color.GREEN, true,  weaponAmount);
            tank.SetPosition(rnd.nextInt(100)+50, rnd.nextInt(100)+50, panelTank.getWidth(), panelTank.getHeight());
            repaint();
        });

        btnUp.addActionListener(e ->{
            tank.MoveTransport(Direction.Up);
            repaint();
        });

        btnDown.addActionListener(e ->{
            tank.MoveTransport(Direction.Down);
            repaint();
        });

        btnLeft.addActionListener(e ->{
            tank.MoveTransport(Direction.Left);
            repaint();
        });

        btnRight.addActionListener(e ->{
            tank.MoveTransport(Direction.Right);
            repaint();
        });
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        if(tank != null)
            tank.DrawTransport(g);
    }

    public void repaint()
    {
        super.repaint();
    }
}
