# Maze-Generator

JAVA program that generates a random maze based on the number of rows and columns entered 
by the user.

  The crux of the design was to understand the use of Disjoint Set Data Structure to generate a 
random maze that has walls everywhere (except the start and end) and the algorithm continually 
chooses a wall randomly and knock it down if the cells that the wall separates are not already 
connected to each other and this process is repeated until the start and end cells are connected.
