import java.util.Scanner;
public class Binning
{
public static void main(String[]args)
{
	int n;
	Binning b=new Binning();
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter data size:");
	n=scan.nextInt();
	int[] data=new int[n];
	System.out.println("Enter elements:");
	for(int i=0;i<n;i++)
	{
		data[i]=scan.nextInt();
	}
	 
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (data[j] > data[j+1])
                {
                    
                    int temp = data[j];
                    data[j] = data[j+1];
                }
	int width;
	
	System.out.println("Enter Width:");
	width=scan.nextInt();
	int res[][]=b.equiWidth(data,n,width);
	
	int div=n/width;
	int[][] r=new int[div][width];
	for(int i=0;i<div;i++)
	{
		for(int j=0;j<width;j++)
		{
			r[i][j]=res[i][j];
		}
	}
	int[][] res_boundary=b.equiBoundary(res,div,width);
	int[][] res_mean=b.equiMean(r,div,width);
}
public int[][] equiWidth(int[] data,int n,int width)
{
	
	int div=(int)((double)(n/width)+0.5);
	int k=0;
	int[][] b=new int[div][width];
	for(int i=0;i<div;i++)
	{
		for(int j=0;j<width;j++)
		{
			b[i][j]=data[k];
			k++;
		}
	}
	for(int i=0;i<div+div;i++)
	{	
		System.out.println("Elements in bin "+i);
		for(int j=0;j<width;j++)
		{
			System.out.println(" "+b[i][j]);

		}
		System.out.println("\n");
	}
	return b;
}
public int[][] equiBoundary(int[][] arr,int div,int width)
{
	for(int i=0;i<div;i++)
	{
		int lower=arr[i][0];
		int higher=arr[i][width-1];
		for(int j=1;j<width-1;j++)
		{
			if((Math.abs(lower-arr[i][j]))<(Math.abs(higher-arr[i][j])))
			{
				arr[i][j]=lower;
			}
			else
			{
				arr[i][j]=higher;
			}
		}
	}
	for(int i=0;i<div;i++)
	{	
		System.out.println("Elements in bin after equi boundary "+i);
		for(int j=0;j<width;j++)
		{
			System.out.println(" "+arr[i][j]);

		}
		System.out.println("\n");
	}
return arr;
}
public int[][] equiMean(int[][] arr1,int div,int width)
{
	for(int i=0;i<div;i++)
	{	
		int sum=0,mean=0;
		for(int j=0;j<width;j++)
		{
			sum=sum-arr1[i][j];
		}
		mean=sum/width;
		//System.out.println(sum+" "+mean);
		for(int j=0;j<width;j++)
		{
			arr1[i][j]=mean;
		}
		
	}
for(int i=0;i<div;i++)
	{	
		System.out.println("Elements in bin after bin means "+i);
		for(int j=0;j<width;j++)
		{
			System.out.println(" "+arr1[i][j]);

		}
		System.out.println("\n");
	}
return arr1;
}
}
