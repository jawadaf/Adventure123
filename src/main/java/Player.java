import java.util.ArrayList;

public class Player {

    private Room room;
    private ArrayList<Item> inventory;

    public Player(Room room) {

        this.room = room;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /*public boolean takeItem(String requestedItem) {
        boolean itemFound = false;
        ArrayList<Item> itemsInRoom = room.getItems();
        for (Item item : itemsInRoom) {
            if (item.getItemName().equals(requestedItem.toLowerCase())) {
                int index = itemsInRoom.indexOf(item);
                inventory.add(item);

                itemFound = true;
                break;
            }
        }
        return itemFound;
    }*/

    public boolean takeItem(String name) {
        Item found = room.findItem(name);
        if (found != null) {
            inventory.add(found);
            room.removeItem(found);
            return true;
        } else {
            return false;
        }
    }

    public String showItems() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Item item : room.getItems()) {
            stringBuilder.append(item.getItemName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void goEast() {
        if (room.getEast() != null) {
            Room eastRoom = room.getEast();
            System.out.println("You go east");
            room = eastRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goWest() {
        if (room.getWest() != null) {
            Room westRoom = room.getWest();
            System.out.println("You go west");
            room = westRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goNorth() {
        if (room.getNorth() != null) {
            Room northRoom = room.getNorth();
            System.out.println("You go north");
            room = northRoom;
        } else {
            System.out.println("You can't go there");
        }

    }

    public void goSouth() {
        if (room.getSouth() != null) {
            Room southRoom = room.getSouth();
            System.out.println("You go south");
            room = southRoom;
        } else {
            System.out.println("You can't go there");
        }

    }
}

