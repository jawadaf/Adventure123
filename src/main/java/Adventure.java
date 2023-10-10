public class Adventure {
    private Map map;
    private Player player;

    private String userInput;

    public Adventure() {
        map = new Map();
        map.builMap();

        player = new Player(map.getCurrentRoom());
    }

    public void play() {
    }


    public Room getCurrentRoom() {
        return map.getCurrentRoom(); 
    }

    public String look() {
        return player.look();
    }

    public void getInventory() {
        player.getInventory();
    }

    public boolean isFood(String name) {
        return player.isFood(name);
    }

   public boolean drop(String userInput) {
        return player.dropItem(userInput);

    }

    public boolean take(String userInput) {
        return player.takeItem(userInput);

    }


    public void goEast() {
        player.goEast();
    }

    public void goWest() {
        player.goWest();
    }

    public void goSouth() {
        player.goSouth();
    }

    public void goNorth() {
        player.goNorth();
    }

    public FoodEnum eatFood(String itemName){
        return player.eatFood(itemName);
    }


}