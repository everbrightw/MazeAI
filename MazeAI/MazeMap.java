import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MazeMap {
    public static List<Node> curr_map = new ArrayList<Node>();//Todo: node
    public static int width;

    public static Node startNode;//the start position

    public static Node destination;//the ending position

    public static HashMap<Node, Node> trace = new HashMap<Node, Node>();


    public static void printMap() {
        for (int i = 0; i < curr_map.size(); i++) {
            System.out.print(curr_map.get(i).value);
            if ((i + 1) % width == 0) {
                System.out.println();
            }
        }
    }

    public static Node getNode(int x, int y) {
        return curr_map.get(width * y + x);
    }

    public static void setWalls() {

        for (int i = 0; i < curr_map.size(); i++) {
            int flag = 0;
            Node curr_node = curr_map.get(i);
            if (curr_node.left_child != null) {
                if (curr_node.left_child.value == '%') {
                    curr_node.left_child = null;
                    flag++;
                } else {
                    curr_node.neighbor.add(curr_node.left_child);
                }
            }

            if (curr_node.right_child != null) {
                if (curr_node.right_child.value == '%') {
                    curr_node.right_child = null;
                    flag++;
                } else {
                    curr_node.neighbor.add(curr_node.right_child);
                }
            }

            if (curr_node.down_child != null) {
                if (curr_node.down_child.value == '%') {
                    curr_node.down_child = null;
                    flag++;
                } else {
                    curr_node.neighbor.add(curr_node.down_child);
                }
            }

            if (curr_node.up_child != null) {
                if (curr_node.up_child.value == '%') {
                    curr_node.up_child = null;
                    flag++;
                } else {
                    curr_node.neighbor.add(curr_node.up_child);
                }
            }

            if (flag >= 3 && curr_node.value != '.') {
                curr_node.isBlocked = true;
            }
        }

    }
}
