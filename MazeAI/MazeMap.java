import java.util.List;
import java.util.ArrayList;

class MazeMap{
	public List<Node> curr_map;//Todo: node
	public int width;
	
	MazeMap(){
		curr_map = new ArrayList<Node>();
	}

	// public void initializeMap(int x, int y, String line){
	//     for(int i = 0; i < line.length(); i++){
	//      	this.curr_map.add(new Node(x, y, line.charAt));
	//     }
	// }

	public void printMap(){
		for (int i = 0; i < curr_map.size(); i++) {
			System.out.print(curr_map.get(i).value);
			if((i+1) % width == 0){
				System.out.println();
			}
		}
		System.out.println("finish");
	}
}
