import java.awt.*;
import java.util.Random;

public class Tank extends ArmoredCar
{
    public Color DopColor;
    public boolean Tower;
    private IWeapon WeaponType;

    public void SetDopColor(Color dopColor)
    {
        DopColor = dopColor;
    }
    public Color GetDopColor()
    {
        return DopColor;
    }

    private void SetTower(boolean tower)
    {
        Tower = tower;
    }
    public boolean GetTower()
    {
        return Tower;
    }

    public Tank(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean tower, IWeapon weaponType)
    {
        super(maxSpeed, weight, mainColor, 120, 60);
        DopColor = dopColor;
        Tower = tower;
        WeaponType = weaponType;
    }

    public  void setWeaponType(IWeapon weaponType)
    {
        WeaponType = weaponType;
    }

    public void DrawTransport(Graphics g)
    {
        g.setColor(MainColor);
        //track
        g.fillRect(_startPosX, _startPosY+35, 110, 30);
        g.fillOval(_startPosX-10, _startPosY+35, 30, 30);
        g.fillOval(_startPosX+90, _startPosY+35, 30, 30);

        g.setColor(Color.WHITE);
        //wheels
        g.fillOval(_startPosX + 2, _startPosY + 40, 15, 15);
        g.fillOval(_startPosX + 27, _startPosY + 45, 10, 10);
        g.fillOval(_startPosX + 49, _startPosY + 45, 10, 10);
        g.fillOval(_startPosX + 71, _startPosY + 45, 10, 10);
        g.fillOval(_startPosX + 93, _startPosY + 40, 15, 15);

        if (Tower)
        {
            g.setColor(DopColor);
            //one more additional part but upper and behind these 2 which are under
            g.fillOval(_startPosX + 31, _startPosY + 5, 45, 30);
        }
        g.setColor(MainColor);
        //upper part whatever this is
        g.fillRect(_startPosX + 5, _startPosY + 25, 100, 10);
        g.fillRect(_startPosX + 30, _startPosY + 10, 50, 30);

        g.setColor(Color.WHITE);
        //additional part for upper parts
        g.fillRect(_startPosX+40, _startPosY+15, 30, 10);

        WeaponType.DrawWeapons(g, DopColor, _startPosX, _startPosY);
    }
}
