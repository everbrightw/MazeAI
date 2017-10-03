import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


class Path {
	public static int visited = 0;
	public static int pathCost = 0;
    public static void findPath(HashMap<Node, Node> trace) {
        Node end = MazeMap.destination;
        while (end != MazeMap.startNode) {
            Node parent = trace.get(end);

            if(parent.value != 'P' && end.value != 'P'){

           	    parent.value = '.';
                end.value = '.';
                
          }
            pathCost++;
            end = parent;
        }        // MazeMap.startNode.value = 'P';
    }


    //order the edges from startNode, until all of the edges have already been used
    public static void ordering(){
      Node firststep = null;
      List<Node> visited = new ArrayList<Node>();

      for(int i = 0; i < MST.path.size(); i++){
        if(MST.path.get(i).beginNode.value == 'P' || MST.path.get(i).endNode.value == 'P'){
          if(MST.path.get(i).beginNode.value == 'P'){
            visited.add(MST.path.get(i).beginNode);
            MST.path.get(i).endNode.value = 'a';
            firststep = MST.path.get(i).endNode;
            break;
          }
         else{
           visited.add(MST.path.get(i).endNode);
            MST.path.get(i).beginNode.value = 'a';
            firststep = MST.path.get(i).beginNode;
            break;
          }
        }
      }
      int count = 1;
      char order = 'a';
      big: while(firststep != null && !visited.contains(firststep)){
         //System.out.println("HERE 40");
         //System.out.println("firststep value :" + firststep.value);

        for(int i = 0; i < MST.path.size(); i++){
          //since we don't care about the order of beginNode and endNode when building MST,
          //we should consider that every Node has equal possibility that being beginNode and endNode
            if(MST.path.get(i).beginNode.equals(firststep) || MST.path.get(i).endNode.equals(firststep)){
              //System.out.println("current path endNode " + MST.path.get(i).endNode.value);
              //System.out.println("contains? " + visited.contains(MST.path.get(i).endNode));
              visited.add(firststep);
             if((MST.path.get(i).beginNode.equals(firststep)) && (!visited.contains(MST.path.get(i).endNode))){
              //System.out.println("HERE 52");
              order = (char)((int)order + 1);
              MST.path.get(i).endNode.value = order;
              firststep = MST.path.get(i).endNode;

            }
            if((MST.path.get(i).endNode.equals(firststep)) && (!visited.contains(MST.path.get(i).beginNode))){
              //System.out.println("HERE 58");
             order = (char)((int)order + 1);
              MST.path.get(i).beginNode.value = order;
              firststep = MST.path.get(i).beginNode;

            }
          }
          }
        }
      }
}
