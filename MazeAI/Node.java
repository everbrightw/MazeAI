

class Node{

	public int x;
	public int y;
	public Node up_child;
	public Node down_child;
	public Node left_child;
	public Node right_child;

	//has visited;
	public Boolean isVisited;
  //three way blocked
	public Boolean isBlocked;

  public char value;//store for curr node's value;

	//distance from goal state
	public int curr_distance;



  public int manhattanDistance(Node dest) {
      int dist = Math.abs(this.x - dest.x) + Math.abs(this.y - dest.y);
      return dist;
  }


  public Node(int x, int y, char value){
    this.x = x;
    this.y = y;

    this.value = value;

    up_child = null;
    down_child = null;
    left_child = null;
    right_child = null;

    isVisited = false;

    isBlocked = false;
  }
  
}
