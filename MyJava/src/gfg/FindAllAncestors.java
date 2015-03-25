package gfg;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by mdev on 3/12/15.
 */
public class FindAllAncestors {

    static class Node {
        Node(int data) {
            this.data = data;
        }

        Node left;
        Node right;
        int data;
    }

    static class StackNode {
        StackNode(Node node) {
            this.node = node;
            this.status = false;
        }

        Node node;
        boolean status;
    }

    Deque<StackNode> queue = new ArrayDeque<>();

    public static void main(String... args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        Node node9 = new Node(10);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node4.right = node8;
        node6.left = node9;

        new FindAllAncestors().printAncestors(root, root);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node1);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node2);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node3);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node4);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node5);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node6);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node7);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node8);
        System.out.println("--------------------------------------------");
        new FindAllAncestors().printAncestors(root, node9);
        System.out.println("--------------------------------------------");

    }

    public void printAncestors(Node root, Node givenNode) {
        queue.add(new StackNode(root));


        while (!queue.isEmpty()) {
            StackNode topStackNode = queue.peek();
            if (topStackNode.status) {
                queue.pop();
            } else {
                topStackNode.status = true;
                if (topStackNode.node.left != null) {
                    if (topStackNode.node.left.data == givenNode.data)
                        break;
                    queue.addFirst(new StackNode(topStackNode.node.left));
                }
                if (topStackNode.node.right != null) {
                    if (topStackNode.node.right.data == givenNode.data)
                        break;
                    queue.addFirst(new StackNode(topStackNode.node.right));
                }
            }
        }

        while (!queue.isEmpty()) {
            StackNode topStackNode = queue.pop();
            if (topStackNode.status)
                System.out.println(" " + topStackNode.node.data);
        }
    }

}
