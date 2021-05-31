package map;

import model.Coordinates;

/**
 * An extension of the MapDecorator which decorates the map for Region Mode.
 * When the user designates which area to clean with the App, this is responsible for
 * adding the coordinate data for this cleaning mode.
 */
public class RegionMap extends MapDecorator {
    public RegionMap(Map map) {
        super.map = map;
    }

    /**
     * Add a new Coordinates object to the coordinates in this Map.
     */
    @Override
    public void setCoord(Coordinates coord) {
        map.setCoord(coord);
    }
}
