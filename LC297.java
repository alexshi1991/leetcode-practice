/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


/**************  ITERATIVE SOLUTION  ****************/


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)  return "";
        StringBuilder encoding = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                encoding.append("n ");
            } else {
                encoding.append(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return encoding.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())  return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.remove();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }


/**************  RECURSIVE SOLUTION  ****************/

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())  return null;
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals("N"))  return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
