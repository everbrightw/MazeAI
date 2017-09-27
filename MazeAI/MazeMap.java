import java.util.List;
import java.util.ArrayList;

class MazeMap{
	public List<Character> curr_map;
	public int width;
	
	MazeMap(){
		curr_map = new ArrayList<Character>();
	}

	public void initializeMap(String line){
	    for(int i = 0; i < line.length(); i++){
	     	this.curr_map.add(line.charAt(i));
	    }
	}

	public void printMap(){
		for (int i = 0; i < curr_map.size(); i++) {
			System.out.print(curr_map.get(i));
			if((i+1) % width == 0){
				System.out.println();
			}
		}
		System.out.println("finish");
	}
}
