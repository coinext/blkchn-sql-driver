package com.impetus.blkch.sql.parser;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TreeNode{
	
	private static final Logger logger = LoggerFactory.getLogger(TreeNode.class);
	
	private List<TreeNode> childNodes = new ArrayList<TreeNode>();
	private TreeNode parent = null;
	private boolean isRootNode = false;
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreeNode(String description){
		this.description = description;
	}
	
	public void addChildNode(TreeNode child){
		this.childNodes.add(child);
		child.setParent(this);
	}
	
	public TreeNode getChildNode(int i) {
		if(i < childNodes.size()){
			return childNodes.get(i);
		}
		return null;
	}
	
	public List<TreeNode> getChildNodes() {
		return childNodes;
	}
	
	public void setChildNodes(List<TreeNode> childNodes) {
		this.childNodes = childNodes;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public boolean isRootNode() {
		return isRootNode;
	}
	
	public void setRootNode(boolean isRootNode) {
		this.isRootNode = isRootNode;
	}
	
	public void traverse(TreeNode node){
		traverseDepthFirst(node, 0);
	}
	
	public void traverse(){
		traverseDepthFirst(this, 0);
	}
	
	private void traverseDepthFirst(TreeNode node, int level){
		logger.debug(addspace(level * 2, node.getDescription()));
		for(TreeNode childNode : node.getChildNodes()){
			traverseDepthFirst(childNode, level + 1);
		}
	}
	
	public String toString(){
		return this.getDescription();
	}
	
	private String addspace(int i, String str) {       
        StringBuilder str1 = new StringBuilder();
        for(int j=0;j<i;j++){
                str1.append(" ");
            }
            str1.append(str);           
        return str1.toString();         
    }
}
