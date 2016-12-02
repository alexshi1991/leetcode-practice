/*
 * Problem: https://leetcode.com/problems/simplify-path/
 *
 * Idea:    1. use a LinkedList which implements the Deque<E> interface,
 *          2. a deque is a double ended queue which supports insertion and deletion at both ends
 */

public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        StringBuilder sb = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            switch (dir) {
                case "":
                case ".":
                    break;
                case "..":
                    // remove the previous element if list is not empty
                    if (list.size() > 0) {
                        list.removeLast();
                    }
                    break;
                default:
                    // append to list
                    list.addLast(dir);
            }
        }
        while (!list.isEmpty()) {
            sb.append("/");
            sb.append(list.removeFirst());
        }
        
        if (sb.toString().equals("")) {
            sb.append("/");
        }
        
        return sb.toString();
    }
}
