package map;

import model.Coordinates;

import java.util.ArrayList;

/**
 * The map implementing the Map interface.
 * Holds the actual coordinates specifying which areas to clean.
 * The coordinate data is set to default when the map is created and
 * additional functionality is added to CleanMap objects with the decorators,
 * the moment the user chooses a specific cleaning mode and
 * designates which area to clean with the App’s user interface.
 */
public class CleanMap implements Map {
    ArrayList<Coordinates> coordinates;

    public CleanMap() {
        coordinates = new ArrayList<>();
    }

    /**
     * Returns the Map object of this Map.
     */
    @Override
    public Map getMap() { return this; }

    /**
     * Returns the coordinates in this Map.
     */
    @Override
    public ArrayList<Coordinates> getCoord() {
        return coordinates;
    }

    /**
     * Add a new Coordinates object to the coordinates in this Map.
     */
    @Override
    public void setCoord(Coordinates coord) { coordinates.add(coord); }
}
