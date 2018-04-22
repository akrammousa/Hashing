public class QuadraticTable {
    MatrixMethod h;
    int m;
    QuadraticNode[] hashedkeys;

    public QuadraticTable(int size) {
        m = (int) Math.pow(size,2);
        h = new MatrixMethod(m);
        hashedkeys = new QuadraticNode[m];
    }

    public void addKey (Object[] keys){
        for (int i = 0; i < keys.length ; i++) {
            int index = h.getIndexOfKey((Integer) keys[i]);
            System.out.print(index);
            if (hashedkeys[index] == null){
                QuadraticNode node = new QuadraticNode();
                node.index = index;
                node.key = (int) keys[i];
                hashedkeys[index] = node;
            }
            else{
                this.h = new MatrixMethod(m);
                hashedkeys = new QuadraticNode[m];
                i=-1;
            }
        }
    }

}
