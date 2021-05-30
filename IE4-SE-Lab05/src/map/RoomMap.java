package map;

import model.Coordinates;

public class RoomMap extends MapDecorator {
    public RoomMap(Map map) {
        super.map = map;
    }

    @Override
    public void setCoord(Coordinates coord) {
        map.setCoord(coord);
    }
}
