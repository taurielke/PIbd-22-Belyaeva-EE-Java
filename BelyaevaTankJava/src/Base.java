import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class Base <T extends ITransport, U extends IWeapon>{
    private ArrayList<T> _places;
    private int maxCount;
    private int pictureWidth;
    private int pictureHeight;
    private final int _placeSizeWidth = 270;
    private final int _placeSizeHeight = 90;
    private int width;
    private int height;

    public T getVehicle(int i)
    {
        if(i > -1 && i < _places.size())
        {
            return _places.get(i);
        }
        return null;
    }

    public Base(int picWidth, int picHeight)
    {
        width = picWidth / _placeSizeWidth;//2
        height = picHeight / _placeSizeHeight;//5
        _places = new ArrayList<T>();
        maxCount = width*height;
        pictureHeight = picHeight;
        pictureWidth = picWidth;
    }

    public int Plus(T tank)
    {
        if(_places.size() < maxCount)
        {
            _places.add(tank);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public T Minus(int index)
    {
        if ((index < _places.size())&&(index > -1))
        {
            T obj = _places.get(index);
            _places.remove(index);
            return obj;
        }
        else
        {
            return null;
        }
    }

    public boolean MoreOrEquals(Base<ITransport, IWeapon> base1, Base<ITransport, IWeapon> base2)
    {
        return (base1._places.size() >= base2._places.size());
    }

    public boolean LessOrEquals(Base<ITransport, IWeapon> base1, Base<ITransport, IWeapon> base2)
    {
        return (base1._places.size() <= base2._places.size());
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);
        int x = 25, y = 70;
        for(int i = 0; i < _places.size(); ++i)
        {
            if(i % width == 0 && i > 0)
            {
                x = 20;
                y += 90;
            }
            _places.get(i).SetPosition(x, y, pictureWidth, pictureHeight);
            _places.get(i).DrawTransport(g);
            x += 270;
        }
    }

    private void DrawMarking(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                g.drawLine( i * _placeSizeWidth + 10, j * _placeSizeHeight + 65, i * _placeSizeWidth + 145, j * _placeSizeHeight + 65);
            }
            g.drawLine( i * _placeSizeWidth + 10, 65, i * _placeSizeWidth + 10, 515);
        }
    }

    public void clear()
    {
        _places.clear();
    }
}
