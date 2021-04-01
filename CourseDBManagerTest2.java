import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManagerTest2 {
	CourseDBManagerInterface dataManager = new CourseDBManager();

	@BeforeEach
	void setUp() throws Exception {
		dataManager = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		dataManager = null;
	}

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		try {
			dataManager.add("CMSC204",12345,3,"CMSC204","Billy Bob Joe");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}


	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataManager.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	void testShowAll() {
		//fail("Not yet implemented");
		dataManager.add("CMSC204",12346,3,"R700","Joey");
		dataManager.add("CMSC204",12347,3,"R700","Jill");
		dataManager.add("CMSC204",12348,3,"R700","BillyBob");
		ArrayList<String> list = dataManager.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:12346 Credits:3 Instructor:Joey Room:R700");
		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:12347 Credits:3 Instructor:Jill Room:R700");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:12348 Credits:3 Instructor:BillyBob Room:R700");
	}

}
