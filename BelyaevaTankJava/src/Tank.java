import java.awt.*;

public class Tank
{
    private int _startPosX;
    private int _startPosY;
    private int _pictureWidth;
    private int _pictureHeight;
    private final int tankWidth = 120;
    private final int tankHeight = 60;
    private Weapon weaponAmount;

    public int MaxSpeed;
    public float Weight;
    public Color MainColor;
    public Color DopColor;
    public boolean Tower;

    private void SetMaxSpeed(int maxSpeed)
    {
        MaxSpeed = maxSpeed;
    }
    public int GetMaxSpeed()
    {
        return MaxSpeed;
    }

    private void SetWeight(int weight)
    {
        Weight = weight;
    }
    public float GetWeight()
    {
        return Weight;
    }

    private void SetMainColor(Color mainColor)
    {
        MainColor = mainColor;
    }
    public Color GetMainColor()
    {
        return MainColor;
    }

    private void SetDopColor(Color dopColor)
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

    public void Init(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean tower, int weaponAmount)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        Tower = tower;
        this.weaponAmount = new Weapon(weaponAmount);
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction) {
            case Right:
                if (_startPosX + step < _pictureWidth - tankWidth)
                {
                    _startPosX += step;
                }
                break;

            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;

            case Up:
                if (_startPosY - step*3 > 0)
                {
                    _startPosY -= step;
                }
                break;

            case Down:
                if (_startPosY + step < _pictureHeight - tankHeight)
                {
                    _startPosY += step;
                }
                break;
        }
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

        weaponAmount.Draw(g, Color.GREEN, _startPosX, _startPosY);
    }
}
