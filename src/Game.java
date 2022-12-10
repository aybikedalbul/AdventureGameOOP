import java.util.Scanner;

public class Game {

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please enter a player name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + ", Welcome to this dark island, all who live here are real!");
        player.selectChar();


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("######## Regions ########");
            System.out.println("0- Log out (End the game)");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Strore(You can buy weapons or armor)");
            System.out.println("3- Cave(Award: Food --> Be careful, the zombie may come out!)");
            System.out.println("4- Forest(Award: Wood --> Be careful, the vampire may come out!)");
            System.out.println("5- River(Award: Water --> Be careful, the bear may come out!)");
            System.out.print("Please select the region you want to go to: ");
            int selectLoc = scanner.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;

                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStrore(player);
                    break;

                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("You gave up quickly on this dark and foggy island..");
                break;
            }
        if (!location.onLocation()) {
            System.out.println("GAME OVER!");
            break;
        }
        }
    }
}
