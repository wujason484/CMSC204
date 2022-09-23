public class ArraySum {
	
	public int sumOfArray(Integer[] a, int index) {
		int sum=0;
		
		if(index<=0) {
			sum=0;
		}
		
		else {
			sum=a[index-1]+sumOfArray(a,index-1);
		}
		
		return sum;
	}

}
