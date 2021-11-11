import java.awt.*;
public abstract class Vehicle implements ITransport {
    protected int _startPosX;
    protected int _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;

    protected void SetMaxSpeed(int maxSpeed)
    {
        MaxSpeed = maxSpeed;
    }
    public int GetMaxSpeed()
    {
        return MaxSpeed;
    }

    protected void SetWeight(int weight)
    {
        Weight = weight;
    }
    public float GetWeight()
    {
        return Weight;
    }

    protected void SetMainColor(Color mainColor)
    {
        MainColor = mainColor;
    }
    public Color GetMainColor()
    {
        return MainColor;
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public abstract void DrawTransport(Graphics g);
    public abstract void MoveTransport(Direction direction);
}
