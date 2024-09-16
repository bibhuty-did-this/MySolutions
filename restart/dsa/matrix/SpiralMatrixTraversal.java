package restart.dsa.matrix;

import javax.swing.*;

public class SpiralMatrixTraversal {
    public void spiralTraversal(int[][] matrix, int leftCol, int rightCol, int topRow, int bottomRow){
        if (leftCol>rightCol || topRow>bottomRow) return;
        if(leftCol==rightCol && topRow==bottomRow && leftCol==topRow){
            System.out.println(matrix[topRow][leftCol]);
        }
        for(int col=leftCol;col<rightCol;++col){
            System.out.println(matrix[topRow][col]);
        }
        for(int row=topRow;row<bottomRow;++row){
            System.out.println(matrix[rightCol][row]);
        }
        for(int col=rightCol;col>leftCol;--col){
            System.out.println(matrix[bottomRow][col]);
        }
        for(int row=bottomRow;row>topRow;--row){
            System.out.println(matrix[row][leftCol]);
        }
        spiralTraversal(matrix, leftCol+1, rightCol-1, topRow+1, bottomRow-1);
    }

    public static void main(String[] args) {
        var matrixTraversal=new SpiralMatrixTraversal();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrixTraversal.spiralTraversal(matrix,0,2,0,2);
    }
}
