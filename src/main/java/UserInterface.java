import java.util.Scanner;

public class UserInterface {
    String itemUserInput;

    Adventure adventure = new Adventure();


    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }


    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        //String userInput = "";
        String itemUserInput;
        boolean gameRunning = true;

        /*do {
            userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "eat":
                    System.out.println("What do you want to eat?");
                    String itemToEat = scanner.nextLine().toLowerCase();
                    boolean ate = adventure.isFood(itemToEat);
                    if (ate) {
                        System.out.println("You ate " + itemToEat + ". Yum!");
                    } else {
                        System.out.println("You can't eat that.");
                    }
                    break;


            }

        } while (gameRunning); */

            System.out.println("Welcome to the game called Adventure");
            System.out.println("You start in " + adventure.getCurrentRoom().getName());
            System.out.println("Type,'east' to move right \n" +
                    "Type 'west' to move left \n" +
                    "Type 'north' to move up \n" +
                    "Type 'south' to move down \n" +
                    "Type 'exit' to exit \n" +
                    "Type 'look' to look around \n" +
                    "Type 'help' to get help \n");

        boolean game = true;
        while (game) {
            String userInput = scanner.nextLine().toLowerCase(); // forandring: fra 'userInput' til 'itemToDrop'
            if (userInput.equals("drop")) {
                System.out.println("What do you want to drop?");
                userInput = scanner.nextLine().toLowerCase();
                boolean result = adventure.drop(userInput);
                if (result == true) {
                    System.out.println("You dropped the item called " + userInput);
                } else {
                    System.out.println("The item was not dropped");
                }

            }

            if (userInput.equals("inventory")){
                adventure.getInventory();
            }
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
                        "Type 'help' to get help \n" +
                        "Type 'take' to take item \n" +
                        "Type 'drop' to drop item \n" +
                        "Type 'inventory' to see inventory \n");



            } else if (userInput.equals("take")) {
                System.out.println("What do you want to take?");
                userInput = scanner.nextLine().toLowerCase();
                boolean result = adventure.take(userInput);
                if (result == true) {
                    System.out.println("You took the item called " + userInput);
                } else {
                    System.out.println("The item was not found");
                }
            }
            else if (userInput.equals("eat")){
                System.out.println("What do you want to eat?");
                String itemToEat = scanner.nextLine().toLowerCase();
                boolean ate = adventure.isFood(itemToEat);
                if (ate) {
                    System.out.println("You ate " + itemToEat + ". Yum!");
                } else {
                    System.out.println("You can't eat that.");
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


