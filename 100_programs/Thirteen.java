import java.util.*;

// MULTIPLICATION OF 2 MATRIX
public class Thirteen{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter dimension for matrix 1 : ");
		System.out.print("X: ");
		int mat1x = sc.nextInt();
		System.out.print("Y: ");
		int mat1y = sc.nextInt();

		System.out.println("Enter dimension for matrix 2 : ");
		System.out.print("X: ");
		int mat2x = sc.nextInt();
		System.out.print("Y: ");
		int mat2y = sc.nextInt();

		if(mat1y != mat2x){
			System.out.println("Invalid dimension");
			return;
		}

		int[][] mat1 = new int[mat1x][mat1y];
		int[][] mat2 = new int[mat2x][mat2y];

		System.out.println("\nEnter matrix 1 input: ");
		for(int i=0 ; i<mat1x ; i++){
			for(int j=0 ; j<mat1y ; j++){
				System.out.print("Enter element ["+(i+1)+","+(j+1)+"]: ");
				mat1[i][j] = sc.nextInt();
			}
		}

		System.out.println("Enter matrix 2 input: ");
		for(int i=0 ; i<mat2x ; i++){
			for(int j=0 ; j<mat2y ; j++){
				System.out.print("Enter element ["+(i+1)+","+(j+1)+"]: ");
				mat2[i][j] = sc.nextInt();
			}
		}

		int[][] ans = new int[mat1x][mat2y];

		for(int i=0 ; i<mat1x ; i++){
			for(int j=0 ; j<mat2y ; j++){
				int sum = 0;
				for(int k=0 ; k<mat1y ; k++){		// OR k<mat2X
					sum += mat1[i][k]*mat2[k][j];
				}
				ans[i][j] = sum;
			}
		}

		System.out.println("\nANSWER MATRIX: ");
		for(int i=0 ; i<ans.length ; i++){
			for(int j=0 ; j<ans[0].length ; j++){
				System.out.print(ans[i][j]+"\t");
			}
			System.out.println();
		}
	}
}