package day11.structurePattern.composite;

import java.util.Enumeration;
import java.util.Vector;

public class TreeNode {
    private TreeNode node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children=new Vector<>();

    public TreeNode(String name){
        this.name=name;
    }

    public void add(TreeNode node){
        children.add(node);
    }
    public void remove(TreeNode node){
        children.remove(node);
    }

    //取得孩子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
