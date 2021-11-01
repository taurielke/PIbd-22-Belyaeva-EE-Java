public enum WeaponAmount {
    One,
    Two,
    Three;

    public static WeaponAmount getWeaponAmount(int amount)
    {
        switch(amount){
            case 1:
                return WeaponAmount.One;
            case 2:
                return WeaponAmount.Two;
            case 3:
                return WeaponAmount.Three;
        }
        return null;
    }
}
