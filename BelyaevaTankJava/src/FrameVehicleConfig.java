import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class FrameVehicleConfig extends JFrame {
    private JPanel panelConfig;
    public Vehicle vehicle;

    private JPanel gpPanelCarType;
    private JLabel labelArmoredCar;
    private JLabel labelTank;
    private JLabel labelTypeChecked;

    private PanelShowVehicle panelShowVehicle;

    private JPanel gpPanelParameters;
    private JLabel labelMaxSpeed;
    private JLabel labelWeight;
    private JCheckBox checkBoxWeapon;
    private JCheckBox checkBoxTower;
    private JSpinner spinnerWeight;
    private JSpinner spinnerMaxSpeed;

    private JPanel gpPanelColors;
    private JPanel panelColor1;
    private JPanel panelColor2;
    private JPanel panelColor3;
    private JPanel panelColor4;
    private JPanel panelColor5;
    private JPanel panelColor6;
    private JPanel panelColor7;
    private JPanel panelColor8;
    private JLabel labelMainColor;
    private JLabel labelDopColor;

    private JPanel gpPanelWeaponType;
    private JLabel labelWeaponType1;
    private JLabel labelWeaponType2;
    private JLabel labelWeaponType3;
    private JLabel labelWeaponTypeChecked;

    private JButton btnAdd;
    private JButton btnCancel;

    public FrameVehicleConfig(FrameBase frameBase)
    {
        super("Выбор транспорта");
        setSize(1050,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelConfig = new JPanel();
        panelConfig.setBounds(5,5,1050,550);
        setContentPane(panelConfig);
        panelConfig.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        gpPanelCarType = new JPanel();
        gpPanelCarType.setLayout(null);
        gpPanelCarType.setBorder(BorderFactory.createTitledBorder("Тип машины"));
        gpPanelCarType.setBounds(12, 12, 259,105);

        labelTank = new JLabel("Танк", SwingConstants.CENTER);
        labelTank.setBounds(21,60,214,30);
        labelTank.setBorder(border);
        labelTank.addMouseListener(new DragMouseAdapter());
        labelTank.setTransferHandler(new TransferHandler("text"));

        labelArmoredCar = new JLabel("Бронированная машина", SwingConstants.CENTER);
        labelArmoredCar.setBounds(21, 20, 214,30);
        labelArmoredCar.setBorder(border);
        labelArmoredCar.addMouseListener(new DragMouseAdapter());
        labelArmoredCar.setTransferHandler(new TransferHandler("text"));

        labelTypeChecked = new JLabel("");
        labelTypeChecked.setBounds(305,30,404,218);
        labelTypeChecked.setTransferHandler(new TransferHandler("text"));

        panelConfig.add(gpPanelCarType);
        panelConfig.add(labelTypeChecked);
        gpPanelCarType.add(labelArmoredCar);
        gpPanelCarType.add(labelTank);

        gpPanelParameters = new JPanel();
        gpPanelParameters.setLayout(null);
        gpPanelParameters.setBounds(12,301,714,208);
        gpPanelParameters.setBorder(BorderFactory.createTitledBorder("Параметры"));

        checkBoxTower = new JCheckBox("Башня");
        checkBoxTower.setBounds(323,70,86,24);
        checkBoxWeapon = new JCheckBox("Оружие");
        checkBoxWeapon.setBounds(323,145,92,24);

        spinnerWeight = new JSpinner(new SpinnerNumberModel(100,100,1000,1));
        spinnerWeight.setBounds(21, 145,103,26);
        spinnerMaxSpeed = new JSpinner(new SpinnerNumberModel(100,100,1000,1));
        spinnerMaxSpeed.setBounds(21,70,103,26);

        labelMaxSpeed = new JLabel("Максимальная скорость: ");
        labelMaxSpeed.setBounds(17,44,203,20);
        labelWeight = new JLabel("Вес машины: ");
        labelWeight.setBounds(17,122,107,20);

        panelConfig.add(gpPanelParameters);
        gpPanelParameters.add(checkBoxTower);
        gpPanelParameters.add(checkBoxWeapon);
        gpPanelParameters.add(labelMaxSpeed);
        gpPanelParameters.add(spinnerMaxSpeed);
        gpPanelParameters.add(labelWeight);
        gpPanelParameters.add(spinnerWeight);

        panelShowVehicle = new PanelShowVehicle();
        panelShowVehicle.setBounds(305,30,404,218);
        panelShowVehicle.setBorder(border);
        panelConfig.add(panelShowVehicle);

        gpPanelColors = new JPanel();
        gpPanelColors.setLayout(null);
        gpPanelColors.setBounds(744, 12,255,249);
        gpPanelColors.setBorder(BorderFactory.createTitledBorder("Цвета"));

        panelColor1 = new JPanel();
        panelColor1.setBorder(border);
        panelColor1.setBackground(Color.CYAN);
        panelColor1.setBounds(194,140,39,36);
        panelColor1.addMouseListener(new DragMouseAdapter());
        panelColor1.setTransferHandler(new TransferHandler("background"));

        panelColor2 = new JPanel();
        panelColor2.setBorder(border);
        panelColor2.setBackground(Color.BLUE);
        panelColor2.setBounds(75,140,39,36);
        panelColor2.addMouseListener(new DragMouseAdapter());
        panelColor2.setTransferHandler(new TransferHandler("background"));

        panelColor3 = new JPanel();
        panelColor3.setBorder(border);
        panelColor3.setBackground(Color.LIGHT_GRAY);
        panelColor3.setBounds(16,140,39,36);
        panelColor3.addMouseListener(new DragMouseAdapter());
        panelColor3.setTransferHandler(new TransferHandler("background"));

        panelColor4 = new JPanel();
        panelColor4.setBorder(border);
        panelColor4.setBackground(Color.MAGENTA);
        panelColor4.setBounds(136,140,39,36);
        panelColor4.addMouseListener(new DragMouseAdapter());
        panelColor4.setTransferHandler(new TransferHandler("background"));

        panelColor5 = new JPanel();
        panelColor5.setBorder(border);
        panelColor5.setBackground(Color.ORANGE);
        panelColor5.setBounds(136,100,39,36);
        panelColor5.addMouseListener(new DragMouseAdapter());
        panelColor5.setTransferHandler(new TransferHandler("background"));

        panelColor6 = new JPanel();
        panelColor6.setBorder(border);
        panelColor6.setBackground(Color.PINK);
        panelColor6.setBounds(75,100,39,36);
        panelColor6.addMouseListener(new DragMouseAdapter());
        panelColor6.setTransferHandler(new TransferHandler("background"));

        panelColor7 = new JPanel();
        panelColor7.setBorder(border);
        panelColor7.setBackground(Color.RED);
        panelColor7.setBounds(194,100,39,36);
        panelColor7.addMouseListener(new DragMouseAdapter());
        panelColor7.setTransferHandler(new TransferHandler("background"));

        panelColor8 = new JPanel();
        panelColor8.setBorder(border);
        panelColor8.setBackground(Color.YELLOW);
        panelColor8.setBounds(16,100,39,36);
        panelColor8.addMouseListener(new DragMouseAdapter());
        panelColor8.setTransferHandler(new TransferHandler("background"));

        labelMainColor = new JLabel("Основной цвет", SwingConstants.CENTER);
        labelMainColor.setBounds(16,38,98,42);
        labelMainColor.setBorder(border);
        labelMainColor.setTransferHandler(new TransferHandler("background"));

        labelDopColor = new JLabel("Доп. цвет", SwingConstants.CENTER);
        labelDopColor.setBounds(136,38,97,42);
        labelDopColor.setBorder(border);
        labelDopColor.setTransferHandler(new TransferHandler("background"));

        btnAdd = new JButton("Добавить");
        btnAdd.setBounds(893,310,106,46);

        btnCancel = new JButton("Отмена");
        btnCancel.setBounds(893,380,106,48);

        panelConfig.add(gpPanelColors);
        panelConfig.add(btnAdd);
        panelConfig.add(btnCancel);

        gpPanelColors.add(labelMainColor);
        gpPanelColors.add(labelDopColor);
        gpPanelColors.add(panelColor1);
        gpPanelColors.add(panelColor2);
        gpPanelColors.add(panelColor3);
        gpPanelColors.add(panelColor4);
        gpPanelColors.add(panelColor5);
        gpPanelColors.add(panelColor6);
        gpPanelColors.add(panelColor7);
        gpPanelColors.add(panelColor8);

        gpPanelWeaponType = new JPanel();
        gpPanelWeaponType.setLayout(null);
        gpPanelWeaponType.setBorder(BorderFactory.createTitledBorder("Тип орудий"));
        gpPanelWeaponType.setBounds(12, 125, 259,145);

        labelWeaponType1 = new JLabel("Конфигурация 1", SwingConstants.CENTER);
        labelWeaponType1.setBounds(21, 20, 214,30);
        labelWeaponType1.setBorder(border);
        labelWeaponType1.addMouseListener(new DragMouseAdapter());
        labelWeaponType1.setTransferHandler(new TransferHandler("text"));

        labelWeaponType2 = new JLabel("Конфигурация 2", SwingConstants.CENTER);
        labelWeaponType2.setBounds(21,60,214,30);
        labelWeaponType2.setBorder(border);
        labelWeaponType2.addMouseListener(new DragMouseAdapter());
        labelWeaponType2.setTransferHandler(new TransferHandler("text"));

        labelWeaponType3 = new JLabel("Конфигурация 3", SwingConstants.CENTER);
        labelWeaponType3.setBounds(21,100,214,30);
        labelWeaponType3.setBorder(border);
        labelWeaponType3.addMouseListener(new DragMouseAdapter());
        labelWeaponType3.setTransferHandler(new TransferHandler("text"));

        labelWeaponTypeChecked = new JLabel("Тип орудия", SwingConstants.CENTER);
        labelWeaponTypeChecked.setBounds(25,190,200,42);
        labelWeaponTypeChecked.setBorder(border);
        labelWeaponTypeChecked.setTransferHandler(new TransferHandler("text"));
        gpPanelColors.add(labelWeaponTypeChecked);

        panelConfig.add(gpPanelWeaponType);
        gpPanelWeaponType.add(labelWeaponType1);
        gpPanelWeaponType.add(labelWeaponType2);
        gpPanelWeaponType.add(labelWeaponType3);

        PropertyChangeListener weaponTypeListener = propertyChangeEvent -> {
            if (vehicle != null && checkBoxWeapon.isSelected())
            {
                Tank tank = (Tank)vehicle;
                if(Objects.equals(labelWeaponTypeChecked.getText(), "Конфигурация 1"))
                {
                    Random rnd = new Random();
                    int weaponAmount = rnd.nextInt(3) + 1;
                    tank.setWeaponType(new Weapon(weaponAmount));
                }
                if(Objects.equals(labelWeaponTypeChecked.getText(), "Конфигурация 2"))
                {
                    Random rnd = new Random();
                    int weaponAmount = rnd.nextInt(3) + 1;
                    tank.setWeaponType(new WeaponDifferentForm1(weaponAmount));
                }
                if(Objects.equals(labelWeaponTypeChecked.getText(), "Конфигурация 3"))
                {
                    Random rnd = new Random();
                    int weaponAmount = rnd.nextInt(3) + 1;
                    tank.setWeaponType(new WeaponDifferentForm2(weaponAmount));
                }
                vehicle = tank;
                panelShowVehicle.setVehicle(vehicle);
                repaint();
            }
        };

        PropertyChangeListener carTypeListener = propertyChangeEvent -> {
          if(Objects.equals(labelTypeChecked.getText(), "Бронированная машина"))
          {
              SetArmoredCar();
          }
          if(Objects.equals(labelTypeChecked.getText(), "Танк"))
          {
              SetTank();
          }
          labelTypeChecked.setText("");
        };

        PropertyChangeListener mainColorListener = propertyChangeEvent -> {
            if (vehicle != null)
            {
                vehicle.SetMainColor(labelMainColor.getBackground());
                panelShowVehicle.setVehicle(vehicle);
                repaint();
            }
        };

        PropertyChangeListener dopColorListener = propertyChangeEvent -> {
            if (vehicle != null && (checkBoxWeapon.isSelected() || checkBoxTower.isSelected()))
            {
                Tank tank = (Tank)vehicle;
                tank.SetDopColor(labelDopColor.getBackground());
                vehicle = tank;
                panelShowVehicle.setVehicle(vehicle);
                repaint();
            }
        };

        labelTypeChecked.addPropertyChangeListener("text", carTypeListener);
        labelMainColor.addPropertyChangeListener("background", mainColorListener);
        labelDopColor.addPropertyChangeListener("background", dopColorListener);
        labelWeaponTypeChecked.addPropertyChangeListener("text", weaponTypeListener);

        btnCancel.addActionListener(actionEvent -> dispose());
        btnAdd.addActionListener((ActionEvent e) -> {
                if(vehicle!=null)
                {
                    frameBase.addVehicle(vehicle);
                }
                dispose();
        });
    }

    public void paint(Graphics g)
    {
        super.paint(g);
    }

    private void SetArmoredCar()
    {
        vehicle = new ArmoredCar((Integer)spinnerMaxSpeed.getValue(), (Integer)spinnerWeight.getValue(), Color.BLACK);
        panelShowVehicle.setVehicle(vehicle);
        repaint();
    }

    private void SetTank()
    {
        Random rnd = new Random();
        int weaponAmount = 0;
        if(checkBoxWeapon.isSelected())
        {
            weaponAmount = rnd.nextInt(3) + 1;
        }
        vehicle = new Tank((Integer)spinnerMaxSpeed.getValue(), (Integer)spinnerWeight.getValue(), Color.BLACK, Color.BLACK, checkBoxTower.isSelected(), new Weapon(weaponAmount));
        panelShowVehicle.setVehicle(vehicle);
        repaint();
    }
}
