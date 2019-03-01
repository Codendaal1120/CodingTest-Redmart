package core;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class SkiingInSingaporeTest {

	private SkiingInSingapore skiingInSingapore;
	private String exampleInput =  "4 4 4 8 7 3 2 5 9 3 6 3 2 5 4 4 1 6";
	private String customExampleInput = "4 6 4 8 7 3 2 5 9 3 6 3 2 5 4 4 1 6 6 3 2 5 4 4 1 6";
	private String fileURL = "http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt";

	@Before
	public void SetUp(){
		skiingInSingapore = new SkiingInSingapore();
	}
	
	@Test
	public void testReadAndConvertInputText() {
		assertEquals(18, skiingInSingapore.getStringArrayFromString(exampleInput).length);
	}

	@Test
	public void testReadAndConvertFileUrl() {
		try {
			assertEquals(1000002, skiingInSingapore.getStringArrayFromURL(fileURL).length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMapSizeFromInputArray(){
		assertArrayEquals(new int[]{ 4, 4 }, skiingInSingapore.getMapSizeFromArray( skiingInSingapore.getStringArrayFromString(exampleInput) ));
	}

	@Test
	public void testGetMapGridFromInputArrayWithGivenSample(){
		int[][] expectedGrid = { { 4, 8, 7, 3 }, { 2, 5, 9, 3 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 } } ;
		assertMapGridFromInputArray( expectedGrid, new int[]{ 4, 4 }, skiingInSingapore.getStringArrayFromString(exampleInput));
	}

	@Test
	public void testGetMapGridFromInputArrayWithCustomSample(){
		int[][] expectedGrid = { { 4, 8, 7, 3 }, { 2, 5, 9, 3 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 }, { 6, 3, 2, 5 }, { 4, 4, 1, 6 } } ;
		assertMapGridFromInputArray( expectedGrid, new int[]{ 4, 6 }, skiingInSingapore.getStringArrayFromString(customExampleInput));
	}

	@Test
	public void testRunAppWithBigFile(){
		//End to end test, since we do not know the correct answer, we will just test that we are getting an output
		assertTrue(skiingInSingapore.getSkiRouteFromUrl(fileURL).length() > 1);

		/*
		*** pre-refactor (7918915 calls) timing:
		*	1. 2051ms
		*	2. 2193ms
		*	3. 2098ms
		*	4. 2138ms
		*	5. 20678ms
		
		*** v1 refactor (3831125 calls) timings
		*	1. 3309ms
		*	2. 3300ms
		*	3. 3298ms
		*	4. 3152ms
		*	5. 3354ms

		*** v2 refactor (2098223 calls) timings
		*	1. 1717ms
		*	2. 1888ms
		*	3. 1831ms
		*	4. 1729ms
		*	5. 1910ms

		*** v3 refactor (10000 calls) timings
		*	1. 1779ms
		*	2. 1770ms
		*	3. 1766ms
		*	4. 1624ms
		*	5. 1737ms
		*/

	}

	private void assertMapGridFromInputArray(int[][] expected, int[] mapSize, String[] input){
		assertArrayEquals(expected, skiingInSingapore.getMapGridFromArray(input, mapSize));
	}

}
