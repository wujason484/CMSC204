/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: town graph class
 * Due: 12/13/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface{
	
	Graph graph;

	public TownGraphManager() {
		graph = new Graph();
	}
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try {
			graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String roadName= graph.getEdge(new Town(town1), new Town(town2)).getName();
		
		return roadName;
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		if(graph.addVertex(new Town(v)))
			return true;
		return false;
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town town= new Town(name);
		
		for (Town towns: graph.vertexSet())
			if (towns.equals(town))
				return towns;
		
		return null;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		if(graph.containsVertex(new Town(v))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		if(graph.containsEdge(new Town(town1), new Town(town2))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads(){
		ArrayList<String> road = new ArrayList<>();

		for (Road roads: graph.edgeSet())
			road.add(roads.getName());
		
		Collections.sort(road);
		return road;
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		int weight = 0;

		for (Road roads: graph.edgeSet())
			if (roads.getName().equals(getRoad(town1, town2)))
				weight = roads.getWeight();
		
		return graph.removeEdge(new Town(town1), new Town(town2), weight, road) != null;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		if(graph.removeVertex(new Town(v))) {
			return true;
		}
		return false;
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns(){
		ArrayList<String> town = new ArrayList<String>();
		
		for (Town towns: graph.vertexSet()) {
			town.add(towns.getName());
		}
		Collections.sort(town);
		return town;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2){
		return graph.shortestPath(new Town(town1), new Town(town2));
	}
	
	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		String[] string;
		String line;

		Scanner scan = new Scanner(selectedFile);

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			string = line.split(",|;");
			graph.addVertex(new Town(string[2]));
			graph.addVertex(new Town(string[3]));
			graph.addEdge(new Town(string[2]), new Town(string[3]), Integer.parseInt(string[1]), string[0]);
		}
		scan.close();
	}

}
