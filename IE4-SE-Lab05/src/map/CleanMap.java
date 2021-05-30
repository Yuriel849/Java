package map;

import model.Coordinates;

import java.util.ArrayList;

public class CleanMap implements Map {
    ArrayList<Coordinates> coordinates;

    @Override
    public Map getMap() { return this; }

    @Override
    public ArrayList<Coordinates> getCoord() {
        return coordinates;
    }
}
