import java.io.IOException;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int size;
	public java.util.LinkedList<CourseDBElement>[] hTable;
	private java.util.LinkedList<CourseDBElement> hLink;
	
	/**
	 * constructor
	 * @param hasSize
	 */
	public CourseDBStructure(int hashSize) {
		size = hashSize;
		hTable = new java.util.LinkedList[size];
	}
	
	
	/**
	 * constructor
	 * @param Testing
	 * @param hasSize
	 */
	public CourseDBStructure(String Testing, int hashSize) {
		size = hashSize;
		hTable = new java.util.LinkedList[size];
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public int hashIndex(CourseDBElement element) {
		return element.hashCode() % getTableSize();
	}
	
	@Override
	/**
	 * @param element
	 */
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		hLink = new java.util.LinkedList();
		int index =  hashIndex(element);
		
		if(hTable[index] == null) {
			hLink.add(element);
			hTable[index] = hLink;
		}
		else {
			hLink.add(element);
			hTable[index + 1] = hLink;
		}
	}

	@Override
	/**
	 * @param crn
	 */
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		int index = String.valueOf(crn).hashCode() % getTableSize();
		hLink = hTable[index];
		
		for(int i = 0; i < size; i++) {
			while(hLink.get(i) != null) {
				if(hLink.get(i).getCourseCRN() == crn) {
					return hLink.get(i);
				}
			}
		}
		
		throw new IOException();
		
	}

	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
