package map;

import model.Coordinates;

import java.util.ArrayList;

public abstract class MapDecorator implements Map {
    protected Map map;

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public ArrayList<Coordinates> getCoord() {
        return map.getCoord();
    }
}
