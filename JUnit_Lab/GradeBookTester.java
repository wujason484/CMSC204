import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	GradeBook gbook1=new GradeBook(5);
	GradeBook gbook2=new GradeBook(5);
	
	@BeforeEach
	void setUp() throws Exception {
		gbook1=new GradeBook(5);
		gbook2=new GradeBook(5);
		
		gbook1.addScore(56.2);
		gbook1.addScore(80.8);
		
		gbook2.addScore(76.2);
		gbook2.addScore(90.5);
	}

	@AfterEach
	void tearDown() throws Exception {
		gbook1=null;
		gbook2=null;
	}

	@Test
	void testAddScore() {
		assertTrue("56.2 80.8 ".equals(gbook1.toString()));
		assertTrue("76.2 90.5 ".equals(gbook2.toString()));
		
		assertEquals(2, gbook1.getScoreSize());
		assertEquals(2, gbook2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(137.0, gbook1.sum());
		assertEquals(166.7, gbook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(56.2, gbook1.minimum());
		assertEquals(76.2, gbook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(80.8, gbook1.finalScore(), .001);
		assertEquals(90.5, gbook2.finalScore(), .001);
	}
}
