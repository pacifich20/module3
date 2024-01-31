package com.pacifich20.module3.v3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    private static final Queue<Integer> visitingQueue = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    /**
     * performs BFS traversal on a graph
     * starts from first node uses queue for exploration
     */
    private static void BFS() {
        if (visitingQueue.isEmpty()) {
            Node root = (graph.isEmpty()) ? null : graph.get(0);
            if (root == null || root.isVisited()) {
                System.out.println("Traversal finished");
                return;
            } else {
                visitingQueue.add(root.getKey());
            }
        }

        Integer currentKey = visitingQueue.poll();
        if (currentKey == null) {
            System.out.println("Current node is null");
            return;
        }

        Node currentNode = graph.get(currentKey - 1);
        currentNode.setVisited(true);

        for (Integer nodeId : currentNode.getNodes()) {
            if (visitingQueue.contains(nodeId) || graph.get(nodeId - 1).isVisited()) {
                continue;
            }
            visitingQueue.add(nodeId);
        }

        System.out.println("Queue: " + visitingQueue);
        BFS();
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("C:\\Users\\Pdog\\IdeaProjects\\module3\\src\\com\\pacifich20\\module3\\v3\\tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
