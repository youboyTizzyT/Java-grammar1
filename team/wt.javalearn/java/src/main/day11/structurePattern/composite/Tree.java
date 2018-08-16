package day11.structurePattern.composite;

public class Tree {
    TreeNode root=null;
    public Tree (String name){
        root=new TreeNode(name);
    }

    public static void main(String[] args) {
        //将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
        Tree tree=new Tree("A");
        TreeNode nodeB=new TreeNode("B");
        TreeNode nodeC=new TreeNode("C");
        nodeB.add(nodeC);
        tree.root.add(nodeB);
        while (tree.root.getChildren().hasMoreElements()){
            System.out.println(tree.root.getChildren().nextElement().toString());
        }
    }
}
