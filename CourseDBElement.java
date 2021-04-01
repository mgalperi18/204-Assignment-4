
public class CourseDBElement implements Comparable{

	private String courseID;
	private int courseCRN;
	private int numCredits;
	private String roomNum;
	private String profName;
	
	/**
	 * 
	 */
	public CourseDBElement() {
		
	}
	/**
	 * 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param room
	 * @param name
	 */
	public CourseDBElement(String id, int crn, int credits, String room, String name) {
		courseID = id;
		courseCRN = crn;
		numCredits = credits;
		roomNum = room;
		profName = name;
	}
	
	//getters
	public String getCourseID() {
		return courseID;
	}	
	public int getCourseCRN() {
		return courseCRN;
	}	
	public int getNumCredits() {
		return numCredits;
	}	
	public String getRoomNum() {
		return roomNum;
	}	
	public String getProfName() {
		return profName;
	}
	
	//setters
	public void setCourseID(String id) {
		courseID = id;
	}
	public void setCourseCRN(int crn) {
		courseCRN = crn;
	}
	public void setNumCredits(int credits) {
		numCredits = credits;
	}
	public void setRoomNum(String room) {
		roomNum = room;
	}
	public void setProfName(String name) {
		profName = name;
	}
	
	/**
	 * 
	 */
	public int hashCode() {
		return ("" + courseCRN).hashCode();
	}
	
	/**
	 * 
	 */
	public String toString() {
		String s = "Course:" + courseID + " CRN:" + courseCRN
				+ " Credits:" + numCredits + " Instructor:" + profName
				+ " Room:" + roomNum;
		
		return s;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
