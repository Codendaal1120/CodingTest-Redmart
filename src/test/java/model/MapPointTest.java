package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MapPointTest{

	@Test
	public void testCanSetAndGetCoordinates(){
		MapPoint testPoint = new MapPoint(1, 2, 0);
		assertEquals(1, testPoint.getXCoordinate());
		assertEquals(2, testPoint.getYCoordinate());
	}

	@Test
	public void testCanSetAndGetElevation(){
		MapPoint testPoint = new MapPoint(0, 0, 1);
		assertEquals(1, testPoint.getElevation());
	}

	@Test
	public void testCanGetRouteString(){
		MapPoint testPoint = new MapPoint(1, 2, 3);
		assertEquals("3", testPoint.getRouteString());
	}

	@Test
	public void testCanGetRouteStringWithCoordinates(){
		MapPoint testPoint = new MapPoint(1, 2, 3);
		assertEquals("[1-2|3]", testPoint.getRouteStringWithCoordinates());
	}

	@Test
	public void testCanGetKey(){
		MapPoint testPoint = new MapPoint(5, 2, 3);
		assertEquals("5-2", testPoint.getKey());
	}

	@Test
	public void testCanGetRouteCollection(){
		MapPoint testPoint = new MapPoint(5, 2, 3);
		assertEquals(1, testPoint.getRouteCollection().size());
	}

	@Test
	public void testSelfIsAddedToRoute(){
		MapPoint testPoint = new MapPoint(1, 2, 3);
		assertEquals(testPoint.toString(), testPoint.getRouteStringWithCoordinates());
	}

}