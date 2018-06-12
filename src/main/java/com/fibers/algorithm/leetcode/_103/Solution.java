package com.fibers.algorithm.leetcode._103;

import com.fibers.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, null, 5, 6, 7, null, null, null, null, 12, 13};
        TreeNode t = new TreeNode(array);
        Solution s = new Solution();
        s.zigzagLevelOrder(t);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean oddLevel = true;
        while (!q.isEmpty()) {
            List<Integer> listTemp =  new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp = null;
                if (oddLevel) {
                    temp = q.poll();
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                } else {
                    temp = ((LinkedList<TreeNode>) q).pollLast();
                    if (temp.right != null) {
                        ((LinkedList<TreeNode>) q).push(temp.right);
                    }
                    if (temp.left != null) {
                        ((LinkedList<TreeNode>) q).push(temp.left);
                    }
                }

                listTemp.add(temp.val);
            }
            oddLevel = !oddLevel;
            list.add(listTemp);
        }
        return list;
    }
}
