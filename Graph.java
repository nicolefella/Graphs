import java.util.List;

//CS201 Assignment8
//Nicole Fella

/**
 * ADT Graph Interface
 * @author nicole
 * @param <T>
 *
 */
public interface Graph<T> {
	
	/**
	 * Is empty method will check if the graph is empty. This occurs when the set is empty. 
	 */
	public boolean isEmpty();
	
	
	/**
	 * This method should return the size of the graph (how many nodes there are)
	 */
	public int size();
	
	
	/**
	 * This class will check if there is an edge from origin to destination 
	 */
	public boolean isEdge(GraphVertex<T> origin, GraphVertex<T> destination);
	
	
	/**
	 * Add edge will create a linkage between the origin vertex and the destination vertex. 
	 * For directed graphs, the linkage is only from origin to destination, not both ways. 
	 */
	public void addEdge(GraphVertex<T> origin, GraphVertex<T> destination);

	
	/**
	 * Add vertex to the set of vertices with data passed in as a parameter
	 */
	public void addVertex(T vertexData);
	

	/**
	 * Delete Edge will remove the connection between the origin vertex and the destination vertex. 
	 */
	public void deleteEdge(GraphVertex<T> origin, GraphVertex<T> destination);

	
	/**
	 * Delete vertex by walking through the current set of vertices.
	 * Vertices are copied into a temporary set to then be reassigned.
	 * If the desired vertex is there, do not copy it into the new set.
	 */
	public void deleteVertex(GraphVertex<T> vertexParam);
	
	
	/**
	 * This helper method will use an iterator to go through the set of vertices 
	 */
	public boolean findVertex(GraphVertex<T> vertexParam);


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
	public List<GraphVertex<T>> dfs( GraphVertex<T> v );
	
	/**
	 * This is the recursive portion method of the dfs() method.
	 * The dfs() method has the whole description of waht dfs does.
	 */
	public List<GraphVertex<T>> recursiveDFS( GraphVertex<T> startVertex, List<GraphVertex<T>> visitedParam);
	
	/**
	 * BFS(iterative) method should return a list of the traversal order.
	 * Breadth-first search (BFS) from node v: visiting by layers.
	 * Uses a queue
	 */
	public List<GraphVertex<T>> bfs( GraphVertex<T> v );
}
