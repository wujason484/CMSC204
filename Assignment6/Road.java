/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Represents a road as a node of a graph
 * Due: 12/13/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
public class Road implements Comparable<Road>{

	private Town source;
	private Town destination;
	private int degrees;
	private String name;

	public Road(Town source, Town destination, int degrees, String name) {
		this.source= source;
		this.destination= destination;
		this.degrees= degrees;
		this.name= name;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source= source;
		this.destination= destination;
		this.name= name;
		degrees= 1;
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		if (source.getName().equals(town.getName()))
			return true;
		return false;
	}
	
	/**
	 * To string method
	 * @return to string
	 */
	public String toString() {
		return getName()+ " "+ getDestination()+ " "+ getSource()+" "+ getWeight();
	}
	
	/**
	 * Gets the name of the road
	 * @return road name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the destination town
	 * @return destination town
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * compare to method
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road o) {
		if (o.getSource().equals(source) && o.getDestination().equals(destination))
			return 0;
		return 1;
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return degrees;
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road
	 * @param r road object to compare it to
	 */
	public boolean equals(Object r) {
		if (r instanceof Road) {
			if (((Road) r).getSource().equals(source) && ((Road) r).getDestination().equals(destination))
				return true;
		}
		return false;
	}

}
