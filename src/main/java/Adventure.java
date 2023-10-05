public class Adventure {
    private Map map = new Map();
    private Player player;

    public Adventure() {

        player = new Player(map.getCurrentRoom());
    }

    public void play() {
    }


    public Room getCurrentRoom() {
        return map.getCurrentRoom();
    }

    public String look() {
        return map.look();
    }

    public boolean take(String userInput) {
        return player.takeItem(userInput);

    }

    public String showItems(){
        return player.showItems();
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

}
