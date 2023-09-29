public class Item {
    private String item;
    private String description;


    public Item(String item, String description) {
        this.item = item;
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }
    public String toString() {
        return "Item" +
                " name '" + item + '\'' +
                ", description -'" + description;
    }
}
