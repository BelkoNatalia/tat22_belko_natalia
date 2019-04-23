package fundamentals.optionalTasks.arrays;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int currentMatrix[][] = fillMatrix();

        for(int i = 0; i < currentMatrix.length; i++){
            for(int j = 0; j < currentMatrix[i].length; j++){
                System.out.print(currentMatrix[i][j] + "|");
            }
            System.out.println("");
        }

        int currentSumMatrix [] = getArrayOfRowSum(currentMatrix);

        for (int i = currentSumMatrix.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(currentSumMatrix[j] > currentSumMatrix[j + 1]){
                    int [] tempM = currentMatrix[j];
                    currentMatrix[j] = currentMatrix[j + 1];
                    currentMatrix[j + 1] = tempM;
                    int temp = currentSumMatrix[j];
                    currentSumMatrix[j] = currentSumMatrix[j + 1];
                    currentSumMatrix[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted Matrix");

        for(int i = 0; i < currentMatrix.length; i++){
            for(int j = 0; j < currentMatrix[i].length; j++){
                System.out.print(currentMatrix[i][j] + "|");
            }
            System.out.println("");
        }
    }

    private static int getMatrixDimention() {
        System.out.println("Enter matrix dimention");
        Scanner sc = new Scanner(System.in);
        int matrixDimention = sc.nextInt();
        return matrixDimention;
    }

    private static int [][] fillMatrix(){
        int matrixDimention = getMatrixDimention();
        int[][] matrix = new int[matrixDimention][matrixDimention];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = ((int)(Math.random() * (matrixDimention * 2 + 1) - matrixDimention));
            }
        }
        return matrix;
    }

    private static int calcSumRow(int[]row){
        int sum = 0;
        for(int i = 0; i < row.length; i++){
            sum = sum + row[i];
        }
        return sum;
    }

    private static int [] getArrayOfRowSum(int array[][]){
        int [] arrayOfRowSum = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            arrayOfRowSum[i] = calcSumRow(array[i]);
        }
        return arrayOfRowSum;
    }
}
