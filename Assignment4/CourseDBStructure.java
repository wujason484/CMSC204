/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: CourseDB structure class
 * Due: 11/15/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.LinkedList;
import java.io.IOException;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	public LinkedList<CourseDBElement>[] hashTable;
	private CourseDBStructure structure;
	private int tSize;
	
    public CourseDBStructure(int numberOfCourses) {
    	tSize= numberOfCourses;
        hashTable= new LinkedList[tSize];
    }

    public CourseDBStructure(String string, int hashTableSize){
    	tSize= hashTableSize;
        hashTable= new LinkedList[hashTableSize];
    }
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element) {
        int index= element.hashCode()%tSize;
        if (hashTable[index]== null){
            hashTable[index]= new LinkedList<CourseDBElement>();
            hashTable[index].add(element);
        }
        else{
            hashTable[index].add(element);
        }
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */

	public CourseDBElement get(int crn) throws IOException{
		String crnString= Integer.toString(crn);
        int index= crnString.hashCode()%tSize;

        for(int count=0; count<hashTable[index].size(); count++){
        	if(hashTable[index].get(count).getCRN()==crn)
        		return hashTable[index].get(count);
        }
        throw new IOException();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	
	public ArrayList<String> showAll(){
		 ArrayList<String> list=new ArrayList<String>();

			for (LinkedList<?> linkedList: structure.hashTable) {
	            if (linkedList!=null) {
	                CourseDBElement[] cdeArray = (CourseDBElement[]) linkedList.toArray(new CourseDBElement[linkedList.size()]);

	                for (CourseDBElement element: cdeArray) {
	                	String courseInfo= "\nCourse:"+element.getID()+ " CRN:"+element.getCRN()+
	                            " Credits:"+ element.getNumberOfCredits()+" Room:"+ element.getRoomNum()+
	                            " Instructor:"+ element.getInstructorName();
	                    list.add(courseInfo);
	                }
	            }
	        }
	        return list;		
	}
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	public int getTableSize() {
		return tSize;
	}

}
