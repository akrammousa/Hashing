
public class Main {
    public static void main(String args[] ) {
	LinearTable q = new LinearTable(8);
	Object[] keys = {1,2,3,4,5,6,7,8};
	q.addKey(keys);
	LinearNode[] t = q.hashedKeys;
    }
}
