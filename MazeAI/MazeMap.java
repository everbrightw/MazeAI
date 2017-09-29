import java.util.List;
import java.util.ArrayList;

class MazeMap{
	public static List<Node> curr_map = new ArrayList<Node>();//Todo: node
	public static int width;



		public void initializeMap(int x, int y, String line){
	    for(int i = 0; i < line.length(); i++){
	      	this.curr_map.add(new Node(x, y, line.charAt(x)));
  }
	  }


	public static void printMap(List<Node> curr_map){
		for (int i = 0; i < curr_map.size(); i++) {
			System.out.print(curr_map.get(i).value);
			if((i+1) % width == 0){
				System.out.println();
			}
		}
		System.out.println("finish");
	}
	public static Node getNode(int x, int y){
		return curr_map.get(width * y + x);
	}
}
