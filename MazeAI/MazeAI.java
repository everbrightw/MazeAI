

public class MazeAI{
    public static void main(String args[]){
       	Utilities.fileReader();
        // MazeMap mazemap = new MazeMap(10,10);
        // mazemap[0][0] = 'c';
        System.out.println("Node at 0,0  " + MazeMap.getNode(60,22).value);
        System.out.println("Node at 1,1" + MazeMap.getNode(0,0).up_child.right_child.value);

    }
}