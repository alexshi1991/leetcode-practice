/*
 * Problem:  https://leetcode.com/problems/course-schedule-ii/
 *
 * Idea:     1. prob essentially is to find topological sort of a DAG
 *           2. the reverse postorder of DFS is in topological order
 *           3. cycle detection at the same time (in case not a DAG)
 *           4. DFS runs in linear time, O(|V| + |E|)
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
        
        public Iterable<Integer> adj(int v) {return adj[v];}
        public int indegree(int v) {return indegree[v];}
        public int outdegree(int v) {return adj[v].size();}
        public int V() { return this.V; }
        public int E() { return this.E; }
        
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // build a Digraph
        Digraph dg = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            dg.addEdge(prereq, course);
        }
        
        // DFS that generates a postorder (and also does cycle detection) 
        boolean[] marked = new boolean[dg.V()];
        boolean[] onStack = new boolean[dg.V()];
        Stack<Integer> postorder = new Stack<>();
        boolean[] foundCycle = new boolean[1];
        for (int v = 0; v < dg.V(); v++) {
            if (!marked[v]) {
                dfs(dg, v, marked, onStack, foundCycle, postorder);
                if (foundCycle[0]) break;
            }
        }
        
        // graph contains cycle, return empty array
        if (foundCycle[0]) return new int[0];
            
        // return the reverse postorder of DFS (which is a topological order)
        int[] courseOrder = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseOrder[i] = postorder.pop();
        }
        
        return courseOrder; 
    }
    
    private void dfs(Digraph dg, int v, boolean[] marked, boolean[] onStack, boolean[] foundCycle, Stack<Integer> postorder) {
        if (foundCycle[0]) return;
        marked[v] = true;
        onStack[v] = true;
        for (int w : dg.adj(v)) {
            if (!marked[w]) {
                dfs(dg, w, marked, onStack, foundCycle, postorder);
            } else if (onStack[w]) {
                foundCycle[0] = true;// back-edge detected, must have a cycle
                return;
            }
        }
        postorder.push(v);
        onStack[v] = false; // backtracking
    }
}
