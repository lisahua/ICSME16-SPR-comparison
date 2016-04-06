package Example;
public class List {
    public Node header;
    public int size;

    public List() {
        this(null, 0);
    }

    public List(Node header, int size) {
        this.header = header;
        this.size = size;
    }

    public static class Node {
    	public String name;
//    	public int key;
        public Node next;
        public Node prev;
        
    }
}