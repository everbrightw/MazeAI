import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class DFS {
  public Node doDFS(Node startNode){
     long start = System.nanoTime();
     Node curr;
     Stack<Node> s = new Stack<>();
     s.push(startNode);
     List<Node> visited = new ArrayList<Node>();
     while(!s.empty()){
       curr = s.peek();
       visited.add(curr);
       //curr.value = '.';
       if(curr.value == '.'){
          return curr;
         }
       for(int i = 0; i < curr.neighbor.size(); i++){
         if(!curr.neighbor.get(i).isBlocked && !visited.contains(curr.neighbor.get(i))){
            s.push(curr.neighbor.get(i));
         }
       }
     }
     long end = System.nanoTime();
     long duration = end - start;
     System.out.println("Using: " + duration/1000000 + "ms");
     return null;
  }
}
