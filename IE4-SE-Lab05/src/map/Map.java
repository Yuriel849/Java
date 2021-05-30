package map;

import model.Coordinates;

import java.util.ArrayList;

public interface Map {
    Map getMap();
    ArrayList<Coordinates> getCoord();
    void setCoord(Coordinates coord);
}
