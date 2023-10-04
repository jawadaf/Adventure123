import java.util.ArrayList;

public class Player {

    private Room room;
    private Map map;
    private ArrayList<Item> inventory;

    public Room getCurrentRoom(){
        return room;
    }

    public Player(Room room){

        this.room = room;
        this.inventory = new ArrayList<>();
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public void move(String input) {

        if (input.toLowerCase().equals("e")){
            goEast();
        } if (input.toLowerCase().equals("w")){
            goWest();
        }if (input.toLowerCase().equals("n")){
            goNorth();
        }if (input.toLowerCase().equals("s")){
            goSouth();
        }

    }

    public void goEast(){
        if (room.getEast() != null) {
            Room eastRoom = room.getEast();
            System.out.println("You go east");
            room = eastRoom;
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goWest(){
        if (room.getWest() != null) {
            Room westRoom = room.getWest();
            System.out.println("You go west");
            room = westRoom;
        } else {
            System.out.println("You can't go there");
        }
    }
    public void goNorth(){
        if (map.getCurrentRoom().getNorth() != null) {
            map.setCurrentRoom(getCurrentRoom().getNorth());
            System.out.println("You go north");
        } else {
            System.out.println("You can't go there");
        }

    }
    public void goSouth(){
        if (room.getSouth() != null) {
            Room southRoom = room.getSouth();
            room = southRoom;
            System.out.println("You go south");
        } else {
            System.out.println("You can't go there");
        }
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
//                room.getItems()..RemoveItem();
                itemFound = true;
                break;
            }
        }
        return itemFound;
    }
}

