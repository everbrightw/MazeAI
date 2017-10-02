import java.util.List;
import java.util.*;


class Path {

    public static void findPath(){
        Node end = MazeMap.destination;
        while(end != MazeMap.startNode){
            Node parent = MazeMap.trace.get(end);
           	parent.value = '.';
            end = parent;
        }
        MazeMap.startNode.value = 'P';
    }
    
}