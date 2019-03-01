package core;

import model.MapPoint;
import model.SkiMap;

public class RouteFinder {
	
	private SkiMap skiMap;

	/***** Functions *****/

	public RouteFinder(int[][] mapGrid, int height, int width){
		createMap(height, width, mapGrid);
	}

	public String getBestSkiRoute() {
		setUpMap();		
		return skiMap.getBestRouteString();
	}

	public String getBestSkiRouteWithCoordinates(){
		setUpMap();
		return skiMap.getBestRouteStringWithCoordinates();		
	}

	/***** Private functions *****/
	
	private void createMap(int height, int width, int[][] mapGird){
		skiMap = new SkiMap( height, width );
		skiMap.setMapGrid( mapGird ) ;
	}

	private void setUpMap(){
		if (!skiMap.isInitialized()){
			traverseMap();
		}
	}

	private void traverseMap(){
		for (int y = 0; y < skiMap.getHeight(); y++){
			for (int x = 0; x < skiMap.getWidth(); x++){
				getMapPointFromCoordinates(x, y);
			}
		}
	}

	private MapPoint getMapPointFromCoordinates(int x, int y){
		MapPoint mapPoint = skiMap.getMapPointFromSavedPoints(x + "-" + y);
		if (mapPoint != null){
			return mapPoint;
		}
		else{
			mapPoint = new MapPoint(x, y, skiMap.getElevationFromGrid(x, y));
			MapPoint nextPoint = findNextPoint(mapPoint);
			if (nextPoint != null){			
				mapPoint.addToRoute(nextPoint.getRouteCollection());				
			}
			skiMap.saveMapPoint(mapPoint);
			return mapPoint;
		}		
	}

	private MapPoint findNextPoint(MapPoint inPoint){
		MapPoint nextPoint = null;
		if (inPoint.getYCoordinate() > 0){
			nextPoint = comparePoints(nextPoint, getNorthPoint(inPoint));
		}
		if (inPoint.getXCoordinate() > 0){
			nextPoint = comparePoints(nextPoint, getWestPoint(inPoint));
		}
		if (inPoint.getYCoordinate() < skiMap.getHeight() - 1){
			nextPoint = comparePoints(nextPoint, getSouthPoint(inPoint));
		}
		if (inPoint.getXCoordinate() < skiMap.getWidth() - 1){
			nextPoint = comparePoints(nextPoint, getEastPoint(inPoint));			
		}		
		return nextPoint; 
	}

	private MapPoint getPointIfElevationIsLower(int elevation, int x, int y){
		if (skiMap.getElevationFromGrid(x, y) < elevation){
			return getMapPointFromCoordinates(x, y);
		}
		else{
			return null;
		}		
	}

	private MapPoint getNorthPoint(MapPoint inPoint){
		return getPointIfElevationIsLower(inPoint.getElevation(), inPoint.getXCoordinate(), inPoint.getYCoordinate() -1);
	}

	private MapPoint getEastPoint(MapPoint inPoint){
		return getPointIfElevationIsLower(inPoint.getElevation(), inPoint.getXCoordinate() +1, inPoint.getYCoordinate());
	}

	private MapPoint getSouthPoint(MapPoint inPoint){
		return getPointIfElevationIsLower(inPoint.getElevation(), inPoint.getXCoordinate(), inPoint.getYCoordinate() +1);
	}

	private MapPoint getWestPoint(MapPoint inPoint){
		return getPointIfElevationIsLower(inPoint.getElevation(), inPoint.getXCoordinate() -1, inPoint.getYCoordinate());
	}

	private MapPoint comparePoints(MapPoint firstPoint, MapPoint secondPoint){
		if (firstPoint != null){
			if (firstPoint.compareTo(secondPoint) == 1){
				return firstPoint;
			}
			else{
				return secondPoint;
			}
		}
		else if (secondPoint != null){
			return secondPoint;
		}
		else{
			return null;
		}
	}


}