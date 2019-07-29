package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;
    }

    private Node<E> root;

    public void insert(E data) {
        Node<E> tempNode = new Node<>();
        Node<E> current;

        tempNode.data = data;

        if(root == null) {
            root = tempNode;
        }else{
            current = root;
            while(null != current) {
                if(data.compareTo(current.data) > 0) {
                    if (null == current.right) {
                        current.right = tempNode;
                    } else {
                        current = current.right;
                    }
                }else if(data.compareTo(current.data) < 0){
                    if (null == current.left) {
                        current.left = tempNode;
                    } else {
                        current = current.left;
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
                current = current.right;
            }else{
                current = current.left;
            }
        }
        return current;
    }

    public void delete(E data) {
        Node<E> current = root, parent = null;
        while (null != current && data.compareTo(current.data) != 0) {
            parent = current;
            if (data.compareTo(current.data) > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (null == current) return;

        if (null != current.left && null != current.right) {
            Node<E> minP = current.right, minGP = current;
            while (null != minP.left) {
                minGP = minP;
                minP = minP.left;
            }
            current.data = minP.data;
            current = minP;
            parent = minGP;
        }

        Node<E> child = null;
        if (null != current.left) child = current.left;
        else if (null != current.right) child = current.right;

        if (null == parent) root = child;
        else if (parent.left == current) parent.left = child;
        else parent.right = child;
    }

    public void preOrderTraverse(Node<E> node) {
        if(node != null) {
            System.out.println(node.data);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void inOrderTraverse(Node<E> node) {
        if(node != null) {
            inOrderTraverse(node.left);
            System.out.println(node.data);
            inOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node<E> node) {
        if(node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.println(node.data);
        }
    }

    public void levelOrderTraverse(Node<E> node) {
        if (null == node) return;
        levelOrderTraverse(Collections.singletonList(node));
    }

    public void levelOrderTraverse(List<Node<E>> nodes) {
        List<Node<E>> nextLevelNodes = new ArrayList<>(nodes.size() * 2);
        for (Node<E> node : nodes) {
            System.out.println(node.data);
            if (null != node.left) nextLevelNodes.add(node.left);
            if (null != node.right) nextLevelNodes.add(node.right);
        }
        if (nextLevelNodes.size() > 0) {
            levelOrderTraverse(nextLevelNodes);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] ints = {3,2,1,4,5};
        for(int i : ints) {
            tree.insert(i);
        }
        System.out.println("level order traversal:");
        tree.inOrderTraverse(tree.root);
        System.out.println("after delete 3 level order traversal:");
        tree.delete(3);
        tree.inOrderTraverse(tree.root);
    }
}
