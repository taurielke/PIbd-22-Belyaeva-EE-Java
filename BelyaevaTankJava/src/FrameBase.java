import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;

public class FrameBase extends JFrame {
    private JPanel panelBase;
    private JPanel panelBaseParkVehicles;
    private Base<ArmoredCar, Weapon> base;
    private JButton btnParkArmoredCar;
    private JButton btnParkTank;
    private JButton btnTakeAwayVehicle;
    private JPanel panelTakeAwayVehicle;
    private JLabel labelPlace;
    private JTextField textFieldPlaceNumber;
    private ArmoredCar vehicle;


    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            FrameBase frameBase = new FrameBase();
            frameBase.setVisible(true);
        } );
    }

    public FrameBase(){
        super("База");
        setSize(1219, 721);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelBase = new JPanel();
        panelBaseParkVehicles = new JPanel();

        panelBase.setBounds(0, 0, 1219, 721);
        panelBaseParkVehicles.setBounds(5,5,1000,721);

        setContentPane(panelBase);
        panelBase.setLayout(null);

        btnParkArmoredCar = new JButton("Припарковать бм");
        btnParkTank = new JButton("Припарковать танк");
        btnTakeAwayVehicle = new JButton("Забрать");
        panelTakeAwayVehicle = new JPanel();
        labelPlace = new JLabel("Место: ");
        textFieldPlaceNumber = new JTextField();

        textFieldPlaceNumber.setColumns(5);
        btnParkArmoredCar.setBounds(1000,13,170,88);
        btnParkTank.setBounds(1000, 107,170,69);
        panelTakeAwayVehicle.setBounds(1000, 198,170,100);

        labelPlace.setBounds(19,63,61,20);
        textFieldPlaceNumber.setBounds(86,63,58,26);
        btnTakeAwayVehicle.setBounds(19,117,121,34);

        panelBase.add(btnParkArmoredCar);
        panelBase.add(btnParkTank);
        panelBase.add(panelTakeAwayVehicle);
        panelBase.add(panelBaseParkVehicles);

        panelTakeAwayVehicle.add(labelPlace);
        panelTakeAwayVehicle.add(textFieldPlaceNumber);
        panelTakeAwayVehicle.add(btnTakeAwayVehicle);
        panelTakeAwayVehicle.setBorder(BorderFactory.createTitledBorder("Забрать машину"));

        base = new Base<ArmoredCar, Weapon>(panelBaseParkVehicles.getWidth(), panelBaseParkVehicles.getHeight());

        btnParkArmoredCar.addActionListener(e -> {
            Color firstColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
            vehicle = new ArmoredCar(100,1000, firstColor);
            base.Plus(vehicle);

            repaint();
        });

        btnParkTank.addActionListener(e -> {
            Color firstColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
            Color secondColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
            vehicle = new Tank(100,1000, firstColor, secondColor, true, 1);
            base.Plus(vehicle);

            repaint();
        });

        btnTakeAwayVehicle.addActionListener(e -> {

            if(textFieldPlaceNumber.getText() != "")
            {
                int placeNumber = 0;
                placeNumber = Integer.parseInt(textFieldPlaceNumber.getText());
                vehicle = base.Minus(placeNumber);
                if(vehicle != null)
                {
                    FrameTank frameTank = new FrameTank();
                    frameTank.SetArmoredCar(vehicle);
                    frameTank.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Вы ввели неверное число!");
                }
                repaint();
            }

        });
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        base.Draw(g);
    }
}
