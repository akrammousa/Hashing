
public class Main {
    public static void main(String args[] ) {
	LinearTable q = new LinearTable(8);
	Object[] keys = {1,2,3,4,5,6,7,88};
	q.addKey(keys);
	LinearNode[] t = q.hashedKeys;
	System.out.println(q.search(6));
	System.out.println(q.search(12));
	System.out.println(q.search(5));
	System.out.println(q.search(2));
	System.out.println(q.search(1));
	System.out.println(q.search(52));
	System.out.println(q.search(88));




    }
}
