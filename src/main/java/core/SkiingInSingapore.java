package core;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class SkiingInSingapore {

	/***** Functions *****/

	public String getSkiRouteFromString(String input){		
		try{			
			return getSkiRouteResult( getStringArrayFromString(input) );
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	public String getSkiRouteFromUrl(String fileUrl){		
		try{			
			return getSkiRouteResult( getStringArrayFromURL(fileUrl) );
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	public String[] getStringArrayFromString(String input){
		return input.split(" ");
	}

	public String[] getStringArrayFromURL(String fileUrl) throws IOException {
		URL url = new URL(fileUrl);
		Scanner scanner = new Scanner(url.openStream());
		String fileContent = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return fileContent.split("[\\n\\s]");
	}	

	public int[] getMapSizeFromArray(String[] inputArray){
		return convertStringArrayToIntArray( Arrays.copyOfRange(inputArray, 0, 2) );
	}

	public int[][] getMapGridFromArray(String[] inputArray, int[] mapSize){
		int[] convertedArray = convertStringArrayToIntArray( Arrays.copyOfRange( inputArray, 2, inputArray.length ) );
		int[][] returnArray = new int[ mapSize[1] ][ mapSize[0] ];
		int counter = 0;
		for (int i = 0; i < mapSize[1]; i++){
			for (int j = 0; j < mapSize[0]; j++){	
				returnArray[i][j] = convertedArray[counter];
				counter++;
			}			
		}
		return returnArray; 
	}

	/***** Private functions *****/

	private String getSkiRouteResult(String[] map){
		int[] mapSize = getMapSizeFromArray(map);
		int[][] mapGrid = getMapGridFromArray(map, mapSize);
		RouteFinder routeFinder = new RouteFinder(mapGrid, mapSize[0], mapSize[1]);
		System.out.println("Best route elevations = " + routeFinder.getBestSkiRoute());
		System.out.println("Best route with coordinates = " + routeFinder.getBestSkiRouteWithCoordinates());
		return routeFinder.getBestSkiRoute();
	}

	private int[] convertStringArrayToIntArray(String[] input){
		return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
	}

}
