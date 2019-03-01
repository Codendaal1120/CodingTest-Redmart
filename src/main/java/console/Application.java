package console;

import core.SkiingInSingapore;

public class Application {
	
	public static void main(String[] args) {
		SkiingInSingapore skiingInSingapore = new SkiingInSingapore();
		System.out.println("Running with example input:");
		skiingInSingapore.getSkiRouteFromString("4 4 4 8 7 3 2 5 9 3 6 3 2 5 4 4 1 6");
		System.out.println("Running with map file:");
		skiingInSingapore.getSkiRouteFromUrl("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");
		System.out.println("Done");
	  }
	  
}
 