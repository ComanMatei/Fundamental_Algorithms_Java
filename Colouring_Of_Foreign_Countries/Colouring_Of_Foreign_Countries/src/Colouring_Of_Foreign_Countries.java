import java.util.Scanner;

public class Colouring_Of_Foreign_Countries {

	static int[]x;
	static int[][]v;
	static String[]colours;
	static int n,m;
	
	public static void backtracking() {
		for(int i=0;i<n;i++)
		    x[i]=-1;
		int k=0;
		while(k>=0) 
			if(k==n) {
				retainSol();
				k--;
			}
			else {
				if(x[k]<m-1) {
				   x[k]++;
				   if(continuing(k))
					  k++;
				}
				else 
					x[k--]=-1;
			}
	}
	
	public static boolean continuing(int k) {
		for(int i=0;i<k;i++)
			if( (v[i][k]==1) && (x[i]==x[k]))
				return false;
		return true;
	}
	
	public static void retainSol() {
		System.out.println();
		for(int i=0;i<m;i++)
		    System.out.println("Country " + i + " with " + colours[x[i]]);
	}
	
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("The number of elemts for matrix is "); 
		n=sc.nextInt();
		System.out.print("The number of colours is ");
		m=sc.nextInt();
		x=new int[n];
		v=new int[n][n];
		colours=new String[m];
		System.out.println("Enter the neighborhood matrix: ");
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				v[i][j]=sc.nextInt();
		System.out.println("Enter the colours: ");
		for(int i=0; i<m; i++)
			colours[i]=sc.next();
		backtracking();
		sc.close();
	}
}
