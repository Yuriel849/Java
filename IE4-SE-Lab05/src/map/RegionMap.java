package map;

import model.Coordinates;

public class RegionMap extends MapDecorator {
    public RegionMap(Map map) {
        super.map = map;
    }

    @Override
    public void setCoord(Coordinates coord) {
        map.setCoord(coord);
    }
}
