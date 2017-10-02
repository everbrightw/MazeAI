import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MST {
    public static List<Node> vertices = new ArrayList<Node>();

    public static List<Edge> edges = new ArrayList<Edge>();

    public static List<Edge> path = new ArrayList<Edge>();

    public static void setEdges() {

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                Node startNode = vertices.get(i);
                Node endNode = vertices.get(j);
                edges.add(new Edge(startNode, endNode,
                        AStar.getDistance(startNode, endNode)));
            }
        }
        //Collections.reverse(edges);
        sortEdges();
    }

    public static void sortEdges() {

        for (int i = 0; i < edges.size(); i++) {
            int min = i;
            for (int j = i + 1; j < edges.size(); j++) {
                if (edges.get(j).weight < edges.get(min).weight) {
                    min = j;
                }
            }
            if (min != i) {
                Collections.swap(edges, i, min);
            }
        }
    }


    public static void addNodes(){
        Dsets.addelements(vertices.size());
    }


    public static void findMST(){
        int count = 0;
        for(int i = 0; count < vertices.size() - 1; i ++){
            int u = vertices.indexOf(edges.get(i).beginNode);
            int v = vertices.indexOf(edges.get(i).endNode);
            //System.out.println("findu " + Dsets.find(u));
            if(Dsets.find(u) != Dsets.find(v)){
                if(((edges.get(i).beginNode.value == 'P' && edges.get(i).beginNode.degree < 1)
             && (edges.get(i).endNode.value != 'P' && edges.get(i).endNode.degree < 2))
             || ((edges.get(i).beginNode.value != 'P' && edges.get(i).beginNode.degree < 2)
             && (edges.get(i).endNode.value == 'P' && edges.get(i).endNode.degree < 1))
             || ((edges.get(i).beginNode.value != 'P' && edges.get(i).beginNode.degree < 2)
             && (edges.get(i).endNode.value != 'P' && edges.get(i).endNode.degree < 2))){
                edges.get(i).beginNode.degree++;
                edges.get(i).endNode.degree++;
                System.out.println("value " + edges.get(i).beginNode.value + "degree " + edges.get(i).beginNode.degree);
                System.out.println("value " + edges.get(i).endNode.value + "degree " + edges.get(i).beginNode.degree);
                Dsets.setunion(u, v);
                path.add(edges.get(i));//ssave the edges paths;
                count ++;
            }
            }
        }
    }

}
