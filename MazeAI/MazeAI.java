

public class MazeAI{
    public static void main(String args[]){
       	Utilities.fileReader();
        // MazeMap mazemap = new MazeMap(10,10);
        // mazemap[0][0] = 'c';
        System.out.println("Node at 0,0  " + MazeMap.getNode(60,22).value);
        // System.out.println("Node at 1,1" + MazeMap.getNode(0,0).down_child.right_child.value);
        // System.out.println("Node at 32,12" + MazeMap.getNode(31,11).down_child.right_child.value);
       
        	System.out.println("node at  is blocked?" + MazeMap.getNode(59,21).isBlocked);
        
    }
}
