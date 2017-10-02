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
    final String OPEN_MAZE = "openmaze.txt";

    //mutli dots

    final String M_TINY_MAZE = "m_tinymaze.txt";
    final String M_SMALL_MAZE = "m_smallmaze.txt";
    final String M_MEDIUM_MAZE = "m_mediummaze.txt";


    BufferedReader reader = null;
    BufferedReader next_reader = null;
    try {
        File file = new File(M_TINY_MAZE);
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

                maze_map.add(new Node(column, row, line.charAt(column)));//add every single node of char to the MazeMap
                Node curr_node = MazeMap.getNode(column, row);

                if (MazeMap.getNode(column, row).value == 'P'){
                    MazeMap.startNode = curr_node;
                    MST.vertices.add(MazeMap.startNode);
                }
                if (MazeMap.getNode(column, row).value == '.'){
                    MazeMap.destination = curr_node;
                    MultiDots.destinations.add(curr_node);
                    MST.vertices.add(curr_node);
                }

                if(column == 0){MazeMap.getNode(column, row).left_child = null;} //left most
                else{
                    MazeMap.getNode(column, row).left_child =
                    MazeMap.getNode(column-1, row);
                    MazeMap.getNode(column-1, row).right_child = MazeMap.getNode(column, row);

                }
                //y cases
                if(row == 0){MazeMap.getNode(column, row).up_child = null;} // up most
                else{
                    MazeMap.getNode(column, row).up_child = MazeMap.getNode(column, row-1);
                    MazeMap.getNode(column, row-1).down_child = MazeMap.getNode(column, row);
                }
                int position = (row * MazeMap.width + column);
                // System.out.println("row: "+ row + " column: " + column + " position: " + position);
            }
            row++;
        }

        MazeMap.setWalls();//set walls and node blocked attribute




        // System.out.println("width" + MazeMap.width);
        // System.out.println("column" + column);

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

  // public static List<Node> findTest(Node startNode, List<Node> visited){
  //    // int step =  0;
  //    Stack<Node> s = new Stack<>();
  //    Node curr_node = new Node();
  //    curr_node = startNode;
  //    s.push(curr_node);
  //    while(!s.isEmpty()){
  //        curr_node = s.peek();
  //        s.pop();
  //        for (int i = 0; i < curr_node.neighbor.size(); i ++) {
  //            if(curr_node.neighbor[i].isVisited){
  //                s.push(curr_node.neighbor[i]);
  //            }
  //        }
  //    }

  // }

}
