public class Item {
    private String itemName;
    private String description;


    public Item(String item, String description) {
        this.itemName = item;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }
    public String toString() {
        return "Item" +
                " name '" + itemName + '\'' +
                ", description -'" +
                description;
    }
}
