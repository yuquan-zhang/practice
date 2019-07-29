package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<E extends Comparable<E>> {
    protected static class Node<E> {
        protected E data;
        protected Node<E> parent;
        protected Node<E> leftChild;
        protected Node<E> rightChild;
    }

    protected Node<E> root;

    public void insert(E data) {
        Node<E> tempNode = new Node<>();
        Node<E> current;
        Node<E> parent;

        tempNode.data = data;

        if(root == null) {
            root = tempNode;
        }else{
            current = root;
            while(true) {
                parent = current;
                tempNode.parent = parent;
                if(data.compareTo(parent.data) > 0) {
                    current = parent.rightChild;
                    if(current == null) {
                        parent.rightChild = tempNode;
                        return;
                    }
                }else if(data.compareTo(parent.data) < 0){
                    current = parent.leftChild;
                    if(current == null) {
                        parent.leftChild = tempNode;
                        return;
                    }
                }else{
                    return;
                }
            }
        }
    }

    public Node search(E data) {
        Node<E> current = root;
        while(current != null && data.compareTo(current.data) != 0) {
            if(data.compareTo(current.data) > 0) {
                current = current.rightChild;
            }else{
                current = current.leftChild;
            }
        }
        return current;
    }

    public void preOrderTraverse(Node<E> node) {
        if(node != null) {
            System.out.println(node.data);
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }
    }

    public void inOrderTraverse(Node<E> node) {
        if(node != null) {
            inOrderTraverse(node.leftChild);
            System.out.println(node.data);
            inOrderTraverse(node.rightChild);
        }
    }

    public void postOrderTraverse(Node<E> node) {
        if(node != null) {
            postOrderTraverse(node.leftChild);
            postOrderTraverse(node.rightChild);
            System.out.println(node.data);
        }
    }

    public void levelOrderTraverse(Node<E> node) {
        levelOrderTraverse(Collections.singletonList(node));
    }

    public void levelOrderTraverse(List<Node<E>> nodes) {
        List<Node<E>> nextLevelNodes = new ArrayList<>(nodes.size() * 2);
        for (Node<E> node : nodes) {
            System.out.println(node.data);
            if (null != node.leftChild) nextLevelNodes.add(node.leftChild);
            if (null != node.rightChild) nextLevelNodes.add(node.rightChild);
        }
        if (nextLevelNodes.size() > 0) {
            levelOrderTraverse(nextLevelNodes);
        }
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
//        int[] ints = {11,23,54,9,3,5,93,45,24,55,27,43,66};
        int[] ints = {3,2,1,4,5};
        for(int i : ints) {
            tree.insert(i);
        }
        Node node = tree.search(33);
        if(node == null) {
            System.out.println("node is not exist.");
        }else{
            System.out.println("node's data : " + node.data);
        }
        System.out.println("pre order traversal:");
        tree.preOrderTraverse(tree.root);
        System.out.println("in order traversal:");
        tree.inOrderTraverse(tree.root);
        System.out.println("post order traversal:");
        tree.postOrderTraverse(tree.root);
        System.out.println("level order traversal:");
        tree.levelOrderTraverse(tree.root);
    }
}
