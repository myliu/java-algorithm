package leet;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        pathSum(root, sum, path, paths);
        return paths;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null)
            return;

        List<Integer> newPath = new ArrayList<Integer>(path);
        newPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            paths.add(newPath);
            return;
        }

        pathSum(root.left, sum - root.val, newPath, paths);
        pathSum(root.right, sum - root.val, newPath, paths);
    }

}


