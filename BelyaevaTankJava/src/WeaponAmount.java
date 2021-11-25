public enum WeaponAmount {
    Zero,
    One,
    Two,
    Three;

    public static WeaponAmount getWeaponAmount(int amount)
    {
        switch(amount){
            case 0:
                return WeaponAmount.Zero;
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
