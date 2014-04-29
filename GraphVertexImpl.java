//CS201 Assignment8
//Nicole Fella

import java.util.List;
import java.util.ArrayList;

/**
 * GraphVertex implementation
 * @author nicole
 *
 */
public class GraphVertexImpl<T> implements GraphVertex<T> {

	/**
	 * Instance Fields
	 */
	T data;
	List<GraphVertex<T>> neighbors;
	
	/** 
	 * Constructor initializes neighbors list and sets data to null.
	 */
	public GraphVertexImpl()
	{
		data = null;
		neighbors = new ArrayList<GraphVertex<T>>();
	}
	
	/**
	 * Get vertex data will return the current object's data instance field
	 */
	public T getData(){
		return this.data;
	}
	

	/**
	 * Set vertex data will assign parameter data to the object's data instance field 
	 */
	public void setData(T paramData){
		this.data = paramData;
	}
	
	
	/**
	 * Get neighbors will return the list of neighbors this Vertex object has
	 */
	public List<GraphVertex<T>> getNeighbors(){
		return this.neighbors;
	}
	
	
	/**
	 * Has neighbor will iterate through the neighbors list and see if there is a matching vertex 
	 */
	public boolean hasNeighbor(GraphVertex<T> neighborParam) {
		//iterate through the neighbors list
		for (int i = 0 ; i<this.getNeighbors().size(); i++)
		{
			//if there is a matching vertex to the parameter 
			if (this.neighbors.get(i) == neighborParam)
				//return true
				return true;
		}
		//otherwise there is no match, so return false
		return false;
	}
	
	
	/**
	 * Add neighbors will add the a vertex, passed as a parameter, to the neighbors list
	 */
	public void addNeighbor(GraphVertex<T> neighborParam){
		neighbors.add(neighborParam);
	}
}
