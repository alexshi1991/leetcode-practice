/*
 * Problem:  https://leetcode.com/problems/clone-graph/
 *
 * Idea:     1. use a hashmap to create 1-1 mapping between original graph node and clone graph node
 *           2. copy the nodes first, and copy the neighbor links once we get the 1-1 mapping
 */


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        // copy the nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        for (int i = 0; i < nodes.size(); i++) {
            for (UndirectedGraphNode neighbor : nodes.get(i).neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        
        // copy neighbor links
        for (UndirectedGraphNode n: nodes) {
            UndirectedGraphNode nodeClone = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                nodeClone.neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}
