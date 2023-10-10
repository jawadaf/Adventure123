import java.util.ArrayList;

public class Player {


    private Room currentRoom;

    private int health;

    private ArrayList<Item> inventory;

    public Player(Room room) {
        this.health = 100;
        this.currentRoom = room;
        this.inventory = new ArrayList<>();
    }


    public String look() {
        return currentRoom.getName() + " " + currentRoom.getDescription() + " " + currentRoom.getItems();
    }

    public void getInventory() {
        if (inventory != null) {
            System.out.println(inventory);
        }
    }
  /*  public boolean dropItem(String itemName) {
        boolean itemDropped = false;

        // Iterate through the inventory to find the item
        for (Item item : inventory) {
            if (item.getItemName().equals(itemName.toLowerCase())) {
                inventory.remove(item);  // Remove the item from the inventory
                currentRoom.getItems().add(item);  // Add the item to the room's list of items
                itemDropped = true;
                break;
            }
        }
        return itemDropped;  */

    public boolean dropItem(String name) {
        Item dropped = currentRoom.removeItem();
        if (dropped == null) {
            inventory.remove(dropped);
            currentRoom.removeItem(dropped);
            return true;
        } else {
            return false;
        }
    }


    public boolean takeItem(String name) {
        Item found = currentRoom.findItem(name);
        if (found != null) {
            inventory.add(found);
            currentRoom.removeItem(found);
            return true;
        } else {
            return false;
        }
    }

    public String showItems() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Item item : currentRoom.getItems()) {
            stringBuilder.append(item.getItemName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void goEast() {
        if (currentRoom.getEast() != null) {
            Room eastRoom = currentRoom.getEast();
            System.out.println("You go east");
            currentRoom = eastRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goWest() {
        if (currentRoom.getWest() != null) {
            Room westRoom = currentRoom.getWest();
            System.out.println("You go west");
            currentRoom = westRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goNorth() {
        if (currentRoom.getNorth() != null) {
            Room northRoom = currentRoom.getNorth();
            System.out.println("You go north");
            currentRoom = northRoom;
        } else {
            System.out.println("You can't go there");
        }

    }

    public void goSouth() {
        if (currentRoom.getSouth() != null) {
            Room southRoom = currentRoom.getSouth();
            System.out.println("You go south");
            currentRoom = southRoom;
        } else {
            System.out.println("You can't go there");
        }

    }

    public boolean isFood(String name) {
        for (Item i : inventory) {
            if (i instanceof Food) {
                return true;
            }
        }


        return false;
    }

    public Item searchInventory(String itemName) {
        for (Item i: inventory){
            if (i.getItemName().equalsIgnoreCase(itemName)){
                return i;

            }
        } return null;
    }

    public void setHealth(Item item) {
        if (item instanceof Food) {
            this.health += ((Food)item).getHealthPoints();
        }

    }

    public FoodEnum eatFood(String itemName){
        Item eatItem = searchInventory(itemName);
        if (eatItem instanceof Food){
            setHealth(eatItem);
            inventory.remove(eatItem);
            return FoodEnum.FOOD;

        } else if (eatItem == null) {
            return FoodEnum.NOT_FOUND;
        } else {
            return FoodEnum.NOT_FOOD;
        }
    }

}