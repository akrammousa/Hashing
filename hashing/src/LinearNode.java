import java.util.ArrayList;

public class LinearNode {
    QuadraticTable quadraticTable;
    ArrayList<Integer> elements;
    int index;
    int key;

    public LinearNode() {
        elements = new ArrayList<Integer>();
    }
    public void initializeTable(int size){
        quadraticTable = new QuadraticTable(size);
    }


}
