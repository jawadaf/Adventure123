public class Adventure {
    private Map map = new Map();
    private Player player;

    public Adventure() {
        player = new Player(map.getCurrentRoom());
    }

    public Room getCurrentRoom() {
        return map.getCurrentRoom();
    }

    public String look() {
        return player.getCurrentRoom().getDescription();
        //der stod før map.look();
    }

    public boolean take(String userInput) {
        return player.takeItem(userInput);
    }



    public void move(String direction){
        player.move(direction);
    }
    public void goEast(){
        player.goEast();
    }

    public void goWest(){
        player.goWest();
    }

    public void goSouth(){
        player.goSouth();
    }

    public void goNorth(){
        player.goNorth();
    }
}
