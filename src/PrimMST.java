import java.util.Scanner;

public class PrimMST extends Graph{
	int cost;
	int[] key;
	int[] included;

	public PrimMST(int v) {
		super(v);
		cost = 0;
		key = new int[v];
		for(int i = 0; i<v; i++)	key[i] = Integer.MAX_VALUE;
		included = new int[v];
	}
	
	int extractMin(){
		int min=Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<v;i++){
			if(included[i]==0 && key[i]<min){
				min = key[i];
				index=i;
			}
		}
		return index;
	}
	
	void Prim(int[][] weight, int start){
		key[start]=0;
		vertex[start].parent=null;
		int u = extractMin();
		while(u!=-1){
			cost+=key[u];
			for(Vertex ver:vertex[u].adj){
				if(included[ver.data]==0 && weight[u][ver.data]<key[ver.data]){
					ver.parent=vertex[u];
					key[ver.data]=weight[u][ver.data];
				}
			}
			included[u]=1;
			u=extractMin();
		}
		System.out.println("Cost: "+cost);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] weight = new int[v][v];
		PrimMST g = new PrimMST(v);
		for(int i = 0; i<e; i++){
			int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
			weight[a][b]=w;
			weight[b][a]=w;
			g.addEdge(a, b);
		}
		int start = 0;
		g.Prim(weight,start);
		sc.close();
	}
}

/*
SAMPLE CASE
5 8
0 1 1
0 2 4
0 4 2
2 4 3
1 4 3
3 1 3
3 2 1
3 4 2
*/
