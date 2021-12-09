import java.awt.*;
import java.util.Objects;
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

    public IWeapon GetWeaponType()
    {
        return WeaponType;
    }

    public Tank(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean tower, IWeapon weaponType)
    {
        super(maxSpeed, weight, mainColor, 120, 60);
        DopColor = dopColor;
        Tower = tower;
        WeaponType = weaponType;
    }

    public Tank(String info)
    {
        super(info);
        String[] strs = info.split(separator);
        if (strs.length == 7)
        {
            MaxSpeed = Integer.parseInt(strs[0]);
            Weight = Integer.parseInt(strs[1]);
            MainColor = Color.decode(strs[2]);
            DopColor = Color.decode(strs[3]);
            Tower = Boolean.parseBoolean(strs[4]);
            if(Objects.equals(strs[5], "Weapon"))
            {
                WeaponType = new Weapon(Integer.parseInt(strs[6]));
            }
            if(Objects.equals(strs[5], "WeaponDifferentForm1"))
            {
                WeaponType = new WeaponDifferentForm1(Integer.parseInt(strs[6]));
            }
            if(Objects.equals(strs[5], "WeaponDifferentForm2"))
            {
                WeaponType = new WeaponDifferentForm2(Integer.parseInt(strs[6]));
            }
        }
    }

    public String GetTankConfig()
    {
        String weaponTypeString = "";
        weaponTypeString = WeaponType.GetWeaponTypeName();
        return(MaxSpeed + ";" + Weight + ";" + MainColor.getRGB() + ";" + DopColor.getRGB() + ";" + Tower + ";" + weaponTypeString + ";" + WeaponType.GetWeaponAmount());
    }

    public void setWeaponType(IWeapon weaponType)
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

        if(WeaponType != null)
        {
            WeaponType.DrawWeapons(g, DopColor, _startPosX, _startPosY);
        }

    }
}
