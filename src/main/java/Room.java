import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private Weapon weapon;

    private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.items = new ArrayList<>();

    }
    public ArrayList<Item> getItems(){
        return items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {

        this.description = description;
    }

    public void addItem(Item item){
        items.add(item);

    }

    public Item removeItem(Item item){
        return item;
    }

    public Item findItem(String itemName){
        for (Item item: items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        } return null;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Room getNorth() {
        return north;
    }
    public void setNorth (Room north){
        this.north = north;
    }

    public Room getEast() {
        return east;
    }
    public void setEast (Room east){
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }
    public void setSouth (Room south){
        this.south = south;
    }

    public Room getWest() {
        return west;
    }
    public void setWest (Room west) {
        this.west = west;
    }


    public Item removeItem() {
        return null;
    }

    @Override
    public String toString() {
        return "Room " + ", " +
                "name " + name + ", " +
                "description " + description;
    }
}



