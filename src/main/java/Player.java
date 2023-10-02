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

    public boolean takeItem(String itemName){
        Item found = room.findItem(itemName);
        if (found != null) {
                inventory.add(found);
                room.getItems().remove(found);

        }
        return  false;
    }
}

