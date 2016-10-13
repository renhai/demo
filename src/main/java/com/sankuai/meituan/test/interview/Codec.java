package com.sankuai.meituan.test.interview;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = q.poll();
                res.append(curr == null ? "#" : curr.val).append(",");
                if (curr != null) {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] items = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(items[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int len = items.length;
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (i < len && !"#".equals(items[i])) {
                curr.left = new TreeNode(Integer.valueOf(items[i]));
                q.offer(curr.left);
            }
            i ++;
            if (i < len && !"#".equals(items[i])) {
                curr.right = new TreeNode(Integer.valueOf(items[i]));
                q.offer(curr.right);
            }
            i ++;
        }
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
