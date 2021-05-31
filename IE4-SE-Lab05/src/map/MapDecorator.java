package map;

import model.Coordinates;

import java.util.ArrayList;

/**
 * An abstract class implementing the Map interface, used for the decorator design pattern.
 */
public abstract class MapDecorator implements Map {
    protected Map map; // "protected" to allow access from subclasses.

    /**
     * Returns the Map object of this Map.
     */
    @Override
    public Map getMap() {
        return map;
    }

    /**
     * Returns the coordinates in this Map.
     */
    @Override
    public ArrayList<Coordinates> getCoord() {
        return map.getCoord();
    }
}
