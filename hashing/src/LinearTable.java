public class LinearTable {
    MatrixMethod h;
    int m;
    LinearNode[] hashedKeys;

    public LinearTable(int m) {
        this.m = m;
        hashedKeys = new LinearNode[m];
        h = new MatrixMethod(m);
    }

    public void addKey(Object[] keys) {
        for (int i = 0; i < keys.length; i++) {
            int index = h.getIndexOfKey((int) keys[i]);
            if (hashedKeys[index] == null) {
                LinearNode node = new LinearNode();
                node.key = (int) keys[i];
                node.index = index;
                hashedKeys[index] = node;
            } else {
                hashedKeys[index].elements.add((int) keys[i]);
            }
        }
        if (checkLevelTwoCondition()){
            makeLevelTwo();
        }
        else{
            hashedKeys = new LinearNode[m];
            h.randomizeHashFunction();
            addKey(keys);
        }
    }



    private boolean checkLevelTwoCondition() {
        int sum = 0;
        for (int i = 0; i < hashedKeys.length; i++) {
            if (hashedKeys[i] != null){
                sum = sum + hashedKeys[i].elements.size();
            }

        }
        if (sum <= 4 * m) {
	    return true;
	}
        return false;
    }
    private void makeLevelTwo() {
        for (int i = 0; i < hashedKeys.length; i++) {
            LinearNode node = hashedKeys[i];
            if (node != null && node.elements.size() != 0 ){
                node.initializeTable(node.elements.size());
                node.quadraticTable.addKey(node.elements.toArray());
            }
        }
    }
}