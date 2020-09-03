package com.nikolas;

public class Path {
    // The path connects 2 nodes - has direction and weight
    private Node mStart;
    private Node mEnd;
    private int mWeight;
    // Basic constructor
    public Path(Node start, Node end, int weight) {
        this.mStart = start;
        this.mEnd = end;
        this.mWeight = weight;
    }

    public Node getStart() {
        return mStart;
    }

    public Node getEnd() {
        return mEnd;
    }

    public int getWeight() {
        return mWeight;
    }

    public void printPath(){
        System.out.println("| START: " + this.getStart().getId() + " | END: " + this.getEnd().getId() + " | WEIGHT: " + this.getWeight() + " |");
    }
}
