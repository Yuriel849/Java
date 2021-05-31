package map;

import model.Coordinates;

import java.util.ArrayList;

/**
 * An interface for the map, which is used to tell the Robot which areas to clean.
 */
public interface Map {
    Map getMap();
    ArrayList<Coordinates> getCoord();
    void setCoord(Coordinates coord);
}
