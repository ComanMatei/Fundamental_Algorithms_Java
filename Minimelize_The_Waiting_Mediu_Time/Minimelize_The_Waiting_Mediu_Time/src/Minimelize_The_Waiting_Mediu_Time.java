import java.util.Scanner;

public class Minimelize_The_Waiting_Mediu_Time {

	static int t[];
	static void quickSort(int f,int l) {
		if(f<l) {
			int m=partitioning(f,l);
			quickSort(f,m-1);
			quickSort(m+1,l);
		}
	}
	
	static int partitioning(int f,int l) {
		int pivot=t[l];
		int i=f;
		int aux;
		for(int j=f;j<l;j++) {
			if(t[j]<pivot) {
				aux=t[j];
				t[j]=t[i];
				t[i]=aux;
				i++;
			}
		}
		aux=t[l];
		t[l]=t[i];
		t[i]=aux;
		return i;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("The number for clients is:");
		int n=sc.nextInt();
		t=new int [n];
		for(int i=0;i<n;i++)
			t[i]=sc.nextInt();
		quickSort(0,n-1);
		int Tt=0;
		for(int i=0;i<n;i++) {
			System.out.println("The client with time: "+t[i]);
			Tt=Tt+((n-i)*t[i]);
		}
		System.out.println(((float)Tt)/n);
	}
}
