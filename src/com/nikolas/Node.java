package com.nikolas;

public class Node {
    // Has only one attribute an ID
    private int mID;
    // Basic constructor the ID must be set at declaration
    public Node(int id) {
        this.mID = id;
    }
    // Getter for the ID
    public int getId() {
        return mID;
    }
}
