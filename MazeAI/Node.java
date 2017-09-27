

public class Node{

	public int x_position;
	public int y_position;

	public Node up_child;
	public Node down_child;
	public Node left_child;
	public Node right_child;

	//wall blocking 
	public boolean isVisited;
	public boolean up_wall;
	public boolean down_wall;
	public boolean left_wall;
	public boolean right_wall;

	//distance from goal state
	public int curr_distance;

}