//CS201 Assignment8
//Nicole Fella

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing class to test functionality of the methods in GraphImpl
 * @author nicole
 *
 */
public class GraphImplTest {

	/**
	 * Testing fields. We need a graph to run tests on to test functionality of GraphImpl methods. 
	 */
	GraphImpl<String> tester = new GraphImpl<String>();
	private GraphVertex<String> tempA;
	private GraphVertex<String> tempB;
	private GraphVertex<String> tempC;
	
	/**
	 * Testing fields for traversal (dfs and bfs) algorithms
	 */
	GraphImpl<String> testing = new GraphImpl<String>();
	private GraphVertex<String> tempQ;
	private GraphVertex<String> tempW;
	private GraphVertex<String> tempE;
	private GraphVertex<String> tempR;
	private GraphVertex<String> tempT;
	private GraphVertex<String> tempY;
	private GraphVertex<String> tempZ;
	
	/**
	 * Build test graph for the testing variable. The test graph built will be testing dfs() and bfs()
	 */
	@Before
	public void buildTesting() {
		//set data for nodes
		tempQ = new GraphVertexImpl<String>();
		tempQ.setData("Q");
		tempW = new GraphVertexImpl<String>();
		tempW.setData("W");
		tempE = new GraphVertexImpl<String>();
		tempE.setData("E");
		tempR = new GraphVertexImpl<String>();
		tempR.setData("R");
		tempT = new GraphVertexImpl<String>();
		tempT.setData("T");
		tempY = new GraphVertexImpl<String>();
		tempY.setData("Y");
		tempZ = new GraphVertexImpl<String>();
		tempZ.setData("Z");
		
		//put nodes in a set 
		Set<GraphVertex<String>> testingSet = new HashSet<GraphVertex<String>>();
		testingSet.add(tempQ);
		testingSet.add(tempW);
		testingSet.add(tempE);
		testingSet.add(tempR);
		testingSet.add(tempT);
		testingSet.add(tempY);
		testingSet.add(tempZ);
		
		//assign that set to the tester nodes variable
		testing.nodes = testingSet;
				
		//make graph neighbors as pictured in drawing
		tempQ.addNeighbor(tempE);
		tempQ.addNeighbor(tempR);
		tempQ.addNeighbor(tempT);
		tempE.addNeighbor(tempW);
		tempW.addNeighbor(tempZ);
		tempW.addNeighbor(tempY);
	}
	
	/**
	 * Build a test graph before running other tests
	 */
	@Before
	public void buildTester() {
		//create temporary vertices
		tempA = new GraphVertexImpl<String>();
		tempA.setData("A");
		tempB = new GraphVertexImpl<String>();
		tempB.setData("B");
		tempC = new GraphVertexImpl<String>();
		tempC.setData("C");
		
		//create a set with the nodes
		Set<GraphVertex<String>> testSet = new HashSet<GraphVertex<String>>();
		testSet.add(tempA);
		testSet.add(tempB);
		testSet.add(tempC);
		
		//assign that set to the tester nodes variable
		tester.nodes = testSet;
		
		// add the temporary vertices to the neighbors list using addNeighbor()
		tempA.addNeighbor(tempB);
		tempB.addNeighbor(tempC);
	}
	
	
	/**
	 * Test isEmpty() method which will tell us if the set is empty (has no nodes)
	 */
	@Test
	public void isEmptyTest() {
		//use assertEquals to test the functionality
		assertEquals("This test will return false since the set of nodes is not empty",
				false, //expected
				tester.isEmpty());
		
	}
	
	/**
	 * Test size() method to see how many vertices are in this graph
	 */
	@Test
	public void sizeTest() {
		//use assertEquals to test functionality
		assertEquals("This test should return 3, since there are three vertices",
				3, //expected
				tester.size());
	}
	

	/**
	 * Test isEdge() function between two nodes which are neighbors of one another.
	 * This tester will see if the method works correctly when there is an edge between two nodes
	 */
	@Test
	public void isEdgeTestT() {
		//use assertEquals to test functionality
		assertEquals("This test should return true, since tempA and tempB share an edge",
				true, //expected
				tester.isEdge(tempA, tempB));
	}
	
