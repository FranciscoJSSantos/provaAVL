/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package AvlTree;
import AvlTree.AVLTree;

public class App {
    public static void main(String[] args) {
        
        AVLTree tree = new AVLTree();
        
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);


       
        System.out.println("===");
        
        tree.show();  
        
    }
}
