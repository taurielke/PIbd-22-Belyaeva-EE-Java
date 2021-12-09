import java.awt.*;
public class Weapon implements IWeapon {

    private WeaponAmount weaponAmount;
    public int amount;

    public Weapon(int amount)
    {
        SetWeaponAmount(amount);
        this.amount = amount;
    }

    public void SetWeaponAmount(int amount)
    {
        weaponAmount = WeaponAmount.getWeaponAmount(amount);
    }
    public int GetWeaponAmount()
    {
        return amount;
    }
    public String GetWeaponTypeName()
    {
        return "Weapon";
    }

    public void DrawWeapons(Graphics g, Color color, int x, int y)
    {
        g.setColor(color);
        switch (weaponAmount) {
            case Zero:
                break;
            case One:
                g.fillRect(x + 80, y + 10, 40, 5);
            case Two:
                g.fillRect(x, y + 10, 40, 5);
            case Three:
                g.fillRect(x + 80, y + 20, 40, 5);
                break;
        }
    }
}
