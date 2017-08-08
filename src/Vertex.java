import java.util.LinkedList;

public class Vertex {
	LinkedList<Vertex> adj;
	int data;
	int color;//0=white, 1=gray, 2=black
	int distance;//from start vertex
	Vertex parent;
	int discoveryTime;
	int finishTime;
	boolean extracted;
	
	public Vertex(int data){
		this.data=data;
		color=0;
		distance=-1;
		parent=null;
		adj = new LinkedList<>();
		discoveryTime=0;
		finishTime=0;
	}
}
