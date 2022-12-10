import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;

    private int maxObstacle;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle){
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation(){

        int obsNumber = this.randomObtacleNumber();

        System.out.println("You are here now: " + this.getName());
        System.out.println("Be careful! There can be " + obsNumber + " " + this.getObstacle().getName() + " here!");
        System.out.println("Fight(a) or flight(b)");
        String selectCase = scanner.nextLine().toUpperCase();

        if (selectCase.equals("A") && combat(obsNumber)){
                System.out.println("You have defeated all the enemies in the " + this.getName());
                return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You died!");
            return false;
        }return true;
    }

    public boolean combat(int obsNumber){
        for (int i = 0; i < obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getHealth());
             playerStats();
             obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("Fight(a) or flight(b)");
                String selectCombat = scanner.nextLine().toUpperCase();
                if (selectCombat.equals("A")){
                    System.out.println("You shot!");
                    this.obstacle.setHealth((this.getObstacle().getHealth() - this.getPlayer().getTotalDamage()));
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("The monster hit you!");
                        int obsatcleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obsatcleDamage < 0){
                            obsatcleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obsatcleDamage );
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You defeated the monster!");
                System.out.println("You earned " + this.getObstacle().getAward() + " coins.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your current money: " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
     return  true;
    }
    public void afterHit(){
        System.out.println("Remaining life: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " remaining life: " + this.getObstacle().getHealth());
        System.out.println();

    }
    public void obstacleStats(int i){
        System.out.println((i+1) + ". " + this.getObstacle().getName() + " Values: ");
        System.out.println("-----------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();

    }
    public void playerStats(){
        System.out.println("Player values: ");
        System.out.println("------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Blocking: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println();
    }

    public int randomObtacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
}
