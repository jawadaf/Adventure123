public class Adventure {
    private Map map = new Map();
    private Player player;

    public Adventure() {

        player = new Player(map.getCurrentRoom());
    }

    public void play() {
    }

    public void goEast(){
        if (map.getCurrentRoom().getEast() != null) {
            map.setCurrentRoom(map.getCurrentRoom().getEast());
            System.out.println("You go east");
        } else {
            System.out.println("You can't go there");
        }
    }

    public void goWest(){
        if (map.getCurrentRoom().getWest() != null) {
            map.setCurrentRoom(map.getCurrentRoom().getWest());
            System.out.println("You go west");
        } else {
            System.out.println("You can't go there");
        }
    }
    public void goNorth(){
        if (map.getCurrentRoom().getNorth() != null) {
            map.setCurrentRoom(map.getCurrentRoom().getNorth());
            System.out.println("You go north");
        } else {
            System.out.println("You can't go there");
        }

    }
    public void goSouth(){
        if (map.getCurrentRoom().getSouth() != null) {
            map.setCurrentRoom(map.getCurrentRoom().getSouth());
            System.out.println("You go south");
        } else {
            System.out.println("You can't go there");
        }
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
}
