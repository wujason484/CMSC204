/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: CourseDB element class
 * Due: 11/15/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
public class CourseDBElement implements Comparable<CourseDBElement>{
	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	public CourseDBElement() {
		
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.id=id;
        this.crn=crn;
        this.credits=credits;
        this.roomNum=roomNum;
        this.instructor=instructor;
    }
	
    public void setCourseId(String id) {
        this.id=id;
    }
    
    public String getID() {
        return id;
    }
    
    public void setCRN(int crn) {
    	this.crn=crn;
    }
    
    public int getCRN() {
        return crn;
    }

    public void setNumberOfCredits(int credits) {
        this.credits=credits;
    }

    public int getNumberOfCredits() {
        return credits;
    }

    public void setRoomNumber(String roomNum) {
        this.roomNum=roomNum;
    }
    
    public String getRoomNum() {
        return roomNum;
    }

    public void setInstructorName(String instructor) {
        this.instructor=instructor;
    }
    
    public String getInstructorName() {
        return instructor;
    }

    @Override
    public int compareTo(CourseDBElement element) {
        if (this.crn>element.crn)
            return 1;
        else if (this.crn<element.crn)
            return -1;
        else
            return 0;
    }

    @Override
    public int hashCode() {
        String crnString=Integer.toString(crn);
        int hashCode=crnString.hashCode();
        return hashCode;
    }

}
