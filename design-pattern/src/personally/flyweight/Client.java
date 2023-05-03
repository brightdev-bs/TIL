package personally.flyweight;

import java.awt.*;

public class Client extends Tree {

    public static void main(String[] args) {
        TreeFactory treeFactory = new TreeFactory();
        Tree tree1 = new Tree(0, 1, treeFactory.getTreeTypes("자작나무", new Color(10, 10, 10)));
        Tree tree2 = new Tree(1, 2, treeFactory.getTreeTypes("자작나무", new Color(10, 10, 10)));
        Tree tree3 = new Tree(2, 3, treeFactory.getTreeTypes("자작나무", new Color(10, 10, 10)));

        System.out.println(tree1);
        System.out.println(tree2);
        System.out.println(tree3);
    }
}
