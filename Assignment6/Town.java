/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Represents a town as a node of a graph
 * Due: 12/13/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
public class Town implements Comparable<Town>{
	
	private String name;

	public Town(String name) {
		this.name= name;
	}

	public Town(Town templateTown) {
		name= templateTown.getName();
	}
	
	/**
	 * Gets the town name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Compares two towns
	 * @param o town
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town o) {
		if (getName().equals(o.getName()))
			return 0;
		return 1;
	}
	
	/**
	 * Returns a string with the town name
	 */
	public String toString() {
		String str="";
		str+=name;
		return str;
	}
	
	/**
	 * Returns the hashcode for the town name
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Checks if two towns are equal
	 * @return true if the town names are equal, false if not
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Town)
			if (getName().equals(((Town) obj).getName()))
				return true;
		return false;
	}

}
