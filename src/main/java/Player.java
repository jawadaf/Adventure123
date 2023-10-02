import java.util.ArrayList;

public class Player {

    private Room room;
    private ArrayList<Item> inventory;

    public Player(Room room){

        this.room = room;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean takeItem(String requestedItem) {
        boolean itemFound = false;
        ArrayList<Item> itemsInRoom = room.getItems();
        for (Item item : itemsInRoom) {
            if (item.getItemName().equals(requestedItem.toLowerCase())) {
                int index = itemsInRoom.indexOf(item);
                inventory.add(item);
           //     room.removeItem(index);
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }
}

