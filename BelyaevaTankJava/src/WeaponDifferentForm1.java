import java.awt.*;

public class WeaponDifferentForm1 implements IWeapon {
    private WeaponAmount weaponAmount;

    public WeaponDifferentForm1(int amount)
    {
        SetWeaponAmount(amount);
    }

    public void SetWeaponAmount(int amount)
    {
        weaponAmount = WeaponAmount.getWeaponAmount(amount);
    }

    public void DrawWeapons(Graphics g, Color color, int x, int y)
    {
        g.setColor(color);
        switch (weaponAmount) {
            case One:
                g.fillRect(x + 80, y + 10, 5, 5);
            case Two:
                g.fillRect(x, y + 20, 5, 5);
            case Three:
                g.fillRect(x + 80, y + 20, 5, 5);
                break;
        }
    }
}
