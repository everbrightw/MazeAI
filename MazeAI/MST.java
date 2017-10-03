import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MST {
    //set every dot as vertex
    public static List<Node> vertices = new ArrayList<Node>();
    //set every distance between every two dots as edges
    public static List<Edge> edges = new ArrayList<Edge>();
    //store the edges we used to build MST
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
        // Collections.reverse(edges);
        sortEdges();
    }

    public static void sortEdges() {
       //use selection to sort the edges by weight(shortestPath), increasing order

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
            //use the index of vertices to build disjointset
            int u = vertices.indexOf(edges.get(i).beginNode);
            int v = vertices.indexOf(edges.get(i).endNode);
            //System.out.println("findu " + Dsets.find(u));
            if(Dsets.find(u) != Dsets.find(v)){
              //here is a little different from MST in CS 225
              //Because we need to choose the edges which can create a continous path around vertices,
              //startNode cannot have degree more than 2 and other nodes cannot have degree more than 3,
              //which can promise that there is no more than 2 paths from one node which is not startNode,
              //for startNode, only one path going out from it
                if(((edges.get(i).beginNode.value == 'P' && edges.get(i).beginNode.degree < 1)
             && (edges.get(i).endNode.value != 'P' && edges.get(i).endNode.degree < 2))
             || ((edges.get(i).beginNode.value != 'P' && edges.get(i).beginNode.degree < 2)
             && (edges.get(i).endNode.value == 'P' && edges.get(i).endNode.degree < 1))
             || ((edges.get(i).beginNode.value != 'P' && edges.get(i).beginNode.degree < 2)
             && (edges.get(i).endNode.value != 'P' && edges.get(i).endNode.degree < 2))){
                edges.get(i).beginNode.degree++; //count the degree
                edges.get(i).endNode.degree++;
                System.out.println("value " + edges.get(i).beginNode.value + "degree " + edges.get(i).beginNode.degree);
                System.out.println("value " + edges.get(i).endNode.value + "degree " + edges.get(i).beginNode.degree);
                Dsets.setunion(u, v);
                path.add(edges.get(i));//save the edges paths;
                count ++;
            }
            }
        }
    }

}
