class Edge {
    Node beginNode;
    Node endNode;
    int weight;//acquired from astar getdistance()

    public Edge(Node begin, Node end, int weight) {
        beginNode = begin;
        endNode = end;
        this.weight = weight;
    }

}
