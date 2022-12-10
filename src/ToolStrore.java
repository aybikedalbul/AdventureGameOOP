public class ToolStrore extends NormalLocation{
    public ToolStrore(Player player){
        super(player, "Tool Store");
    }

    @Override
    boolean onLocation() {
        boolean showMenu = true;
        while (true){
            System.out.println("---- Welcome to Tool Store! -----");
            System.out.println("1- Weaponry");
            System.out.println("2- Armors");
            System.out.println("3- Log Out");
            System .out.print ("Your Choice : ");
            int selectCase = scanner.nextInt();
            while(selectCase < 1 || selectCase > 3){
                System.out.println("You entered an invalid expression, plesase re-enter: ");
                selectCase = scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;

                case 2:
                    printArmor();
                    buyArmor();
                    break;

                case 3:
                    System.out.println("Come again!");
                    showMenu = false;
                    break;
            }
        }
    }
        public void printWeapon(){
            System.out.println("---Weaponry---");

            int i = 1;
            for (Weapon w : Weapon.weapons()){
                System.out.println(i + "- " + w.getName() + " -----> Money : " + w.getPrice() + ", Damage: " + w.getDamage());
                i++;
            }
            System.out.println("0- Log Out");
        }

        public void buyWeapon(){
            System.out.print("Choose a weaponry: ");
            int selectedWeaponID = scanner.nextInt();

            while (selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length){
                System.out.print("You entered an invalid expression, please re-enter: ");
                selectedWeaponID = scanner.nextInt();
            }
            if (selectedWeaponID != 0) {
                Weapon selectedWeapon = Weapon.getWeaponObjByID(selectedWeaponID);

                if (selectedWeapon != null){
                    if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                        System.out.println("You don't have enough money!");
                    }else{ // Buying processes
                        System.out.println("You bought the " + selectedWeapon.getName() + " weapon." );
                        int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                        System.out.println("Your previous weapon was " +  this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Your new weapon is " + this.getPlayer().getInventory().getWeapon().getName());
                    }
                }
            }

        }
        public void printArmor(){
            System.out.println("Armors");
            for (Armor a : Armor.armors()){
                System.out.println(a.getId() + "- " + a.getName() + " -----> Money: " + a.getPrice() +
                        ", Armor: " + a.getBlock());
            }
            System.out.println("0- Log Out");
        }

        public void buyArmor(){
            System.out.print("Select a armor: ");
            int selectedArmorID = scanner.nextInt();

            while(selectedArmorID < 0 || selectedArmorID > Armor.armors().length){
                System.out.println("You entered an invalid expression, please re-enter:");
                selectedArmorID = scanner.nextInt();
            }
            if (selectedArmorID != 0) {
                Armor selectedArmor = Armor.getArmorObjByID(selectedArmorID);
                if (selectedArmor != null){
                    if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                        System.out.println("You don't have enough money!");
                    }
                    else{
                        System.out.println("You bought the " + selectedArmor.getName() + " armor." );
                        int balance = this.getPlayer().getMoney() - selectedArmor .getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Your remaining money: " + this.getPlayer().getMoney());
                        System.out.println("Your previous armor was " +  this.getPlayer().getInventory().getArmor().getName());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Your new armor is " + this.getPlayer().getInventory().getArmor().getName());
                    }
                }
            }
        }


}
