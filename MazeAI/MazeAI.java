

public class MazeAI{
    public static void main(String args[]){
    	long startTime = System.nanoTime();
       	Utilities.fileReader();
        // MazeMap mazemap = new MazeMap(10,10);
        // mazemap[0][0] = 'c';
        // System.out.println("Node at 0,0  " + MazeMap.getNode(60,22).value);
        // System.out.println("Node at 1,1" + MazeMap.getNode(0,0).down_child.right_child.value);
        // System.out.println("Node at 32,12" + MazeMap.getNode(31,11).down_child.right_child.value);
//
//        	System.out.println("node at  is blocked?" + MazeMap.getNode(59,21).isBlocked);
//        Node test = AStar.as();
//        System.out.println("destination: " + test.x + "  "+ test.y + "value:"+ test.value);
        // System.out.println("parent: " + test.parent.x + " y: "+ test.parent.y + "value:"+ test.value);
        MazeMap.printMap();
        AStar.as();
        MazeMap.printMap();


        //test for bfs
        // Node test = BFS.bfs(MazeMap.startNode);
        // System.out.println("destination" + test.value + "   " + "x :" + test.x + "y: " + test.y);
        // for(int i = 0; i<BFS.visited_array.size() ; i ++){
        // 	BFS.visited_array.get(i).value = '.';
        // }
        // MazeMap.printMap();
        long endTime = System.nanoTime();
        long deltaTime = endTime - startTime;
        System.out.println("Elapsed time (ms): " + deltaTime / 1000000 + "ms");

    }
}
