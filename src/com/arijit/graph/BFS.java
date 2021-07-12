package com.arijit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		BFSTraversal graph = new BFSTraversal(4);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(2, 0);
		graph.add(2, 3);
		graph.add(1, 2);
		graph.add(3, 3);
		
		graph.traverse(2);
	}

}

class BFSTraversal {
	private int V;
	private LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public BFSTraversal(int v) {
		this.V = v;
		adj = new LinkedList[V];
		
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void add(int v, int w) {
		adj[v].add(w);
	}
	
	public void traverse(int v) {
		boolean[] visited = new boolean[V];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		
		while( !queue.isEmpty() ) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			
			LinkedList<Integer> againstVertex = adj[vertex];
			
			for(int vertices : againstVertex) {
				if( !visited[vertices] ) {
					visited[vertices] = true;
					queue.add(vertices);
				}
			}
		}		
	}
}