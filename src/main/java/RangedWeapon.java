public class  RangedWeapon extends Weapon {
    private double ammo;

    public RangedWeapon(String name, String description, double damage, double ammo){
        super(name, description, damage);
        this.ammo = ammo;
    }
}
