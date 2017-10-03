
public class MazeAI {

    public static void main(String args[]) {
        long startTime = System.nanoTime();

        //initialize nodes and read maze from txt file
        Utilities.fileReader();
        
        // MazeMap.printMap();

        // test for AStar
        // AStar.as();
        // MazeMap.printMap();
        // System.out.println("Path Cost:  " + AStar.getDistance(MazeMap.startNode, MazeMap.destination)); 
        // System.out.println("Expanded Node: " + AStar.expandedNode);

        // test for bfs
        // BFS bfs = new BFS();
        // bfs.runBfs(MazeMap.startNode);
        // Path.findPath(bfs.trace);
        // MazeMap.printMap();
        // System.out.println("Expanded Node: " + bfs.visited.size());
        // System.out.println("Path Cost: " + Path.pathCost);

        //part 1.2

        MazeMap.printMap();


        MST.setEdges();
        MST.addNodes();
        MST.findMST();

        int mutliCost = 0;
        for (Edge it_edge : MST.path) {
            System.out.println(it_edge.weight);
            System.out.println("startnode" + it_edge.beginNode.value);
            System.out.println("endNode" + it_edge.endNode.value);
            mutliCost += it_edge.weight;
        }

        MazeMap.printMap();
        for (Edge it_edge : MST.path) {
            System.out.println("startNode x : " + it_edge.beginNode.x + " startNode y : " + it_edge.beginNode.y);
              System.out.println("endNode x : " + it_edge.endNode.x + " endNode y : " + it_edge.endNode.y);
              System.out.println();
        }

        Path.ordering();
        MazeMap.printMap();
        System.out.println("expanded node: " + AStar.expandedNode);
        System.out.println("path cost: " + mutliCost);



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
