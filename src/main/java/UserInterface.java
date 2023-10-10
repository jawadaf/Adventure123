import java.util.Scanner;

public class UserInterface {
    String itemUserInput;
    Scanner scanner = new Scanner(System.in);

    Adventure adventure = new Adventure();

    public String getScanString (){
        return scanner.nextLine().toLowerCase();
    }

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }


    public void startGame() {

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
            String input = getScanString();
            String[] userInput = input.split(" ");
            String command = userInput[0];
            String userChoice = "";
            if (userInput.length>1){
                userChoice = userInput[1];
            }

            if (userChoice.equals("drop")) {
                System.out.println("What do you want to drop?");
                boolean result = adventure.drop(userChoice);
                if (result) {
                    System.out.println("You dropped the item called " + userChoice);
                } else {
                    System.out.println("The item was not dropped");
                }

            }

            if (userChoice.equals("inventory")){
                adventure.getInventory();
            }
            if (userChoice.equals("look")) {
                System.out.println("You are in " + adventure.look());

            } else if (userChoice.equals("east")) {
                adventure.goEast();

            } else if (userChoice.equals("west")) {
                adventure.goWest();


            } else if (userChoice.equals("south")) {
                adventure.goSouth();

            } else if (userChoice.equals("north")) {
                adventure.goNorth();


            } else if (userChoice.equals("help")) {
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



            } else if (userChoice.equals("take")) {
                System.out.println("What do you want to take?");
                userChoice = scanner.nextLine().toLowerCase();
                boolean result = adventure.take(userChoice);
                if (result == true) {
                    System.out.println("You took the item called " + userChoice);
                } else {
                    System.out.println("The item was not found");
                }
            }
            else if (userChoice.equals("eat")){
                System.out.println("What do you want to eat?");
                //String itemToEat = scanner.nextLine().toLowerCase();
                FoodEnum eat = adventure.eatFood(userChoice);
                if (userChoice.equals("eat")) {
                    System.out.println("You ate " + userChoice + ". Yum!");
                } else {
                    System.out.println("You can't eat that.");
                }
            }
            else if (userChoice.equals("exit")) {
                System.out.println("Thank you for playing, close the tab");
                game = false;
            } else {
                System.out.println("Invalid commando");
            }

        }
        scanner.close();
    }
    }


