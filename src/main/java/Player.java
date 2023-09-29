import java.util.ArrayList;

public class Player {

    private Room room;
    private ArrayList<Item> inventory;

    public Player(Room room){

        this.room = room;
        this.inventory = new ArrayList<>();
    }
    public boolean takeItem(String itemName){
        for (Item item : room.getItems()){
            if(item.getItem().toLowerCase().equals(itemName)){
                inventory.add(item);
                room.getItems().remove(item);
            }
        }
        return  false;
    }
}

