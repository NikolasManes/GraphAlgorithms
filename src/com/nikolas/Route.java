package com.nikolas;

import java.util.List;

public class Route{
    private Node mStartPoint;
    private Node mEndPoint;
    private List<Path> mPaths;
    private int mTotalWeight = Integer.MAX_VALUE;

    public Route(Node startPoint, Node endPoint, List<Path> paths) {
        this.mStartPoint = startPoint;
        this.mEndPoint = endPoint;
        this.mPaths = paths;
    }

    public Node getStartPoint() {
        return mStartPoint;
    }

    public Node getEndPoint() {
        return mEndPoint;
    }

    public List<Path> getPaths() {
        return mPaths;
    }

    public void addPathToRoute(Path path) throws PathCannotConnectToRouteException {
        if (this.mEndPoint.getId() == path.getStart().getId()){
            this.mPaths.add(path);
            this.mEndPoint = path.getEnd();
            this.calcTotalWeight();
        } else {
            throw new PathCannotConnectToRouteException("Route and Path cannot be connected!");
        }
    }

    public void printRoute(){
        System.out.println("-ROUTE:\n FROM: " + this.getStartPoint().getId() + "\tTO: "   + this.getEndPoint().getId());
        System.out.println(" TOTAL WEIGHT: " + this.getTotalWeight());
        System.out.println(" PATHS: ");
        if(mPaths.isEmpty()){
            System.out.println("Route is empty");
        }
        for (Path path: mPaths){
            path.printPath();
        }
        System.out.println("-----");
    }

    public void setTotalWeight(int totalWeight) {
        this.mTotalWeight = totalWeight;
    }

    public void calcTotalWeight(){
        int totalWeight = 0;
        for (Path path: mPaths){
            totalWeight = totalWeight + path.getWeight();
        }
        mTotalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return mTotalWeight;
    }
}

class PathCannotConnectToRouteException extends Exception{
    public PathCannotConnectToRouteException(String message){
        super(message);
    }
}
