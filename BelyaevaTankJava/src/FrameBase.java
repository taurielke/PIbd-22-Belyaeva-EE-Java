import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.LinkedList;
import java.util.Queue;

public class FrameBase extends JFrame {
    private JPanel panelBase;
    private JPanel panelBaseParkVehicles;
    private JButton btnParkArmoredCar;
    private JButton btnParkTank;
    private JButton btnTakeAwayVehicle;
    private JPanel panelTakeAwayVehicle;
    private JLabel labelPlace;
    private JTextField textFieldPlaceNumber;
    private Vehicle vehicle;

    private BaseCollection baseCollection;
    private DefaultListModel<String> defListBases;
    private JList<String> jListBases;
    private JScrollPane scroll;
    private JTextField textFieldNewLevelName;
    private JButton btnAddBase;
    private JButton btnDelBase;
    private JButton btnShowDelVehicle;
    private Queue<Vehicle> queueDeletedVehicles;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            FrameBase frameBase = new FrameBase();
            frameBase.setVisible(true);
        } );
    }

    public FrameBase(){
        super("База");

        queueDeletedVehicles = new LinkedList<Vehicle>();

        setSize(1219, 721);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelBase = new JPanel();
        panelBaseParkVehicles = new JPanel();
        panelBase.setBounds(0, 0, 1219, 721);
        panelBaseParkVehicles.setBounds(5,5,1000,721);
        setContentPane(panelBase);
        panelBase.setLayout(null);

        baseCollection = new BaseCollection(panelBaseParkVehicles.getWidth(), panelBaseParkVehicles.getHeight());

        defListBases = new DefaultListModel<String>();
        jListBases = new JList<String>(defListBases);
        scroll = new JScrollPane(jListBases);
        textFieldNewLevelName = new JTextField();
        btnAddBase = new JButton("Добавить базу");
        btnDelBase = new JButton("Удалить базу");
        btnShowDelVehicle = new JButton("Показать удаленное");

        scroll.setBounds(1017, 103, 164,124);
        jListBases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListBases.addListSelectionListener(new jListSelectedIndexChanged());
        textFieldNewLevelName.setColumns(5);
        textFieldNewLevelName.setBounds(1017, 32, 160, 26);
        btnAddBase.setBounds(1017,64,164,33);
        btnDelBase.setBounds(1017,233,160,37);
        btnShowDelVehicle.setBounds(1017, 645, 160,37);

        panelBase.add(scroll);
        panelBase.add(textFieldNewLevelName);
        panelBase.add(btnAddBase);
        panelBase.add(btnDelBase);
        panelBase.add(btnShowDelVehicle);

        btnParkArmoredCar = new JButton("Припарковать бм");
        btnParkTank = new JButton("Припарковать танк");
        btnTakeAwayVehicle = new JButton("Забрать");
        panelTakeAwayVehicle = new JPanel();
        labelPlace = new JLabel("Место: ");
        textFieldPlaceNumber = new JTextField();
        textFieldPlaceNumber.setColumns(5);
        btnParkArmoredCar.setBounds(1017,367,160,88);
        btnParkTank.setBounds(1017, 461,160,69);
        panelTakeAwayVehicle.setBounds(1017, 546,160,100);
        labelPlace.setBounds(19,69,61,20);
        textFieldPlaceNumber.setBounds(86,63,58,26);
        btnTakeAwayVehicle.setBounds(23,117,121,34);

        panelBase.add(btnParkArmoredCar);
        panelBase.add(btnParkTank);
        panelBase.add(panelTakeAwayVehicle);
        panelBase.add(panelBaseParkVehicles);
        panelTakeAwayVehicle.add(labelPlace);
        panelTakeAwayVehicle.add(textFieldPlaceNumber);
        panelTakeAwayVehicle.add(btnTakeAwayVehicle);
        panelTakeAwayVehicle.setBorder(BorderFactory.createTitledBorder("Забрать машину"));

        btnShowDelVehicle.addActionListener(e -> {
            if(!queueDeletedVehicles.isEmpty())
            {
                FrameTank frameTank = new FrameTank();
                frameTank.SetArmoredCar(queueDeletedVehicles.element());
                queueDeletedVehicles.remove();
                frameTank.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Сначала удалите транспорт","Ошибка",JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAddBase.addActionListener(e -> {
            if(textFieldNewLevelName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Введите название базы", "Ошибка",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                baseCollection.AddBase(textFieldNewLevelName.getText());
                ReloadLevels();
            }
        });

        btnDelBase.addActionListener(e -> {
            if(jListBases.getSelectedValue() != null)
            {
                if(JOptionPane.showConfirmDialog(null, "Удалить базу " + jListBases.getSelectedValue() + "?") == 0)
                {
                    baseCollection.DelBase(jListBases.getSelectedValue());
                    ReloadLevels();
                }
            }
        });

        btnParkArmoredCar.addActionListener(e -> {
            if(jListBases.getSelectedIndex() > -1)
            {
                Color firstColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
                vehicle = new ArmoredCar(100,1000, firstColor);
                if((baseCollection.getBase(jListBases.getSelectedValue()).Plus(vehicle))!=-1)
                {
                    repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "База переполнена");
                }
            }
        });

        btnParkTank.addActionListener(e -> {
            if(jListBases.getSelectedIndex() > -1)
            {
                Color firstColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
                Color secondColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
                vehicle = new Tank(100,1000, firstColor, secondColor, true, 1);
                if((baseCollection.getBase(jListBases.getSelectedValue()).Plus(vehicle))!=-1)
                {
                    repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "База переполнена");
                }
            }
        });

        btnTakeAwayVehicle.addActionListener(e -> {
            if(textFieldPlaceNumber.getText() != "")
            {
                vehicle = baseCollection.getBase(jListBases.getSelectedValue()).Minus(Integer.parseInt(textFieldPlaceNumber.getText()));
                if(vehicle != null)
                {
                    queueDeletedVehicles.add(vehicle);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Вы ввели неверное число!");
                }
                repaint();
            }

        });
    }

    private void ReloadLevels()
    {
        int index = jListBases.getSelectedIndex();
        defListBases.clear();
        for (int i = 0; i < baseCollection.Keys().size(); i++)
        {
            defListBases.addElement(baseCollection.Keys().get(i));
        }
        if (defListBases.size() > 0 && (index == -1 || index >= defListBases.size()))
        {
            jListBases.setSelectedIndex(0);
        }
        else
        {
            if (defListBases.size() > 0 && index > -1 && index < defListBases.size())
            {
                jListBases.setSelectedIndex(index);
            }
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        if(jListBases!=null)
        {
            if (jListBases.getSelectedValue() != null)
            {
                baseCollection.getBase(jListBases.getSelectedValue()).Draw(g);
            }
        }
    }

    public class jListSelectedIndexChanged implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            repaint();
        }
    }
}
