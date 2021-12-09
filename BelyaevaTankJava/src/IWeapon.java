import java.awt.*;
public interface IWeapon {
    void DrawWeapons(Graphics g, Color color, int x, int y);
    void SetWeaponAmount(int amount);
    int GetWeaponAmount();
    String GetWeaponTypeName();
}
