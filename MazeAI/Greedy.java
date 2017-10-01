import java.util.*;

class Greedy{
  public static Comparator<Node> nodeComp = new Comparator<Node>(){
    @Override
    public int compare(Node first, Node second){
      return first.manhattanDistance(MazeMap.destination) - second.manhattanDistance(MazeMap.destination);
    }
  };

  //public static HashMap<Node, Node> trace=new HashMap<Node, Node>();
  public static Node end = null;

	public static Node greedySearch(Node startNode){
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>(99999, nodeComp);

		pQueue.add(startNode);
		while(!pQueue.isEmpty()){
			Node curr_node = pQueue.poll();
			if(curr_node.value == '.'){
				end = curr_node;
        		break;
			}
			else{
				for (Node it_node : curr_node.neighbor) {
					if(!it_node.isVisited && !it_node.isBlocked){
						it_node.isVisited = true;
						pQueue.add(it_node);
            MazeMap.trace.put(it_node, curr_node);
					}
				}
			}
		}
    /**
    while(end != startNode){
      Node parent = trace.get(end);
      if(parent != startNode){
        parent.value = '.';
      }
      end = parent;
    }
    **/
    return end;
	}

}
