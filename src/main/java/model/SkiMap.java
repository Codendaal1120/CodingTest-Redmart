package model;

import java.util.HashMap;

public class SkiMap{

	public class Direction{
		public static final int NORTH = 1;
		public static final int SOUTH = 2;
		public static final int WEST = 3;
		public static final int EAST = 4;
	}

	private HashMap<String, MapPoint> mapPoints;
	
	private int[][] mapGrid;
	private int height;
	private int width;
	
	/***** Functions *****/

	public SkiMap(int height, int width){
		this.height = height;
		this.width = width;
		mapPoints = new HashMap<>();
	}

	public boolean isInitialized(){
		if (mapPoints.size() > 1){
			return true;
		}
		else{
			return false;
		}
	}

	/***** Get functions *****/

	public int getElevationFromGrid(int x, int y){
		return mapGrid[y][x];
	}

	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}

	public String getBestRouteString(){
		return mapPoints.get(getBestRouteKey()).getRouteString();
	}

	public String getBestRouteStringWithCoordinates(){
		return mapPoints.get(getBestRouteKey()).getRouteStringWithCoordinates();
	}

	public MapPoint getMapPointFromSavedPoints(String key){
		return mapPoints.get(key);
	}

	public int[][] getMapGrid(){
		return mapGrid;
	}

	/***** Set functions *****/

	public void setMapGrid(int[][] mapGrid){
		this.mapGrid = mapGrid;
	}

	public void saveMapPoint(MapPoint pointToSave){
		this.mapPoints.put(pointToSave.getKey(), pointToSave);
	}

	/***** Private functions *****/

	public String getBestRouteKey(){
		String bestRouteKey = mapPoints.keySet().iterator().next();
		for (String key : mapPoints.keySet()) {
			if (mapPoints.get(bestRouteKey).compareTo(mapPoints.get(key)) == -1){
				bestRouteKey = key;
			}
		}
		return bestRouteKey;
	}

}