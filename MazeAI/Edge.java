
class Edge implements Comparable{
	Node beginNode;
	Node endNode;
	int weight;//acquired from astar getdistance()

	public Edge(Node begin, Node end, int weight){
		beginNode = begin;
		endNode = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge other){
		return this.weight - other.weight;
	}

}
