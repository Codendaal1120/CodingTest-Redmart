package model;

import java.util.ArrayList;

public class MapPoint implements Comparable {
	
	private int elevation;
	private int xCoordinate;
	private int yCoordinate;
	private ArrayList<MapPoint> routePoints;

	/***** Functions *****/

	public MapPoint(int xCoordinate, int yCoordinate, int elevation){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.elevation = elevation;
		routePoints = new ArrayList<>();
		routePoints.add(this);
	}

	public void addToRoute(ArrayList<MapPoint> point){
		routePoints.addAll(point);
	}

	/***** Get functions *****/

	public int getXCoordinate(){
		return xCoordinate;
	}

	public int getYCoordinate(){
		return yCoordinate;
	}

	public int getElevation(){
		return elevation;
	}

	public int getRouteLenght(){
		return routePoints.size();
	}

	public int getRouteElevationChange(){
		return routePoints.get( 0 ).getElevation() - routePoints.get( routePoints.size() -1 ).getElevation();
	}

	public String getRouteString(){
		String route = "";
		for (int i = 0; i < routePoints.size(); i++){
			route += routePoints.get(i).elevation;
		}
		return route;
	}

	public String getRouteStringWithCoordinates(){
		String route = "";
		for (int i = 0; i < routePoints.size(); i++){
			if (i > 0){
				route += "-->";
			}
			route += routePoints.get(i).toString();
		}
		return route;
	}

	public String getKey(){
		return String.valueOf(getXCoordinate()) + "-" + String.valueOf(getYCoordinate());
	}

	public ArrayList<MapPoint> getRouteCollection(){
		return routePoints;
	}

	/***** Override functions *****/

	@Override
	public String toString(){
		return "[" + getXCoordinate() + "-" + getYCoordinate() + "|" + elevation + "]";
	}

	@Override
	public int compareTo(Object o) {
		MapPoint otherMapPoint = (MapPoint)o;
		if (otherMapPoint != null){
			if (getRouteLenght() > otherMapPoint.getRouteLenght()){
				return 1;
			}
			else if (getRouteLenght() == otherMapPoint.getRouteLenght()){
				if (getRouteElevationChange() > otherMapPoint.getRouteElevationChange()){
					return 1;
				}
				else{
					return -1;
				}
			}
			else{
				return -1;
			}
		}
		else{
			return 1;
		}
	}

	@Override
	public boolean equals(Object obj){
		MapPoint otherPoint = (MapPoint)obj;
		if (otherPoint.getXCoordinate() == getXCoordinate() && otherPoint.getYCoordinate() == getYCoordinate()){
			return true;
		}
		else{
			return false;
		}
	}

}