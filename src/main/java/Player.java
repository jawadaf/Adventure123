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
       return currentRoom.toString();
    }


    public void getInventory() {
        if (inventory != null) {
            System.out.println(inventory);
        }
    }

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
            stringBuilder.append(item.getItemName() + ", " + item.getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public boolean move(char direction) {
        Room requestRoom = null;
        boolean success = false;
        if(direction == 'e') {
            requestRoom = currentRoom.getEast();
            success = goEast();
        } else if (direction == 'w') {
            requestRoom = currentRoom.getWest();
            success = goWest();
        } else if (direction == 'n') {
            requestRoom = currentRoom.getNorth();
            success = goNorth();
        } else if (direction == 's') {
            requestRoom = currentRoom.getSouth();
            success = goSouth();
        }
        if (success && requestRoom != null) {
            currentRoom = requestRoom;
            return true;
        } else {
            return false;
        }
    }

    public boolean goEast() {
        Room eastRoom = currentRoom.getEast();
        if (eastRoom == null) {
            return false;
        } else {
            currentRoom = eastRoom;
            return true;
        }
    }

    public boolean goWest() {
        Room westRoom = currentRoom.getWest();
        if (westRoom == null) {
            return false;
        } else {
            currentRoom = westRoom;
            return true;
        }
    }

    public boolean goNorth() {
        Room northRoom = currentRoom.getNorth();
        if (northRoom == null) {
           return false;
        } else {
            currentRoom = northRoom;
            return true;
        }

    }

    public boolean goSouth() {
        Room southRoom = currentRoom.getSouth();
        if (southRoom == null) {
            return false;
        } else {
            currentRoom = southRoom;
            return true;
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