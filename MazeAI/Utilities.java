import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Utilities{
  public static void fileReader(){
  	BufferedReader reader = null;

	try {
	    File file = new File("MediumMaze.txt");
	    reader = new BufferedReader(new FileReader(file));

	    String line;

	    MazeMap mazemap = new MazeMap(10,10);
	   	
	    int line_times = 0;
	 	while ((line = reader.readLine()) != null) {
	       	
	        mazemap.initializeMap(line, line_times);
	        line_times++;
	    }

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
