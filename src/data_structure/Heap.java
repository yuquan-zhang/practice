package data_structure;

public class Heap<E extends Comparable<E>> extends Tree<E>{


    @Override
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

                if(parent.leftChild == null) {
                    parent.leftChild = tempNode;
                    swap(tempNode);
                    return;
                }else if(parent.rightChild == null) {
                    parent.rightChild = tempNode;
                    swap(tempNode);
                    return;
                }else {
                    if(Math.random() < 0.5)
                        current = parent.rightChild;
                    else
                        current = parent.leftChild;
                }
            }
        }
    }

    public void swap(Node<E> newNode) {
        while (newNode.parent != null) {
            if(newNode.data.compareTo(newNode.parent.data) > 0) {
                E temp = newNode.parent.data;
                newNode.parent.data = newNode.data;
                newNode.data = temp;
                newNode = newNode.parent;
            }else{
                return;
            }
        }
    }

    @Override
    public Node search(E data) {
        return search(root,data);
    }

    public Node<E> search(Node<E> parent, E data) {
        Node<E> result;
        if(parent != null){
            if(data.compareTo(parent.data) == 0) return parent;
            else{
                result = search(parent.leftChild,data);
                if(result == null) result = search(parent.rightChild,data);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Heap<Integer> tree = new Heap<>();
        int[] ints = {11,23,54,9,3,5,93,45,24,55,27,43,66};
        for(int i : ints) {
            tree.insert(i);
        }
        Node node = tree.search(5);
        if(node == null) {
            System.out.println("node is not exist.");
        }else{
            System.out.println("node's data:" + node.data + ", parent's data:" + node.parent.data);
        }
        System.out.println("pre order traversal:");
        tree.preOrderTraverse(tree.root);
        System.out.println("in order traversal:");
        tree.inOrderTraverse(tree.root);
        System.out.println("post order traversal:");
        tree.postOrderTraverse(tree.root);
    }


}
