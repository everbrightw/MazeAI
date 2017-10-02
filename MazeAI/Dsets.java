
import java.util.Vector;

class Dsets {
    public static Vector<Integer> dsets = new Vector<Integer>();

    //push num items to the dset
    public static void addelements(int num) {
        for (int i = 0; i < num; i++) {
            dsets.add(-1);
        }
    }

    //find the root of @num item and utilize path compression
    public static int find(int num) {
        if (dsets.get(num) < 0) return num;
        else {
           int findRoot = Dsets.find(dsets.get(num));
           dsets.set(num, findRoot);
           return findRoot;
             }
    }


    //unify two disjointsets
    public static void setunion(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        int newSize = dsets.get(root1) + dsets.get(root2);
        if(dsets.get(root1) <= dsets.get(root2)){
        //size of root1 >= than size of root2, root2 union to root1
        dsets.set(root2, root1);
        dsets.set(root1, newSize);
        } else { //size of root1 < than size of root2, root1 union to root2
        dsets.set(root1, root2);
        dsets.set(root2, newSize);
        }

    }
}

