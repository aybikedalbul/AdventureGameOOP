public class Inventory {
   Weapon weapon;
   Armor armor;

   public Inventory(){
       this.weapon = new Weapon("Fist", -1,0,0);
       this.armor = new Armor(-1,"Rag",0,0);

   }
    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}


