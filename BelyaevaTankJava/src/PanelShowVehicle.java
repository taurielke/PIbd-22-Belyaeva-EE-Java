import javax.swing.*;
import java.awt.*;

public class PanelShowVehicle extends JPanel
{
    private Vehicle vehicle;
    public void paintComponent(Graphics g)
    {
        if (vehicle!=null)
        {
            vehicle.DrawTransport(g);
        }
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.vehicle.SetPosition(145,70,270,90);
    }
}
