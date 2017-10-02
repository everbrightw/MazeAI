import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MST {
    public static List<Node> vertices = new ArrayList<Node>();

    public static List<Edge> edges = new ArrayList<Edge>();

    public static List<Edge> path = new ArrayList<Edge>();

    public static void setEdges() {
        vertices.add(MazeMap.startNode);
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                Node startNode = vertices.get(i);
                Node endNode = vertices.get(j);
                edges.add(new Edge(startNode, endNode,
                        AStar.getDistance(startNode, endNode)));
            }
        }
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



}