	/**
	 * Test isEdge() function between two nodes which are neighbors of one another.
	 * This tester will see if the method works correctly when there is NOT an edge between two nodes
	 */
	@Test
	public void isEdgeTestF() {
		//use assertEquals to test functionality
		assertEquals("This test should return false, since tempA and tempC don't share an edge",
				false, //expected
				tester.isEdge(tempA, tempC));
	}

	/**
	 * Test functionality of addEdge() method
	 */
	@Test
	public void addEdgeTest() {
		//run addEdge function
		tester.addEdge(tempA, tempC);
		//use assertEquals to test functionality
		assertEquals("This test should now return true, since tempA and tempC do share an edge",
				true, //expected
				tester.isEdge(tempA, tempC));
	}
	
	
	/**
	 * Test functionality of addVertex() method
	 */
	@Test
	public void addVertexTest() {		
		//run addVertex() method
		tester.addVertex("D");
		//size should now change
		assertEquals("This test should return 4 since the size has changed, incrementing by one",
				4, //expected
				tester.size());
	}


	/** 
	 * Test the findVertex() method
	 */
	@Test
	public void findVertexTestT() {
		//use assertEquals to test functionality
		assertEquals("This test should return the true since there is a matched vertex",
				true,//expected
				tester.findVertex(tempA));
	}
	
	/**
	 * Test the findVertex() method again
	 */
	@Test
	public void findVertexTestF() {
		//create tempD
		GraphVertexImpl<String> tempD = new GraphVertexImpl<String>();
		tempD.setData("D");
		//use assertEquals to test functionality
		assertEquals("This test should return false since there is no matched vertex",
				false,//expected
				tester.findVertex(tempD));
	}


	/**
	 * Test the deleteEdge() method by trying to delete a connection from tempB to tempC
	 */
	@Test
	public void deleteEdgeTest() {
		//run the deleteEdge() method
		tester.deleteEdge(tempB, tempC);
		
		//use assertEquals to test functionality
		assertEquals("This test should return false since the edge has been deleted",
				false, //expected
				tester.isEdge(tempB, tempC));
	}
	
	/**
	 * Test deleteVertex() and see if it can be found again
	 */
	@Test
	public void deleteVertexTest() {
		//run deleteVertex() method to remove tempA from the set
		tester.deleteVertex(tempA);
		
		//use assertEquals to test functionality 
		assertEquals("This test should return false since tempA was deleted",
				false, //expected
				tester.findVertex(tempA));
	}
	
	/**
	 * Test helper method wasVisited(). Must build a set for visited. 
	 */
	@Test
	public void wasVisited() {
		//create temporary vertices
		GraphVertexImpl<String>	tempD = new GraphVertexImpl<String>();
		tempD.setData("D");
		GraphVertexImpl<String>	tempE = new GraphVertexImpl<String>();
		tempE.setData("E");
		GraphVertexImpl<String>	tempF = new GraphVertexImpl<String>();
		tempF.setData("F");
				
		//create a List with the nodes
		List<GraphVertex<String>> testList = new ArrayList<GraphVertex<String>>();
		testList.add(tempD);
		testList.add(tempE);
		testList.add(tempF);
		
		//use assertEquals to test functionality
		assertEquals("This test should return true",
				true, //expected
				tester.wasVisited(testList, tempE));;
	}
	
	/**
	 * Test the depth-first search algorithm. This will test dfs() and recursiveDFS() methods
	 */
	@Test
	public void dfsTest() {
		//make the arrayList expected
		List<GraphVertex<String>> expected = new ArrayList<GraphVertex<String>>();
		expected.add(tempQ);
		expected.add(tempE);
		expected.add(tempW);
		expected.add(tempZ);
		expected.add(tempY);
		expected.add(tempR);
		expected.add(tempT);
		
		//use assertEquals to test functionality
		assertEquals("This test should return the 'expected' list generated above",
				expected,
				testing.dfs(tempQ));
	}

	/**
	 * Test the breadth-first search algorithm. This will test bfs() method
	 */
	@Test 
	public void bfsTest() {
		//make the arrayList expected
		List<GraphVertex<String>> expected = new ArrayList<GraphVertex<String>>();
		expected.add(tempQ);
		expected.add(tempE);
		expected.add(tempR);
		expected.add(tempT);
		expected.add(tempW);
		expected.add(tempZ);
		expected.add(tempY);
				
		//use assertEquals to test functionality
		assertEquals("This test should return the 'expected' list generated above",
				expected,
				testing.bfs(tempQ));
	}
}
