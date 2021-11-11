import java.awt.*;
import javax.swing.*;

public class Base <T extends ITransport, U extends IWeapon>{
    private T []_places;
    private int pictureWidth;
    private int pictureHeight;
    //size of a parking lot
    private final int _placeSizeWidth = 270;
    private final int _placeSizeHeight = 90;
    private int width;
    private int height;

    public Base(int picWidth, int picHeight)
    {
        width = picWidth / _placeSizeWidth;//2
        height = picHeight / _placeSizeHeight;//5
        _places = (T[])new ITransport [width * height];
        pictureHeight = picHeight;
        pictureWidth = picWidth;
    }

    public int Plus(T tank)
    {
        int i = 0;
        int j = 0;
        while (i < height)
        {
            j = 0;
            while (j < width)
            {
                if (_places[i*width + j] == null)
                {
                    _places[i*width + j] = tank;
                    tank.SetPosition(25 + j * _placeSizeWidth, 40 + i * _placeSizeHeight, pictureWidth, pictureHeight);
                    return i*width + j;
                }
                j++;
            }
            i++;
        }
        return -1;
    }

    public T Minus(int index)
    {
        if ((index >= width * height)||(_places[index] == null))
        {
            return null;
        }
        if (_places[index] != null)
        {
            T obj = _places[index];
            _places[index] = null;
            return obj;
        }
        else
        {
            return null;
        }
    }

    public boolean MoreOrEquals(Base<ITransport, IWeapon> base1, Base<ITransport, IWeapon> base2)
    {
        return (base1._places.length >= base2._places.length);
    }

    public boolean LessOrEquals(Base<ITransport, IWeapon> base1, Base<ITransport, IWeapon> base2)
    {
        return (base1._places.length <= base2._places.length);
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);
        for (int i = 0; i < _places.length; i++)
        {
            if(_places[i]!=null)
                _places[i].DrawTransport(g);
        }
    }

    private void DrawMarking(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                g.drawLine( i * _placeSizeWidth + 10, j * _placeSizeHeight + 35, i * _placeSizeWidth + 145, j * _placeSizeHeight + 35);
            }
            g.drawLine( i * _placeSizeWidth + 10, 35, i * _placeSizeWidth + 10, 485);
        }
    }
}
