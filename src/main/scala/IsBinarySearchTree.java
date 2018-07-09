import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree {

    private static class Node {

        int data;
        Node left;
        Node right;
    }

    private List<Integer> dataList = new ArrayList<>();

    boolean checkBST(Node root) {
        return checkFor(root, -1, Integer.MAX_VALUE);
    }

    boolean checkFor(Node node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            if (node.data < min || node.data > max || dataList.contains(node.data)) {
                return false;
            } else {
                dataList.add(node.data);
                return checkFor(node.left, min, node.data) &&
                        checkFor(node.right, node.data, max);
            }
        }
    }

}

