import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String charcName;
    private String name;
    private Inventory inventory;


    Scanner scanner = new Scanner(System.in);

    public void printInfo(){

        System.out.println("Your Weapon: " + this.getInventory().getWeapon().getName() +
                ", Your Damage: " + this.getTotalDamage() +
                ", Your Blocking: " + this.getInventory().getArmor().getBlock() +
                ", Your Armor: " + this.getInventory().getArmor().getName() +
                ", Your Health: " + this.getHealth() +
                ", Your Money: " + this.getMoney());

    }
    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("------Characters-----");
        for (GameChar gameChar : charList){
            System.out.println("ID: " + gameChar.getId() +
                    "\tCharacter: " + gameChar.getName() +
                    "\tDamage: " + gameChar.getDamage() +
                    "\tHealth: " + gameChar.getHealth() +
                    "\tMoney: " + gameChar.getMoney());



        }


        System.out.println("----------");
        System.out.print("Please enter a character: ");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character: " + this.getCharcName() +
                ", Damage: " + this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());
          }
          public void initPlayer(GameChar gameChar){
           this.setDamage(gameChar.getDamage());
           this.setHealth(gameChar.getHealth());
           this.setOrijinalHealth(gameChar.getHealth());
           this.setMoney(gameChar.getMoney());
           this.setCharcName(gameChar.getName());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharcName() {
        return charcName;
    }

    public void setCharcName(String charcName) {
        this.charcName = charcName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
}
