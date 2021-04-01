import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

	int size;
	CourseDBElement elem = new CourseDBElement();
	CourseDBStructure struct = new CourseDBStructure(size);
	
	public CourseDBManager() {
		struct = new CourseDBStructure(50);
	}
	

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		CourseDBElement e = new CourseDBElement(id, crn, credits, roomNum, instructor);
		struct.add(e);
	}

	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		
		elem = null;
		try{
			elem = struct.get(crn);
		}
		catch(IOException e) { }
		
		System.out.println(elem.toString());
		return elem;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner fileRead = new Scanner(input);
		String ID = null;
		int CRN = 0;
		int credits = 0;
		String roomNum = null;
		String profName = null;
	
		while(fileRead.hasNextLine()) {
			if(fileRead.hasNext()) {
				ID = fileRead.next();
			}
			if(fileRead.hasNext()) {
				CRN = Integer.parseInt(fileRead.next());
			}
			if(fileRead.hasNext()) {
				credits = Integer.parseInt(fileRead.next());
			}
			if(fileRead.hasNext()) {
				roomNum = fileRead.next();
			}
			if(fileRead.hasNext()) {
				profName = fileRead.next();
			}
			
			add(ID, CRN, credits, roomNum, profName);
			System.out.println(fileRead.nextLine());
		}
		
		fileRead.close();
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < struct.getTableSize(); i++) {
			if(struct.hTable[i] != null) {
				String c = "\nCourse:" + struct.hTable[i].get(0).getCourseID() +
						" CRN:" + String.valueOf(struct.hTable[i].get(0).getCourseCRN()) +
						" Credits:" + String.valueOf(struct.hTable[i].get(0).getNumCredits()) +
						" Instructor:" + String.valueOf(struct.hTable[i].get(0).getProfName()) +
						" Room:" + String.valueOf(struct.hTable[i].get(0).getRoomNum());
				
				list.add(c);
			}
		}
		
		return list;
	}

}
