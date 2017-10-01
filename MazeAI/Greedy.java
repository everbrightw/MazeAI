import java.util.*;

class Greedy{

	public static Node greedySearch(){
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		pQueue.add(MazeMap.startNode);
		while(!pQueue.isEmpty()){
			Node curr_node = pQueue.poll();
			if(curr_node.equals(MazeMap.destination)){
				return curr_node;
			}
			else{
				for (Node it_node : curr_node.neighbor) {
					if(!it_node.isVisited && !it_node.isBlocked){
						it_node.isVisited == true;
						pQueue.add(it_node);
					}
					
				}
			}

		}

	}
}