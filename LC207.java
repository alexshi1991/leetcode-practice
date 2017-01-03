/*
 * Problem:  https://leetcode.com/problems/course-schedule/
 *
 * Idea:     1. cycle detection in a directed graph using DFS
 *           2. a directed graph contains a directed cycle, if and only if there exists a back edge
 *           3. a back edge is an edge that points to an ancestor node (or itself) in the DFS traversal 
 *           4. use two boolean[] arrays, one for marking visited nodes, 
 *              the other for tracking whether a certain graph node is currently on the DFS traversal stack
 *           5. running time is O(|V| + |E|)
 *
 */


public class Solution {
    
    // represent a Directed Graph
    static class Digraph {
        
        private final int V;          // number of vertices
        private int E;                // number of edges
        private List<Integer>[] adj;  // adjacency list
        private int[] indegree;  
        
        public Digraph(int V) {
            this.V = V;
            this.E = 0;
            indegree = new int[V];
            adj = new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<>();
            }
        }
        
        public void addEdge(int v, int w) {
            adj[v].add(w);
            indegree[w]++;
            E++;
        }
        
        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
        
        public int indegree(int v) {
            return indegree[v];
        }
        
        public int outdegree(int v) {
            return adj[v].size();
        }
        
        public int V() { return this.V; }
        public int E() { return this.E; }
        
    }
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // build a Digraph
        Digraph dg = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            dg.addEdge(prereq, course);
        }
        
        // cycle detection using DFS
        boolean[] marked = new boolean[dg.V()];
        boolean[] onStack = new boolean[dg.V()];
        boolean[] foundCycle = new boolean[1]; // array is passed by reference
        for (int v = 0; v < dg.V(); v++) {
            if (!marked[v]) {
                dfs(dg, v, marked, onStack, foundCycle);
                if (foundCycle[0]) break;
            }
        }
        return !foundCycle[0];
    }
    
    private void dfs(Digraph dg, int v, boolean[] marked, boolean[] onStack, boolean[] foundCycle) {
        
        if (foundCycle[0]) return;
        
        marked[v] = true;
        onStack[v] = true;
        
        for (int w : dg.adj(v)) {
            if (!marked[w]) {
                dfs(dg, w, marked, onStack, foundCycle);
            } else if (onStack[w]) {
                // back-edge detected, must have a cycle
                foundCycle[0] = true;
                return;
            }
        }
        
        onStack[v] = false; // backtracking
    }
}
