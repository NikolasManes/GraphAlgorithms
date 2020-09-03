package com.nikolas;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> mNodes = new ArrayList<>();
    private ArrayList<Path> mPaths = new ArrayList<>();

    public Graph(){

    }
    public Graph(ArrayList<Node> nodes,ArrayList<Path> paths){
        this.mNodes = nodes;
        this.mPaths = paths;
    }

    public int getNodeNumber() {
        return mNodes.size();
    }

    public void addNode(Node node) {
        mNodes.add(node);
    }

    public int getPathNumber() {
        return mPaths.size();
    }

    public void addPath(Path path) {
        mPaths.add(path);
    }

    public ArrayList<Node> getNodes() {
        return mNodes;
    }

    public void setNodes(ArrayList mNodes) {
        this.mNodes = mNodes;
    }

    public ArrayList<Path> getPaths() {
        return mPaths;
    }

    public void setPaths(ArrayList<Path> mPaths) {
        this.mPaths = mPaths;
    }

    public boolean pathIsValid(Path path){
        return nodeInGraph(path.getStart()) && nodeInGraph(path.getEnd());
    }

    public boolean nodeInGraph(Node node){
        for (Node n : mNodes) {
            if(node.getId() == n.getId()) {
                return true;
            }
        }
        return false;
    }
}