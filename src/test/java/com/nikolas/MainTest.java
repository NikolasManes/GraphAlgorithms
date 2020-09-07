package com.nikolas;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void runBFSTest() {
    }

    @Test
    void runDFSTest() {
    }

    @Test
    void runPrimTest() {
    }

    @Test
    void runDijkstraTest(){
        Graph graph = new Graph();
        int nodesNum = 7;
        List<Path> paths = new ArrayList<>();
        List<Route> bestRoutesMain;
        List<Route> bestRoutesTest = new ArrayList<>();
        /* Lets create the Graph... */
        // Set the Nodes and add them in the graph
        for(int i = 0; i< nodesNum; i++){
            Node node = new Node(i);
            graph.addNode(node);
        }
        // Now create the paths
        try {
            graph.addPath(new Path(graph.getSingleNode(0), graph.getSingleNode(1), 5));
            graph.addPath(new Path(graph.getSingleNode(0), graph.getSingleNode(2), 3));
            graph.addPath(new Path(graph.getSingleNode(1), graph.getSingleNode(4), 1));
            graph.addPath(new Path(graph.getSingleNode(1), graph.getSingleNode(5), 3));
            graph.addPath(new Path(graph.getSingleNode(1), graph.getSingleNode(2), 2));
            graph.addPath(new Path(graph.getSingleNode(2), graph.getSingleNode(5), 7));
            graph.addPath(new Path(graph.getSingleNode(2), graph.getSingleNode(3), 7));
            graph.addPath(new Path(graph.getSingleNode(3), graph.getSingleNode(0), 2));
            graph.addPath(new Path(graph.getSingleNode(3), graph.getSingleNode(6), 6));
            graph.addPath(new Path(graph.getSingleNode(4), graph.getSingleNode(5), 1));
            graph.addPath(new Path(graph.getSingleNode(5), graph.getSingleNode(3), 2));
            graph.addPath(new Path(graph.getSingleNode(5), graph.getSingleNode(6), 1));
        } catch (NodeNotInGraphException e) {
            e.printStackTrace();
        }
        graph.printGraph();
        bestRoutesMain = Main.runDijkstra(graph);
//        try {
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(0), paths));
//            paths.add(new Path(graph.getSingleNode(0), graph.getSingleNode(2), 3));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(2), paths));
//            paths.clear();
//            paths.add(new Path(graph.getSingleNode(0), graph.getSingleNode(1), 5));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(1), paths));
//            paths.add(new Path(graph.getSingleNode(1), graph.getSingleNode(4), 1));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(4), paths));
//            paths.add(new Path(graph.getSingleNode(4), graph.getSingleNode(5), 1));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(5), paths));
//            paths.add(new Path(graph.getSingleNode(5), graph.getSingleNode(6), 1));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(6), paths));
//            paths.clear();
//            paths.add(new Path(graph.getSingleNode(0), graph.getSingleNode(1), 5));
//            paths.add(new Path(graph.getSingleNode(1), graph.getSingleNode(4), 1));
//            paths.add(new Path(graph.getSingleNode(4), graph.getSingleNode(5), 1));
//            paths.add(new Path(graph.getSingleNode(5), graph.getSingleNode(3), 2));
//            bestRoutesTest.add(new Route(graph.getSingleNode(0), graph.getSingleNode(3), paths));
//        } catch (NodeNotInGraphException e) {
//            e.printStackTrace();
//        }
        for (Route route: bestRoutesMain){
            route.printRoute();
        }
        assertEquals(bestRoutesMain.size(), bestRoutesTest.size());

    }
}