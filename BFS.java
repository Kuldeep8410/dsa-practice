
import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    public static Tree search(int value, Tree root) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(root); // first we add the root node as the
        // only member of the queue

        while(!queue.isEmpty()) {

            System.out.print("Current queue: ");
            for (Tree item: queue) {
                System.out.print(item.getValue() + " ");
            }
            System.out.println();

            Tree currentNode = queue.remove(); // we remove the first node in queue
            // and save it as currentNode
            
            // check for "win" condition
            if (currentNode.getValue() == value) {
                System.out.println("Finished searching!");
                return currentNode;
            }
            // if we did not find the value we are looking for..
            // add all children to the queue in order
            else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Tree root = new Tree(10); // root
        Tree newChild = root.addChild(5); // root first child
        root.addChild(7); // root second child
        root.addChild(15); // root third child
        Tree newChildChild = newChild.addChild(115); // root first child -> child
        Tree newChildChildChild = newChildChild.addChild(207); // root first child -> child -> child
        Tree newChildChildChildChild = newChildChild.addChild(500);

        Tree foundNode = search(500, root); // BFS search

        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }
    }
}