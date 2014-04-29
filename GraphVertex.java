//CS201 Assignment8
//Nicole Fella

import java.util.List;

/**
 * ADT GraphVertex Interface
 * @author nicole
 *
 */
public interface GraphVertex<T> {

	/**
	 * Get vertex data will return the current object's data instance field
	 */
	public T getData();
	
	
	/**
	 * Set vertex data will assign parameter data to the object's data instance field
	 */
	public void setData(T paramData);
	

	/**
	 * Get neighbors will return the list of neighbors this Vertex object has
	 */
	public List<GraphVertex<T>> getNeighbors();
	
	
	/**
	 * Has neighbor will iterate through the neighbors list and see if there is a matching vertex
	 */
	public boolean hasNeighbor(GraphVertex<T> neighborParam);
	
	/**
	 * Add neighbors will add the a vertex, passed as a parameter, to the neighbors list
	 */
	public void addNeighbor(GraphVertex<T> neighborParam);
	
}
