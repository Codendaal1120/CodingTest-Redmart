package core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RouteFinderTest {

	private int[][] exampleInput = { { 4, 8, 7, 3 }, { 2, 5, 9, 3 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 } } ;
	private int exampleHeight = 4;
	private int exampleWidth = 4;
	private RouteFinder routeFinder;

	@Before
	public void Setup() {	
		routeFinder = new RouteFinder(exampleInput, exampleHeight, exampleWidth);
	}
	
	@Test 
	public void testgetBestSkiRouteGivenExampleInput() {		
		assertEquals("95321", routeFinder.getBestSkiRoute() );
	}

	@Test 
	public void testgetBestSkiRouteWithCoordinatesGivenExampleInput() {		
		assertEquals("[2-1|9]-->[1-1|5]-->[1-2|3]-->[2-2|2]-->[2-3|1]", routeFinder.getBestSkiRouteWithCoordinates() );
	}

	

}
