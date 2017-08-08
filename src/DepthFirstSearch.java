public class DepthFirstSearch extends Graph{
	int time;
	
	public DepthFirstSearch(int v) {
		super(v);
		time=0;
	}
	
	void DFS(){
		time=0;
	    for(int i=0;i<v;i++){
	        if(vertex[i].color==0)
	            DFSVisit(i);
	    }
	}
	
	void DFSVisit(int u){
		time++;
		vertex[u].discoveryTime=time;
		vertex[u].color=1;
		for(Vertex v: vertex[u].adj){
			if(v.color==0){
				v.parent=vertex[u];
				DFSVisit(v.data);
			}
		}
		time++;
		vertex[u].finishTime=time;
		vertex[u].color=2;
	}
	
	void printTimes(){
		for(Vertex v: vertex){
			System.out.printf("Vertex: %2d start:%2d finish:%2d\n",v.data,
					vertex[v.data].discoveryTime, vertex[v.data].finishTime);
		}
	}
	
	public static void main(String[] args){
		DepthFirstSearch g = new DepthFirstSearch(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(3, 3);
		g.addEdge(4, 2);
		g.DFS();
		g.printTimes();
		
	}

}
