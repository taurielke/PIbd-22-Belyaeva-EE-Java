import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class FrameTank extends JFrame{
    private JPanel panelTank;
    private ITransport armoredCar;

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelTank = new JPanel();
        panelTank.setBounds(0, 0, 1219, 721);
        setContentPane(panelTank);
        panelTank.setLayout(null);

        Icon up = new ImageIcon("D:\\Java\\up.jpg");
        Icon left = new ImageIcon("D:\\Java\\left.jpg");
        Icon down = new ImageIcon("D:\\Java\\down.jpg");
        Icon right = new ImageIcon("D:\\Java\\right.jpg");

        JButton btnCreateArmoredCar = new JButton("Создать бронированную машину");
        JButton btnCreateTank = new JButton("Создать танк");
        JButton btnUp = new JButton(up);
        JButton btnDown = new JButton(down);
        JButton btnLeft = new JButton(left);
        JButton btnRight = new JButton(right);

        btnCreateArmoredCar.setBounds(12, 12, 273, 48);
        btnCreateTank.setBounds(304, 12, 154, 47);
        btnUp.setBounds(1048, 513, 70, 70);
        btnDown.setBounds(1048, 589, 70, 70);
        btnLeft.setBounds(972, 589, 70, 70);
        btnRight.setBounds(1124, 589, 70, 70);

        panelTank.add(btnCreateArmoredCar);
        panelTank.add(btnCreateTank);
        panelTank.add(btnUp);
        panelTank.add(btnDown);
        panelTank.add(btnLeft);
        panelTank.add(btnRight);

        btnCreateArmoredCar.addActionListener(e -> {
            Random rnd = new Random();
            armoredCar = new ArmoredCar(rnd.nextInt(200) + 100, rnd.nextInt(1000)+1000, Color.BLACK);
            armoredCar.SetPosition(rnd.nextInt(100)+100, rnd.nextInt(100)+100, panelTank.getWidth(), panelTank.getHeight());
            repaint();
        });

        btnCreateTank.addActionListener(e -> {
            Random rnd = new Random();
            int weaponAmount = rnd.nextInt(3)+1;
            armoredCar = new Tank(rnd.nextInt(200) + 100, rnd.nextInt(1000)+1000, Color.BLACK, Color.GREEN, true,  weaponAmount);
            armoredCar.SetPosition(rnd.nextInt(100)+100, rnd.nextInt(100)+100, panelTank.getWidth(), panelTank.getHeight());
            repaint();
        });

        btnUp.addActionListener(e ->{
            armoredCar.MoveTransport(Direction.Up);
            repaint();
        });

        btnDown.addActionListener(e ->{
            armoredCar.MoveTransport(Direction.Down);
            repaint();
        });

        btnLeft.addActionListener(e ->{
            armoredCar.MoveTransport(Direction.Left);
            repaint();
        });

        btnRight.addActionListener(e ->{
            armoredCar.MoveTransport(Direction.Right);
            repaint();
        });
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        if(armoredCar != null)
            armoredCar.DrawTransport(g);
    }

    public void repaint()
    {
        super.repaint();
    }

    public void SetArmoredCar(ITransport armoredCar)
    {
        Random rnd = new Random();
        this.armoredCar = armoredCar;
        armoredCar.SetPosition(rnd.nextInt(100)+100, rnd.nextInt(100)+100, panelTank.getWidth(), panelTank.getHeight());
        repaint();
    }
}
