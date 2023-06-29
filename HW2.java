
public class HW2<T>{

    Node head;
    Node tail;

    public static void main(String[] args) {
        HW2<Integer> integerHW2 = new HW2<>();
        integerHW2.add(1);
        integerHW2.add(2);
        integerHW2.add(3);
        integerHW2.add(4);
        integerHW2.printList(); 
        System.out.println("=======================");
        integerHW2.revert();
        integerHW2.printList(); 
    }

    public void printList(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.println(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void revert(){
        Node currentNode = head;
        while(currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(previous == null){
                tail = currentNode;
            }
            if(next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node{
        int value;
        Node next;
        Node previous;
    }
}