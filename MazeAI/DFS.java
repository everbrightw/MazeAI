import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class DFS {
  public static List<Node> visited = new ArrayList<Node>();

  public static Node doDFS(Node startNode){

     Node curr;
     Stack<Node> s = new Stack<>();
     s.push(startNode);
    
     while(!s.empty()){
       curr = s.peek();
       visited.add(curr);
       curr.isVisited = true;
       s.pop();
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
 
     return null;
  }
}
