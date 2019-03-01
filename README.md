# CodingTest-Redmart-SkiingInSingapore

My solution to online test question provided by [RedMart](https://redmart.com). More details are shown [here](http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/).

The challenger asks you to find the longest possible route down the a mountain using an elevation map. 

To find the solution we will need to write a DFS algorithm to traverse each point and determine which starting point has the longest downhill route. The code can then further be optimized by implimenting a memoization step to ensure we only traverse each starting point once.

The solution can probably be achived by writing less code and using native types, but *"Code is read more often than it is written"*. Therefore, making it easy to read makes it easier to write.

The large specified file can be read by running the main method.
