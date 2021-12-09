import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

public class BaseCollection {

    final HashMap<String, Base<Vehicle, Weapon>> baseStages = new HashMap<String, Base<Vehicle, Weapon>>();

    private int pictureWidth;
    private int pictureHeight;
    private String separator = ":";

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

    public boolean SaveData (File fileName)
    {
        if(fileName.exists())
        {
            fileName.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            bw.write("BaseCollection" + System.lineSeparator());
            for(int i = 0; i< baseStages.size(); i++)
            {
                Base<Vehicle, Weapon> base = baseStages.get(Keys().get(i));
                bw.write("Base" + separator + Keys().get(i) + System.lineSeparator());
                ITransport vehicle = null;
                for(int j = 0; (vehicle = base.getVehicle(j)) != null; j++)
                {
                    if(vehicle != null)
                    {
                        if(vehicle.getClass().getSimpleName().equals("ArmoredCar"))
                        {
                            ArmoredCar armoredCar = (ArmoredCar) vehicle;
                            bw.write("ArmoredCar" + separator);
                            bw.write(armoredCar.getArmoredCarConfig() + System.lineSeparator());
                        }
                        if(vehicle.getClass().getSimpleName().equals("Tank"))
                        {
                            Tank tank = (Tank)vehicle;
                            bw.write("Tank" + separator);
                            bw.write(tank.GetTankConfig() + System.lineSeparator());
                        }
                    }
                }
            }
            return true;
        }
        catch(IOException ex)
        {
            return false;
        }
    }

    public boolean LoadData (File fileName)
    {
        if(!fileName.exists())
        {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            if((line = br.readLine()) != null)
            {
                if(line.contains("BaseCollection"))
                {
                    baseStages.clear();
                }
                else
                {
                    return false;
                }
                Vehicle vehicle = null;
                String key = "";
                while((line = br.readLine()) != null)
                {
                    if(line.contains("Base"))
                    {
                        key = line.split(String.valueOf(separator))[1];
                        baseStages.put(key, new Base <Vehicle, Weapon>(pictureWidth, pictureHeight));
                        continue;
                    }
                    if(line.isEmpty())
                    {
                        continue;
                    }
                    if(Objects.equals(line.split(String.valueOf(separator))[0], "ArmoredCar"))
                    {
                        vehicle = new ArmoredCar(line.split(String.valueOf(separator))[1]);
                    }
                    else if (Objects.equals(line.split(String.valueOf(separator))[0], "Tank"))
                    {
                        vehicle = new Tank(line.split(String.valueOf(separator))[1]);
                    }
                    int res = baseStages.get(key).Plus(vehicle);
                    if(res == -1)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        catch(IOException ex)
        {
            return false;
        }
    }

    public boolean SaveBase (File fileName, String baseName)
    {
        if(!baseStages.containsKey(baseName))
        {
            return false;
        }
        if(fileName.exists())
        {
            fileName.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            Base<Vehicle, Weapon> base = baseStages.get(baseName);
            bw.write("Base" + separator + baseName + System.lineSeparator());
            ITransport vehicle = null;
            for(int j = 0; (vehicle = base.getVehicle(j)) != null; j++)
            {
                if(vehicle != null)
                {
                    if(vehicle.getClass().getSimpleName().equals("ArmoredCar"))
                    {
                        ArmoredCar armoredCar = (ArmoredCar) vehicle;
                        bw.write("ArmoredCar" + separator);
                        bw.write(armoredCar.getArmoredCarConfig() + System.lineSeparator());
                    }
                    if(vehicle.getClass().getSimpleName().equals("Tank"))
                    {
                        Tank tank = (Tank)vehicle;
                        bw.write("Tank" + separator);
                        bw.write(tank.GetTankConfig() + System.lineSeparator());
                    }
                }
            }
            return true;
        }
        catch(IOException ex)
        {
            return false;
        }
    }

    public boolean LoadBase (File fileName)
    {
        if(!fileName.exists())
        {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            if((line = br.readLine()) != null)
            {
                if(!line.contains("Base" + String.valueOf(separator)))
                {
                    return false;
                }
                else
                {
                    Vehicle vehicle = null;
                    String key = "";
                    key = line.split(String.valueOf(separator))[1];
                    if(baseStages.containsKey(key))
                    {
                        baseStages.get(key).clear();
                    }
                    else
                    {
                        baseStages.put(key, new Base<>(pictureWidth,pictureHeight));
                    }
                    while((line = br.readLine()) != null)
                    {
                        if(Objects.equals(line.split(String.valueOf(separator))[0], "ArmoredCar"))
                        {
                            vehicle = new ArmoredCar(line.split(String.valueOf(separator))[1]);
                        }
                        else if (Objects.equals(line.split(String.valueOf(separator))[0], "Tank"))
                        {
                            vehicle = new Tank(line.split(String.valueOf(separator))[1]);
                        }
                        int res = baseStages.get(key).Plus(vehicle);
                        if(res == -1)
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        catch(IOException ex)
        {
            return false;
        }
    }

}
