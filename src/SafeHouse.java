public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player){
        super(player,"Safe House");
    }
    @Override
    public boolean onLocation(){
        System.out.println("You are in the Safe House.");
        System.out.println("Your soul is renewed.");

        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }

}
