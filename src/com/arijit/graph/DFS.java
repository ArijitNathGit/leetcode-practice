package com.arijit.graph;

import java.util.LinkedList;

public class DFS {

	public static void main(String[] args) {
		DFSTraversal graph = new DFSTraversal(4);
		 
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 2);
		graph.add(2, 0);
		graph.add(2, 3);
		graph.add(3, 3);
		
		graph.traverse(2);

	}

}

class DFSTraversal {
	private int V;
	private LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public DFSTraversal(int v) {
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
		
		DFSUtil(v, visited);
	}
	
	public void traverseDisconnected(int v) {
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < this.V; i++) {
			if( !visited[i] ) DFSUtil(v, visited);
		}
		
	}

	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		LinkedList<Integer> againstVertex = adj[v];
		
		for(int vertex : againstVertex) {
			if( !visited[vertex] ) {
				DFSUtil(vertex, visited);
			}
		}
	}
}