import java.util.Scanner;

public class UserInterface {

    Adventure adventure = new Adventure();


    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }


    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game called Adventure");
        System.out.println("You start in " + adventure.getCurrentRoom().getName());
        System.out.println("Type,'east' to move right \n" +
                "Type 'west' to move left \n" +
                "Type 'north' to move up \n" +
                "Type 'south' to move down \n" +
                "Type 'exit' to exit \n" +
                "Type 'look' to look around \n" +
                "Type 'help' to get help \n" );

        boolean game = true;
        while (game) {
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("look")) {
                System.out.println("You are in " + adventure.look());

            } else if (userInput.equals("east")) {
                adventure.goEast();

            } else if (userInput.equals("west")) {
                adventure.goWest();


            } else if (userInput.equals("south")) {
                adventure.goSouth();

            } else if (userInput.equals("north")) {
                adventure.goNorth();


            } else if (userInput.equals("help")) {
                System.out.println("Try to move another direction \n" +
                        "Type,'east' to move left \n" +
                        "Type 'west' to move right \n" +
                        "Type 'north' to move up \n" +
                        "Type 'south' to move down \n" +
                        "Type 'exit' to exit \n" +
                        "Type 'look' to look around \n" +
                        "Type 'help' to get help \n");


            } else if(userInput.equals("take")) {
                System.out.println("What do you want to take?");
                userInput = scanner.nextLine().toLowerCase();
                boolean result = adventure.take(userInput);
                if (result == true){
                    System.out.println("You took the item called " + userInput);
                } else {
                    System.out.println("The item was not found");
                }
            }

            else if (userInput.equals("exit")) {
                System.out.println("Thank you for playing, close the tab");
                game = false;
            } else {
                System.out.println("Invalid commando");
            }
        }
        scanner.close();
    }
}

