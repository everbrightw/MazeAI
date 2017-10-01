import java.io.*;
import java.util.*;
import java.util.Stack;

class BFS{
	//return type  Node: the destination of maze;
	public static HashMap<Node, Node> trace=new HashMap<Node, Node>();
	public static List<Node> visited = new ArrayList<Node>();
	
	public static Node bfs(Node startNode){
		LinkedList<Node> queue = new LinkedList<Node>();

		Node curr_node = startNode;
		curr_node.isVisited = true;
		queue.add(curr_node);//add start node to the queue;
		while(!queue.isEmpty()){

			if(curr_node.equals(MazeMap.destination)){
				return curr_node;
			}

			curr_node = queue.poll();
			curr_node.isVisited = true;
			visited.add(curr_node);
			// System.out.println("x: " + x + "y: " + y);
			for (Node it_child : curr_node.neighbor) {
				if(!it_child.isBlocked && !it_child.isVisited){
					queue.add(it_child);
					MazeMap.trace.put(it_child, curr_node);
					
				}

			}
		}
		return null;
	}
}
