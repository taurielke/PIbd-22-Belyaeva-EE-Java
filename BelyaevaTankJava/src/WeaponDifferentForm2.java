import java.awt.*;

public class WeaponDifferentForm2 implements IWeapon {
    private WeaponAmount weaponAmount;

    public WeaponDifferentForm2(int amount)
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
                g.fillRect(x + 80, y + 10, 15, 10);
            case Two:
                g.fillRect(x, y + 20, 15, 10);
            case Three:
                g.fillRect(x + 80, y + 20, 15, 10);
                break;
        }
    }
}
