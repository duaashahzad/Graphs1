/*Directed or undirected: Write a program that takes a matrix of size n x n as input and
determines whether that matrix is the representation of a directed graph. */
import java.util.Scanner;

public class DirectedorUndirected {
    public static boolean isDirectedGraph(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] adjMatrix = {
                {1, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 1}
        };

        if (isDirectedGraph(adjMatrix)) {
            System.out.println("The graph is directed.");
        } else {
            System.out.println("The graph is undirected.");
        }

    }

}
