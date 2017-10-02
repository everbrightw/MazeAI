
public class MazeAI {

    public static void main(String args[]) {
        long startTime = System.nanoTime();
        Utilities.fileReader();
        MazeMap.printMap();
        // test for AStar
        // AStar.as();
        // MazeMap.printMap();
        // System.out.println("Expanded Node : " + 
        // System.out.println("Expanded Node: " + AStar.expandedNode);

        // test for bfs
        // BFS bfs = new BFS();
        // bfs.runBfs(MazeMap.startNode);
        // Path.findPath(bfs.trace);
        // MazeMap.printMap();
        // System.out.println("Expanded Node: " + bfs.visited.size());
        // System.out.println("Path Cost: " + Path.pathCost);


        // test for dfs
        // Node test = DFS.doDFS(MazeMap.startNode);
        // // Path.findPath(DFS.trace);
        // MazeMap.printMap();
        // System.out.println("Expanded Node: " + DFS.visited.size());
        // System.out.println("Path Cost: " + DFS.pathCost);
   

        // test for greedy
        // Node testGreedy = Greedy.greedySearch(MazeMap.startNode);
        // Path.findPath(MazeMap.trace);
        //  MazeMap.printMap();
        // System.out.println("Expanded Node: " + Path.visited);
        // System.out.println("Path Cost: " + Path.pathCost);
       
        long endTime = System.nanoTime();
        long deltaTime = endTime - startTime;
        System.out.println("Time (ms): " + deltaTime / 1000000 + "ms");

    }
}
