/*
 * Problem:  https://leetcode.com/problems/word-ladder-ii/
 *
 * Idea:    1. Use BFS to find the shortest distance between start and end, 
 *             tracing the distance of crossing nodes from start node to end node, 
 *             and store node's next level neighbors to HashMap;
 *
 *          2. Use DFS to output paths with the same distance as the shortest distance from distance HashMap:
 *             compare if the distance of the next level node equals the distance of the current node + 1
 */

public class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
        wordList.add(endWord);
        bfs(beginWord, endWord, wordList, nodeNeighbors, distance);  
        dfs(beginWord, endWord, wordList, nodeNeighbors, distance, new ArrayList<String>(), res);   
        return res;
    }
    
    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String startWord, String endWord, Set<String> wordList, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        
        for (String str: wordList) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);
        distance.put(startWord, 0);
        
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, wordList);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (endWord.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (foundEnd) break;
            }
        }
        
    }
    
    // Find all next level nodes.    
    private List<String> getNeighbors(String node, Set<String> wordList) {
        List<String> neighbors = new ArrayList<>();
        char charArr[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == ch) continue;
                char tmp = charArr[i];
                charArr[i] = ch;
                String str = String.valueOf(charArr);
                if (wordList.contains(str)) {
                    neighbors.add(str);
                }
                charArr[i] = tmp;
            }
        }
        return neighbors;
    }
    
    // DFS: output all paths with the shortest distance
    private void dfs(String curWord, String endWord, Set<String> wordList, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(curWord);
        if (endWord.equals(curWord)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String nextWord : nodeNeighbors.get(curWord)) {
                if (distance.get(nextWord) == distance.get(curWord) + 1) {
                    dfs(nextWord, endWord, wordList, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
