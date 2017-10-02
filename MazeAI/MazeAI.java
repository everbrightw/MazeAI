import java.util.List;
import java.util.ArrayList;


public class MazeAI{
    public static void main(String args[]){
    	long startTime = System.nanoTime();
       	Utilities.fileReader();

        // MazeMap mazemap = new MazeMap(10,10);
        // mazemap[0][0] = 'c';
        // System.out.println("Node at 0,0  " + MazeMap.getNode(60,22).value);
        // System.out.println("Node at 1,1" + MazeMap.getNode(0,0).down_child.right_child.value);
        // System.out.println("Node at 32,12" + MazeMap.getNode(31,11).down_child.right_child.value);

        // System.out.println("node at  is blocked?" + MazeMap.getNode(59,21).isBlocked);
        // Node test = AStar.as();
        // System.out.println("destination: " + test.x + "  "+ test.y + "value:"+ test.value);

//
//        	System.out.println("node at  is blocked?" + MazeMap.getNode(59,21).isBlocked);
//        Node test = AStar.as();
//        System.out.println("destination: " + test.x + "  "+ test.y + "value:"+ test.value);

        // System.out.println("parent: " + test.parent.x + " y: "+ test.parent.y + "value:"+ test.value);


        MazeMap.printMap();
        AStar.mutiAs().setOrder(0);
        for (Node it_node : MultiDots.destinations) {
            System.out.println(it_node.value);
        }

        // test for AStar
        // AStar.as();

        // MazeMap.printMap();

        // test for dfs
        // Node test = DFS.doDFS(MazeMap.startNode);
        // System.out.println("destination" + test.value + "   " + "x :" + test.x + "y: " + test.y);
        // // for(int i = 0; i<DFS.visited.size() ; i ++){
        // // 	DFS.visited.get(i).value = '.';
        // // }

        // MazeMap.printMap();

        // test for greedy

        // Node testGreedy = Greedy.greedySearch(MazeMap.startNode);
       	// Path.findPath();
        // MazeMap.printMap();

//        Node testGreedy = Greedy.greedySearch(MazeMap.startNode);
//       	Path.findPath();

        // test for bfs
        // BFS bfs = new BFS();
        // Node test = bfs.runBfs(MazeMap.startNode);
        // // System.out.println("destination" + test.value + "   " + "x :" + test.x + "y: " + test.y);
        // long count = 0;
        // for(int i = 0; i<bfs.visited.size() ; i ++){
        //     bfs.visited.get(i).value = '+';
        //     count ++;

        // }
        // Path.findPath(bfs.trace);
        // MazeMap.printMap();


        // Node testPath = Path.findShortestPath(MazeMap.startNode);

        //part 1.2

        MazeMap.printMap();
        long endTime = System.nanoTime();
        long deltaTime = endTime - startTime;
        System.out.println("Elapsed time (ms): " + deltaTime / 1000000 + "ms");

    }
}
