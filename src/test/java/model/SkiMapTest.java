package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SkiMapTest{

	private int[][] exampleGrid = { { 4, 8, 7, 3 }, { 2, 5, 9, 3 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 } } ;
	private SkiMap skiMap;

	@Before
	public void setUp(){
		skiMap = new SkiMap(4, 4);
		skiMap.setMapGrid(exampleGrid);
	}

	@Test
	public void testCanSetAndGetDimentions(){
		skiMap = new SkiMap(1, 2);
		assertEquals(1, skiMap.getHeight());
		assertEquals(2, skiMap.getWidth());		
	}

	@Test
	public void testGetElevationFromGrid(){	
		assertEquals(4, skiMap.getElevationFromGrid(1, 3));
	}

	@Test
	public void testGetBestRouteString(){
		skiMap.saveMapPoint(new MapPoint(5, 2, 3));
		assertEquals("3", skiMap.getBestRouteString());
	}

	@Test
	public void testGetBestRouteStringWithCoordinates(){
		skiMap.saveMapPoint(new MapPoint(5, 2, 3));
		assertEquals("[5-2|3]", skiMap.getBestRouteStringWithCoordinates());
	}
	
	@Test
	public void testGetMapPointFromSavedPoints(){
		MapPoint testPoint = new MapPoint(5, 2, 3);
		skiMap.saveMapPoint(testPoint);
		assertEquals(testPoint, skiMap.getMapPointFromSavedPoints(testPoint.getKey()));
	}

}