import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


class Utilities{
  public static void fileReader(){
  	final String BIG_MAZE = "BigMAze.txt";
  	final String MEDIUM_MAZE = "MediumMaze.txt";
  	final String OPEN_MAZE = "OpenMaze.txt";

  	BufferedReader reader = null;
	try {
	    File file = new File(BIG_MAZE);
	    reader = new BufferedReader(new FileReader(file));

	    String line;

	    MazeMap mazemap = new MazeMap();
	   	
	    int line_times = 0;
	    int column = 0;
	 	while ((line = reader.readLine()) != null) {
	        // System.out.println(line);
	        mazemap.width = line.length();
	        for (int i = 0; i < line.length(); i++ ) {
	        	//initialize the board;
	        	mazemap.curr_map.add(new Node(i, column, line.charAt(i)));
	        }
	        column ++;
	    }
	    mazemap.printMap();

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
