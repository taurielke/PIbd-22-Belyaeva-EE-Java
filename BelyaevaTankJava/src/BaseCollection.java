import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseCollection {

    final HashMap<String, Base<Vehicle, Weapon>> baseStages = new HashMap<String, Base<Vehicle, Weapon>>();

    private int pictureWidth;
    private int pictureHeight;

    public ArrayList<String> Keys(){
        return new ArrayList<>(baseStages.keySet());
    }

    public BaseCollection(int pictureWidth, int pictureHeight)
    {
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    public void AddBase(String baseName)
    {
        if(!baseStages.containsKey(baseName))
        {
            baseStages.put(baseName, new Base<Vehicle, Weapon>(pictureWidth, pictureHeight));
        }
    }

    public void DelBase(String baseName)
    {
        if(baseStages.containsKey(baseName))
        {
            baseStages.remove(baseName);
        }
    }

    public Base<Vehicle, Weapon> getBase(String baseName)
    {
        if(baseStages.containsKey(baseName))
        {
            return baseStages.get(baseName);
        }
        else
        {
            return null;
        }
    }

    public Vehicle getBaseAndVehicle(String baseName, int vehicleInd)
    {
        if(baseStages.containsKey(baseName) && baseStages.get(vehicleInd) != null)
        {
            return baseStages.get(baseName).getVehicle(vehicleInd);
        }
        return null;
    }

}
