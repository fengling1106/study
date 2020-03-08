package algorithm.sort;

public class Sort {
	public static void BubbleSort() {
		int[] arr={6,3,8,2,9,1};
		System.out.println("排序前数组为：");
		for(int num:arr){
			System.out.print(num+" ");
		}
		for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
			for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		} 
		System.out.println();
		System.out.println("排序后的数组为：");
		for(int num:arr){
			System.out.print(num+" ");
			} 
		}
	
	public static void InsertSort()
	{
		int[] arr = {2,1,6,7,5,9,8,12,4};
		for(int i=1; i<arr.length;i++)
		{
			int key = arr[i];
			int j=i;
			while(j>=1 && (arr[j-1]>key))
			{
				arr[j]=arr[j-1];
				j--;
			}
			
			arr[j]=key;
		}
	
	for(int num:arr){
		System.out.print(num+" ");
		} 		
	}
}
