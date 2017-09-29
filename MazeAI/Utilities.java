import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Utilities{
  public static void fileReader(){
  	final String BIG_MAZE = "BigMAze.txt";
  	final String MEDIUM_MAZE = "MediumMaze.txt";
  	final String OPEN_MAZE = "OpenMaze.txt";

  	BufferedReader reader = null;
  	BufferedReader next_reader = null;
	try {
	    File file = new File(MEDIUM_MAZE);
	    reader = new BufferedReader(new FileReader(file));

	    String line;
	    int line_times = 0;
      int row = 0;
      int column = 0;
	    List<Node> maze_map = MazeMap.curr_map;

	    //detector for next line equals null

	 	while ((line = reader.readLine()) != null) {
	        // System.out.println(line);
	        MazeMap.width = line.length();
	        for (column = 0; column < line.length(); column++ ) {
	        	//initialize the board;
	        	maze_map.add(new Node(row, column, line.charAt(column)));//add every single node of char to the MazeMap


	        	if(column == 0){MazeMap.getNode(row, column).left_child = null;} //left most
	        	else{
	        		MazeMap.getNode(row, column).left_child =
	        		MazeMap.getNode(row, column-1);
	        		MazeMap.getNode(row, column-1).right_child = MazeMap.getNode(row, column);
	        	}
	        	//y cases
	        	if(row == 0){MazeMap.getNode(row, column).up_child = null;}
	        	else{
	        		MazeMap.getNode(row, column).up_child = MazeMap.getNode(row-1, column);
	        		MazeMap.getNode(row-1, column).down_child = MazeMap.getNode(row, column);
	        	}
	        	int position = (row * MazeMap.width + column);
	        	System.out.println("row: "+ row + " column: " + column + " position: " + position);
	        }
	        row++;
	    }
	    MazeMap.printMap(MazeMap.curr_map);
	    System.out.println("width" + MazeMap.width);
	    System.out.println("column" + column);

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
  }

  public static void transformation(String curr_maze){
    for (int i = 0;i< curr_maze.length() ; i++ ) {
        System.out.print(curr_maze.charAt(i));
    }
  }


}
