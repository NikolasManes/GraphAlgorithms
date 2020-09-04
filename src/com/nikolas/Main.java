package com.nikolas;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Graph graph = new Graph();
        intro();
        createGraph(graph);
        graph.printGraph();
        runAlgorithm(graph);
    }

    private static void createGraph(Graph graph) {
        int numberOfNodes = 0;
        String pathEntry;
        // Create Graph
        System.out.println("Creating Graph...");
        System.out.println("Enter the number of nodes the graph has: ");
        while (numberOfNodes == 0){
            try {
                numberOfNodes = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer!");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        for (int i=0; i<numberOfNodes; i++){
            Node node = new Node(i);
            graph.addNode(node);
        }
        System.out.println("Now enter the paths the graph has...\n" +
                "*  3 integers represent each path:\n" +
                "\t- first one is the start node id\n" +
                "\t- second is the end node id\n" +
                "\t- last one is the weight" +
                "\n** Enter the paths like the following format \"s-e-w\", when you finish type \"end\"");
        pathEntry = scanner.nextLine();
        while (!pathEntry.equals("end")){
            String[] pathParams = pathEntry.split("-");
            try {
                Node start = graph.getSingleNode(parseInt(pathParams[0]));
                Node end = graph.getSingleNode(parseInt(pathParams[1]));
                int weight = parseInt(pathParams[2]);
                Path path = new Path(start, end, weight);
                graph.addPath(path);
            } catch (NodeNotInGraphException e) {
                System.out.println(e.getMessage());
                pathEntry = scanner.nextLine();
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Not valid format... Use s-e-w format or type \"end\" if you finished!");
                pathEntry = scanner.nextLine();
                continue;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Not valid format... Use s-e-w format or type \"end\" if you finished!");
                pathEntry = scanner.nextLine();
                continue;
            }
            pathEntry = scanner.nextLine();
        }
    }

    private static void runAlgorithm(Graph graph) {
        String choiceText;
        int choice = 0;
        System.out.println("Algorithms to run: \n");
        System.out.println("\t1-Breadth First Search");
        System.out.println("\t2-Depth First Search");
        System.out.println("\t3-Prim’s Minimum Spanning Tree");
        System.out.println("\t4-Dijkstra’s Shortest Path Algorithm\n");
        System.out.println("Enter your choice:");

        choiceText = scanner.nextLine();
        // Get User Choice
        while (choice == 0){
            try {
                choice = parseInt(choiceText);
            } catch (NumberFormatException e) {
                System.out.println("Not valid... Enter an integer from 1 to 4!");
                choiceText = scanner.nextLine();
            }
        }
        switch (choice){
            case 1:
                runBFS(graph);
                break;
            case 2:
                runDFS(graph);
                break;
            case 3:
                runPrim(graph);
                break;
            case 4:
                runDijkstra(graph);
                break;
        }
    }

    public static void runBFS(Graph graph){
        System.out.println("Not implemented yet!");
    }

    public static void runDFS(Graph graph){
        System.out.println("Not implemented yet!");
    }

    public static void runPrim(Graph graph){
        System.out.println("Not implemented yet!");
    }

    public static void runDijkstra(Graph graph) {
        // Declare a list to store the routes
        List<Route> routes = new ArrayList<>();
        // Now add all the others the weight is MAX
        for (Node node: graph.getNodes()){
            Route dummy = new Route(node, node, new ArrayList<>());
            routes.add(dummy);
        }
        // Set the first route for the first node weight is 0
        // - all others had been set to MAX-int value
        routes.get(0).setTotalWeight(0);
        // Declare a list to store the best routes
        List<Route> bestRoutes = new ArrayList<>();
        // Run Dijkstra
        int step = 0;
        while(bestRoutes.size()<graph.getNodeNumber()){
            step++;
            int pathCount = 0;
            System.out.println("\n ---- STEP: " + step + " ----\n");
            /* Get the shortest route of all to stabilize it */
            // Declare a route to store the temporary value
            Route shortestRoute;
            // Sort the routes according their weight
            routes.sort(Comparator.comparingInt(Route::getTotalWeight));
            // Remove the shortest route and add it to bestRoutes
            shortestRoute = routes.remove(0);
            bestRoutes.add(shortestRoute);
            System.out.println("The shortest route: ");
            shortestRoute.printRoute();
            // Find all paths starting from the end of that route
            for (Path path: graph.getPaths()){
                if (shortestRoute.getEndPoint().getId() == path.getStart().getId()){
                    pathCount++;
                    System.out.println("*** The " + pathCount + " path starting from the end of that route:");
                    path.printPath();
                    // For every path we find check if there is a shorter route to the Node
                    for (Route route: routes){
                        if(route.getEndPoint().getId() == path.getEnd().getId()){
                            System.out.println("* Route with the same end as the path: ");
                            route.printRoute();
                            // Check if there is a shortest way to go to that node(end)
                            if(route.getTotalWeight() > shortestRoute.getTotalWeight() + path.getWeight()){
                                // Create a dummy route to store the route
                                Route dummyRoute = new Route(shortestRoute.getStartPoint(), path.getEnd(), new ArrayList<>());
                                for(Path p: shortestRoute.getPaths()){
                                    dummyRoute.addPath(p);
                                }
                                dummyRoute.addPath(path);
                                dummyRoute.calcTotalWeight();
                                routes.set(routes.indexOf(route), dummyRoute);
                                System.out.println("<<<New Route>>>");
                                route.printRoute();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\n\n!!!!! THE SHORTEST ROUTES !!!!!\n");
        for(Route r : bestRoutes){
            r.printRoute();
        }
    }

    public static void intro(){
        System.out.println("\t ________________________________");
        System.out.println("\t|                                |");
        System.out.println("\t|        GRAPH ALGORITHMS        |");
        System.out.println("\t|________________________________|\n");
    }
}
