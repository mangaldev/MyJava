package uva;
import java.io.File;

import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main459 {
    Map<Integer, Queue<Integer>> adjList = new HashMap<Integer, Queue<Integer>>();
    int iV = 0;
    boolean[] marked;
    int iNumComponent = 0;
    static Scanner input;
    static int numberOfCases;


    public static void main(String[] args) throws FileNotFoundException {
        //                        input = new Scanner(new File("c://JDeveloper//abc.txt"));
        input = new Scanner(System.in);

        while (!input.hasNextInt())
            input.next();
        numberOfCases = input.nextInt();
        input.nextLine();
        input.nextLine();
        for (int i = 0; i < numberOfCases; i++) {
            Main459 cc = new Main459();
            cc.takeInput();
            cc.findNumberOfComponent(cc);
            if (i == numberOfCases - 1)
                System.out.println(cc.iNumComponent);
            else {
                System.out.println(cc.iNumComponent);
                System.out.println();
            }

        }
        input.close();
        System.exit(0);
    }

    void applyDFS(int source) {
        Queue<Integer> list = adjList.get(source);
        for (int adj : list) {
            if (!marked[adj]) {
                marked[adj] = true;
                applyDFS(adj);
            }
        }
    }

    void takeInput() {
        adjList.clear();
        char largeNode = input.nextLine().charAt(0);
        iV = largeNode - 65 + 1;
        marked = new boolean[iV];
        for (int i = 0; i < iV; i++) {
            marked[i] = false;
            adjList.put(i, new LinkedList<Integer>());
        }
        String edge = input.nextLine();
        while (edge != null && !edge.equals("")) {
            int firstNode = edge.charAt(0) - 65;
            int secondNode = edge.charAt(1) - 65;
            adjList.get(firstNode).add(secondNode);
            adjList.get(secondNode).add(firstNode);
            if (input.hasNextLine())
                edge = input.nextLine();
            else
                break;

        }
    }


    void findNumberOfComponent(Main459 cc) {

        for (int i = 0; i < iV; i++) {

            if (!marked[i]) {
                iNumComponent++;
                marked[i] = true;
                cc.applyDFS(i);
            }

        }
    }
}
