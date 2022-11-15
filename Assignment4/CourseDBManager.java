/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: CourseDB manager class
 * Due: 11/15/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CourseDBManager implements CourseDBManagerInterface{
	
	private CourseDBStructure structure;
	
    public CourseDBManager() {
        structure=new CourseDBStructure(50);
    }
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element=new CourseDBElement(id,crn,credits,roomNum,instructor);
        structure.add(element);
	}
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	public CourseDBElement get(int crn) {
        try {
        	CourseDBElement element=structure.get(crn);
        	String courseInfo="Course:"+element.getID()+" CRN:"+element.getCRN()+
                    " Credits:"+ element.getNumberOfCredits()+" Room:"+ element.getRoomNum()+
                    " Instructor:"+ element.getInstructorName();
			System.out.println(courseInfo);
        	return structure.get(crn);
		
        } catch (IOException e) {
        	e.getMessage();
		}
        return null;
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	public void readFile(File input) throws FileNotFoundException{
        try {
            Scanner file= new Scanner(input);
            while(file.hasNextLine()){
                Scanner scanner=new Scanner(file.nextLine());
                String id=scanner.next();
                int crn=scanner.nextInt();
                int credits=scanner.nextInt();
                String roomNum=scanner.next();
                String instructor=scanner.nextLine();

                CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
                structure.add(element);
            }
            file.close();
        } 
        catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }
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

}
