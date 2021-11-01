import java.awt.*;
public class Weapon {

    private WeaponAmount weaponAmount;

    public Weapon(int amount)
    {
        SetWeaponAmount(amount);
    }

    public void SetWeaponAmount(int amount)
    {
        weaponAmount = WeaponAmount.getWeaponAmount(amount);
    }

    public void Draw(Graphics g, Color color, int x, int y)
    {
        g.setColor(color);
        switch (weaponAmount) {
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
