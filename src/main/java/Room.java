import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private String item;
    private String itemDescription;

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

    public void dropItem(Item item){
        items.remove(item);
    }
    public Item findItem(String itemName){
        for (Item item: items) {
            if (item.getItem().equals(itemName)) {
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

    public void setItem(String item) {
        this.item = item;
    }
}



