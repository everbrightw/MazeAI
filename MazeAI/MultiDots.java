import java.util.*;
class MultiDots{
	public static List<Node> destinations = new ArrayList<Node>();
	// TODO: find all of the dots in the maze

	
	public static List<Integer> costDistance = new ArrayList<Integer>();
	
	//BFS test
	public static void findPath(){

		Node startNode = MazeMap.startNode;

		List<Node> mazemap = MazeMap.curr_map;
		
		List<Node> curr_destination = destinations;//might wrong
		for (Node it_node : curr_destination) {
			BFS bfs = new BFS();

			MazeMap.destination = it_node;

			bfs.runBfs(startNode);

			int length = bfs.trace.size();

			costDis.add(length);
		}

	}
	//a star find multiple dots shortest path
	public static void findShortesetPath(){

	}

}	