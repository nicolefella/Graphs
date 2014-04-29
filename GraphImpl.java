//CS201 Assignment8
//Nicole Fella

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * GraphImpl using Adjacent List. This is implementation is for a directed graph
 * @author nicole
 * @param <T>
 *
 */
public class GraphImpl<T> implements Graph<T> {

	/**
	 * Instance Fields
	 */
	public Set<GraphVertex<T>> nodes;
	
	/**
	 * Constructor 
	 */
	public GraphImpl(){
		this.nodes = new HashSet<GraphVertex<T>>();
	}
	
	
	/**
	 * Is empty method will check if the graph is empty. This occurs when the set is empty. 
	 */
	public boolean isEmpty() {
		return this.nodes.isEmpty();
	}
	
	
	/**
	 * This method should return the size of the graph (how many nodes there are)
	 */
	public int size() {
		return this.nodes.size();
	}
	
	
	/**
	 * This class will check if there is an edge from origin to destination 
	 */
	public boolean isEdge(GraphVertex<T> origin, GraphVertex<T> destination){
		//if the two are neighbors with one another, return true
		if (origin.hasNeighbor(destination))
		{
			return true;
		}
		//otherwise, return false -- not neighbors
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Add edge will create a linkage between the origin vertex and the destination vertex. 
	 * For directed graphs, the linkage is only from origin to destination, not both ways.  
	 */
	public void addEdge(GraphVertex<T> origin, GraphVertex<T> destination){
		//set there to be an edge
		
		origin.addNeighbor(destination);
		
	}

	
	/**
	 * Add vertex to the set of vertices with data passed in as a parameter
	 */
	public void addVertex(T vertexData){
		//create temporary graph vertex
		GraphVertex<T> tempVertex = new GraphVertexImpl<T>();
		
		//assign the temporary vertex data
		tempVertex.setData(vertexData);
		
		//add the temporary vertex to the set
		nodes.add(tempVertex);
	}
	

	/**
	 * Delete Edge will remove the connection between the origin vertex and the destination vertex. 
	 */
	public void deleteEdge(GraphVertex<T> origin, GraphVertex<T> destination){
		//if there is an edge
		if(isEdge(origin,destination)){
			//delete edge by removing the neighbor
			for (int i=0; i<origin.getNeighbors().size(); i++)
			{
				if (origin.getNeighbors().get(i) == destination)
				{
					//delete the neighbor from the arrayList
					origin.getNeighbors().remove(i);
					break;
				}
			}
		}
		
	}

	
	/**
	 * Delete vertex by walking through the current set of vertices.
	 * Vertices are copied into a temporary set to then be reassigned.
	 * If the desired vertex is there, do not copy it into the new set.
	 */
	public void deleteVertex(GraphVertex<T> vertexParam){
		//if the desired vertex is there
		if(findVertex(vertexParam))
		{	
			//delete vertex by going through the iterated 
			// use iterator to walk across set
			Iterator<GraphVertex<T>> iterator = nodes.iterator();

			// for iterator
			GraphVertex<T> current;
			
			//create temporary set
			Set<GraphVertex<T>> tempSet = new HashSet<GraphVertex<T>>();
	 
			// as long as iterator has another element
			while ( iterator.hasNext() )
			{
				// note: iterator.next() returns an Object
				// this must be cast if you need the specific type
				current = iterator.next(); // get next element
	      
				//if there is a match
				if (current == vertexParam)
					continue;
				
				deleteEdge(current, vertexParam);
				
				tempSet.add(current);
			}
			
			//once iterator has gone through all elements, set tempSet as new nodes set
			this.nodes = tempSet;
	    }
	    
	}
	
	
	/**
	 * This helper method will use an iterator to go through the set of vertices  
	 */
	public boolean findVertex(GraphVertex<T> vertexParam){
		// use iterator to walk across set
	    Iterator<GraphVertex<T>> iterator = nodes.iterator();

	    // for iterator
	    GraphVertex<T> current;
	 
	    // as long as iterator has another element
	    while ( iterator.hasNext() )
	    {
	      // note: iterator.next() returns an Object
	      // this must be cast if you need the specific type
	      current = iterator.next(); // get next element
	      
	      //if there is a match
	      if (current == vertexParam)
	    	  return true;
	    	  
	    }
	    
	  	return false;
	}
	
	/**************** PART 2 ********************/
	
	/**
	 * DFS(recursive) method should return a list of the traversal order.
	 *  from each node, follow a path as far as you can, 
	 *  while visiting only vertices that you have not previously seen. 
	 *  When you reach a previously visited vertex, 
	 *  back up to where you came from and visit the next child of the current node, 
	 *  if any exists. Otherwise back up and repeat this procedure. 
	 *  Stop when you are at v and have backed up from its last child. Use recursion.
	 */
	public List<GraphVertex<T>> dfs( GraphVertex<T> startVertex ) {
		//create set to hold visited vertices
		List<GraphVertex<T>> visited = new ArrayList<GraphVertex<T>>();
		
		//call helper method 
		return recursiveDFS(startVertex, visited);
	}
	
	/**
	 * This is the recursive portion method of the dfs() method.
	 * The dfs() method has the whole description of what dfs does.
	 */
	public List<GraphVertex<T>> recursiveDFS( GraphVertex<T> startVertex, List<GraphVertex<T>> visitedParam) {

		//if the vertex has not been visited, go deeper
		if(!wasVisited(visitedParam, startVertex)) {
			//mark the vertex as visited
			visitedParam.add(startVertex);
						
			for(int neighbor=0; neighbor<startVertex.getNeighbors().size(); neighbor++)
			{
				//if there are neighbors
				if(startVertex.getNeighbors() != null && startVertex.getNeighbors().size() != 0)
				{
					//look for neighbor and pass into recursiveDFS
					visitedParam = recursiveDFS(startVertex.getNeighbors().get(neighbor), visitedParam);
				}
			
			}
			recursiveDFS(startVertex,visitedParam);
			
		}
		//otherwise the vertex has already been seen and recursive function should look up a level
		return visitedParam;
	}
	
	/**
	 * Helper method to see if the vertex in question is visited. 
	 */
	public boolean wasVisited(List<GraphVertex<T>> listParam, GraphVertex<T> vertexParam) {
		//walk through the list passed in as a parameter
		for(int i=0; i<listParam.size(); i++)
		{
			//if the vertex is in the list , return true
			if (listParam.get(i) == vertexParam)
				return true;
		}
		//otherwise, that vertex has not been visited yet so return false
		return false;
	}
	
	
	/**
	 * BFS(iterative) method should return a list of the traversal order.
	 * Breadth-first search (BFS) from node v: visiting by layers.
	 * Uses a queue. Enqueue parameter. Dequeue, and enqueue undiscovered children.
	 * Continue dequeue/enqueue process until queue is empty.
	 * Once queue is empty, all nodes have been examined  
	 */
	public List<GraphVertex<T>> bfs( GraphVertex<T> startVertex ) {
		//create queue
		Queue bfsQ = new QueueLL();
		//create set to hold visited vertices
		List<GraphVertex<T>> visited = new ArrayList<GraphVertex<T>>();
		
		//enqueue the start vertex
		bfsQ.enqueue(startVertex);
		visited.add(startVertex);
		
		//while the queue isn't empty
		while (!bfsQ.isEmpty())
		{
			GraphVertex<T> currentVertex = (GraphVertex<T>)bfsQ.dequeue();
			
			//add neighbors to the queue as long as they aren't already visited
			for (int i=0; i<currentVertex.getNeighbors().size(); i++)
			{
				if(!wasVisited(visited,currentVertex.getNeighbors().get(i))){
					bfsQ.enqueue(currentVertex.getNeighbors().get(i));
					visited.add(currentVertex.getNeighbors().get(i));
				}
			}
		}
		
		//once the queue is empty, all vertices have been examined
		return visited;
	}

	
}
