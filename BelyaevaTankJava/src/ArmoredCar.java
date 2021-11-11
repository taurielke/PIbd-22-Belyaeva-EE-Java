import java.awt.*;
public class ArmoredCar extends Vehicle {
    protected int tankWidth = 120;
    protected int tankHeight = 60;

    public ArmoredCar(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    protected ArmoredCar(int maxSpeed, float weight, Color mainColor, int tankWidth, int tankHeight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.tankWidth = tankWidth;
        this.tankHeight = tankHeight;
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
        g.setColor(MainColor);
        //upper part whatever this is
        g.fillRect(_startPosX + 5, _startPosY + 25, 100, 10);
        g.fillRect(_startPosX + 30, _startPosY + 10, 50, 30);
        g.setColor(Color.WHITE);
        //additional part for upper parts
        g.fillRect(_startPosX+40, _startPosY+15, 30, 10);
    }
}
