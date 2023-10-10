import java.util.ArrayList;

public class Map {

    private Room currentRoom;

    public Map() {

    }

    public void builMap(){
        Room room1 = new Room("Room 1", "The entry point, the room is cold and empty ");
        Room room2 = new Room("Room 2", "This room is filled with cats and a lantern");
        Room room3 = new Room("Room 3", "There is a waterfall and jungle in this room");
        Room room4 = new Room("Room 4", "In here there is a big lion in a cage");
        Room room5 = new Room("Room 5", "You are now entered in the room filled with delicious food");
        Room room6 = new Room("Room 6", "There is a key in this room, and there is also a book");
        Room room7 = new Room("Room 7", "Here is the movie theater");
        Room room8 = new Room("Room 8", "This is the sauna place");
        Room room9 = new Room("Room 9", "This is a bedroom, but there is only a small bed");



        room1.addItem (new Item ("waterbottle", "a ice cold waterbottle"));
        room2.addItem (new Item ("sword", "a long sharp weapon"));
        room3.addItem (new Item ("scooter", "fast and cool scooter"));
        room4.addItem (new Item ("key", "a useful key"));
        room5.addItem (new Item ("napkin", "clean and neat "));
        room6.addItem (new Item ("book", "a usefull tool"));
        room7.addItem (new Item ("remote", "a long item with button on "));
        room8.addItem (new Item ("towel", "to dry yourself with"));
        room9.addItem (new Item ("pillow", "to sleep with"));

        room1.removeItem (new Item ("waterbottle", "a ice cold waterbottle"));
        room2.removeItem (new Item ("sword", "a long sharp weapon"));
        room3.removeItem (new Item ("scooter", "fast and cool scooter"));
        room4.removeItem (new Item ("key", "a useful key"));
        room5.removeItem (new Item ("napkin", "clean and neat "));
        room6.removeItem (new Item ("book", "a usefull tool"));
        room7.removeItem (new Item ("remote", "a long item with button on "));
        room8.removeItem (new Item ("towel", "to dry yourself with"));
        room9.removeItem (new Item ("pillow", "to sleep with"));

















        room1.addItem(new Food("potion", "Health potion", 60));
        room3.addItem(new Food("Lollypop", "Health lollypop", 70));
        room5.addItem(new Food("Burger", "Health burger", 80));
        room7.addItem(new Food("Apple", "Health apple", 90));
        room9.addItem(new Food("Banana", "Health banana", 100));

        room2.addItem(new RangedWeapon("bazooka","big weapon", 50, 3));
        room4.addItem(new RangedWeapon("rpg", "big gun", 40, 5));
        room6.addItem(new MeleeWeapon("sabel", "arab equipment", 30, 10000));
        room8.addItem(new MeleeWeapon("hammer", "handy equipment", 10, 10000));



        currentRoom = room1;
        room1.setWest(null);
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setNorth(null);

        room2.setSouth(null);
        room2.setWest(room1);
        room2.setEast(room3);
        room2.setNorth(null);

        room3.setNorth(null);
        room3.setSouth(room6);
        room3.setWest(room2);
        room3.setEast(null);

        room4.setWest(null);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setEast(null);

        room5.setNorth(null);
        room5.setSouth(room8);
        room5.setEast(null);
        room5.setWest(null);

        room6.setWest(null);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setEast(null);

        room7.setSouth(null);
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);

        room8.setSouth(null);
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setEast(null);
        room9.setWest(room8);
        room9.setNorth(room6);
        room9.setSouth(null);
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }


}
