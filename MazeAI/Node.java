public class Node{
	public int x;
	public int y;
	public Node up_child;
	public Node down_child;
	public Node left_child;
	public Node right_child;

	//wall blocking
	public Boolean isVisited;
	public Boolean up_wall;
	public Boolean down_wall;
	public Boolean left_wall;
	public Boolean right_wall;

	//distance from goal state
	public int curr_distance;

	public Node(int x, int y){
		this.x = x;
		this.y = y;

		up_child = null;
		down_child = null;
		left_child = null;
		right_child = null;

		isVisited = false;
		up_wall = false;
		down_wall = false;
		left_wall = false;
		right_wall = false;
	}

  public int manhattanDistance(Node dest) {
      int dist = Math.abs(this.x - dest.x) + Math.abs(this.y - dest.y);
      return dist;
  }

	

}
