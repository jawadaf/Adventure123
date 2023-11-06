import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    Adventure adventure;

    public String getScanString() {
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
        command();
    }

    public void command() {
        try {
            boolean game = true;
            while (game) {
                String input = getScanString();
                String[] userInputs = input.split(" ");
                String command = userInputs[0];
                String userChoice = "";
                if (userInputs.length > 1) {
                    userChoice = userInputs[1];
                }
                switch (command) {
                    case "drop", "d" -> {
                        System.out.println("What do you want to drop?");
                        boolean result = adventure.drop(userChoice);
                        if (result) {
                            System.out.println("You dropped the item called " + userChoice);
                        } else {
                            System.out.println("The item was not dropped");
                        }
                    }
                    case "inventory", "i" -> adventure.getInventory();

                    case "look", "l" -> {
                        System.out.println("You are in " + adventure.look());
                        System.out.println(adventure.showItems());
                    }
                    case "go" -> {
                        char direction = userChoice.charAt(0);
                        boolean successGo = adventure.move(direction);
                        if (successGo) {
                            System.out.println("You took this way " + userChoice);
                        } else
                            System.out.println("You can't take this way.");
                    }
                    case "help", "h" -> System.out.println("Try to move another direction \n" +
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
                    case "take", "t" -> {
                        System.out.println("What do you want to take?");
                        userChoice = scanner.nextLine().toLowerCase();
                        boolean result = adventure.take(userChoice);
                        if (result == true) {
                            System.out.println("You took the item called " + userChoice);
                        } else {
                            System.out.println("The item was not found");
                        }
                    }
                    case "eat", "e" -> {
                        System.out.println("What do you want to eat?");
                        //String itemToEat = scanner.nextLine().toLowerCase();
                        FoodEnum eat = adventure.eatFood(userChoice);
                        if (userChoice.equals("eat")) {
                            System.out.println("You ate " + userChoice + ". Yum!");
                        } else {
                            System.out.println("You can't eat that.");
                        }
                    }
                    case "exit", "ex" -> {
                        System.out.println("Thank you for playing, close the tab");
                        game = false;
                    }
                    default -> System.out.println("Invalid commando");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}