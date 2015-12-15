package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> list = new ArrayList<String>();
        if (root == null) {
        	return list;
        }
        if (root.left == null && root.right == null) {
        	list.add(root.val + "");
        	return list;
        }
        
        for (String path : binaryTreePaths(root.left)) {
        	list.add(root.val + "->" +  path);
        }
        for (String path : binaryTreePaths(root.right)) {
        	list.add(root.val + "->" +  path);
        }
        return list;
    }
    


}
