//CS201 Assignment8
//Nicole Fella

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing class to test functionality of the methods in GraphVertexImpl
 * @author nicole
 *
 */
public class GraphVertexImplTest {

	/**
	 * Testing fields. We need a vertex to run tests on to test functionality of GraphVertexImpl methods. 
	 */
	GraphVertex<String> testing = new GraphVertexImpl<String>();
	
	/**
	 * Test the getData() method. This method will be tested again in other tests. 
	 */
	@Test
	public void getDataTest() {
		//use assertEquals to test functionality
		assertEquals("This should return null",
				null, //expected
				testing.getData());
	}
	
	/**
	 * Test the setData() method.
	 * This will also test the getData() method again, to ensure functionality.
	 */
	@Test
	public void setDataTest() {
		//run the setData() method by trying to assign "Hi" as the data of the testing vertex
		testing.setData("Hi");
		//use assertEquals to test functionality
		assertEquals("This should no longer return null, it should return 'Hi'",
				"Hi",
				testing.getData());
	}

	/**
	 * Test the getNeighbors() method. This test is expected to show nothing since neighbors list starts empty.
	 * This method will be tested again in other test cases.
	 */
	@Test
	public void getNeighborsTest() {
		//this for loop will test functionality by iterating through the list and printing out the elements
		for(int i=0; i < testing.getNeighbors().size(); i++)
			System.out.println("element is " + testing.getNeighbors().get(i).getData()); //nothing should print
	}

	/**
	 * Test the addNeighbor() method. This test should show that a new neighbor is added.
	 * It also test the getNeighbors() method
	 */
	@Test
	public void addNeighborTestPrint() {
		//must create a temporary vertex to add to the testing GraphVertex neighbors list
		GraphVertex<String> tempVertex = new GraphVertexImpl<String>();
		testing.addNeighbor(tempVertex);
		
		//this for loop will test functionality by iterating through the list and printing out the elements 
		for(int i=0; i < testing.getNeighbors().size(); i++)
			System.out.println("New element is " + testing.getNeighbors().get(i).getData()); 
		
	}
	
	/**
	 * Test the addNeighbor() method. This test should show that a new neighbor is added.
	 * It also test the getNeighbors() method.
	 * This test uses assertEquals to test functionality
	 */
	@Test
	public void addNeighborTest() {
		//must create a temporary vertex to add to the testing GraphVertex neighbors list
		GraphVertex<String> tempVertex = new GraphVertexImpl<String>();
		testing.addNeighbor(tempVertex);
		
		//can also test functionality by using assert equals
		assertEquals("This test should return null since no data was assigned to new neighbor",
				null, //expected
				testing.getNeighbors().get(0).getData());
	}
	
	/**
	 * Test the addNeighbors() method again, this time with a few more vertices.
	 * This test will print out the data of each neighbor 
	 */
	@Test
	public void addNeighborTest2Print() {
		//create temporary vertices
		GraphVertex<String> tempA = new GraphVertexImpl<String>();
		tempA.setData("A");
		GraphVertex<String> tempB = new GraphVertexImpl<String>();
		tempB.setData("B");
		GraphVertex<String> tempC = new GraphVertexImpl<String>();
		tempC.setData("C");

		// add the temporary vertices to the neighbors list using addNeighbor()
		testing.addNeighbor(tempA);
		testing.addNeighbor(tempB);
		testing.addNeighbor(tempC);
		
		//this for loop will test functionality by iterating through the list and printing out the elements 
		for(int i=0; i < testing.getNeighbors().size(); i++)
			System.out.println("Testing element is now " + testing.getNeighbors().get(i).getData()); 
	}
	
	/**
	 * Test the addNeighbors() method again, this time with a few more vertices. 
	 * This tester uses assert equals, a stronger test
	 */
	@Test
	public void addNeighborTest2() {
		//create temporary vertices
		GraphVertex<String> tempA = new GraphVertexImpl<String>();
		tempA.setData("A");
		GraphVertex<String> tempB = new GraphVertexImpl<String>();
		tempB.setData("B");
		GraphVertex<String> tempC = new GraphVertexImpl<String>();
		tempC.setData("C");

		// add the temporary vertices to the neighbors list using addNeighbor()
		testing.addNeighbor(tempA);
		testing.addNeighbor(tempB);
		testing.addNeighbor(tempC);
		
		//test functionality by using assert equals
		assertEquals("This test should return the first neighbor's data, which is 'A'",
				"A", //expected
				testing.getNeighbors().get(0).getData());
		
		assertEquals("This test should return the second neighbor's data, which is 'B'",
				"B", //expected
				testing.getNeighbors().get(1).getData());
		
		assertEquals("This test should return the third neighbor's data, which is 'C'",
				"C", //expected
				testing.getNeighbors().get(2).getData());
	}
	
	/**
	 * This tester will see if the list has a specific node as a neighbor. 
	 * This method will show how it looks when the parameter vertex is not a neighbor.
	 */
	@Test
	public void hasNeighborTestF() {
		//create temporary vertices
		GraphVertex<String> tempA = new GraphVertexImpl<String>();
		tempA.setData("A");
		GraphVertex<String> tempB = new GraphVertexImpl<String>();
		tempB.setData("B");
		GraphVertex<String> tempC = new GraphVertexImpl<String>();
		tempC.setData("C");

		// add the temporary vertices to the neighbors list using addNeighbor()
		testing.addNeighbor(tempA);
		testing.addNeighbor(tempB);
		
		//use assertEquals to test functionality
		assertEquals("This should return false because tempC was never added to be a neighbor",
				false, //expected
				testing.hasNeighbor(tempC));
	}	
	
	/**
	 * This tester will see if the list has a specific node as a neighbor. 
	 * This method will show how it looks when the parameter vertex is a neighbor.
	 */
	@Test
	public void hasNeighborTestT() {
		//create temporary vertices
		GraphVertex<String> tempA = new GraphVertexImpl<String>();
		tempA.setData("A");
		GraphVertex<String> tempB = new GraphVertexImpl<String>();
		tempB.setData("B");
		GraphVertex<String> tempC = new GraphVertexImpl<String>();
		tempC.setData("C");

		// add the temporary vertices to the neighbors list using addNeighbor()
		testing.addNeighbor(tempA);
		testing.addNeighbor(tempB);
			
		//use assertEquals to test functionality
		assertEquals("This should return true because tempA is a neighbor of the testing vertex",
				true, //expected
				testing.hasNeighbor(tempA));
	}

}
