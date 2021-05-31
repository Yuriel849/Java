package map;

import model.Coordinates;

import java.util.ArrayList;

/**
 * An extension of the MapDecorator which decorates the map for Room Mode.
 * When the user designates which area to clean with the App, this adds the coordinate data
 * for this cleaning mode.
 */
public class RoomMap extends MapDecorator {
    private String chosenRoom;
    private ArrayList<String> rooms = new ArrayList<>();

    public RoomMap(Map map) {
        super.map = map;
    }

    /**
     * When the user chooses a specific cleaning recommendation,
     * the corresponding coordinates are added to the map.
     * Precondition: The user chooses a valid cleaning recommendation in the GUI.
     * Postcondition: Coordinates for the user's chosen cleaning plan are saved to the map.
     */
    public void setRoom(String room) {
        if(room.equals("kitchen cleanup")) {
            map.setCoord(new Coordinates(1234.5678, 302.5030));
        } else if(room.equals("bedroom cleaning out")) {
            map.setCoord(new Coordinates(1212.4325, 493.22033));
        } else if(room.equals("daily living area cleaning")) {
            map.setCoord(new Coordinates(54.3234234, 9876.341359));
        }
        chosenRoom = room;
    }

    /**
     * Returns an ArrayList of cleaning recommendations for display in the GUI.
     */
    public ArrayList<String> roomRecommend() {
        rooms.add("kitchen cleanup");
        rooms.add("bedroom cleaning out");
        rooms.add("daily living area cleaning");

        return rooms;
    }

    /**
     * Return the user's chosen cleaning recommendation.
     */
    public String getRoom() {
        return chosenRoom;
    }

    /**
     * Add a new Coordinates object to the coordinates in this Map.
     */
    @Override
    public void setCoord(Coordinates coord) {
        map.setCoord(coord);
    }
}
