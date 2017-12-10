import java.util.Arrays;
    
public class Sorts{

    public static String name(){
	return "10,Khuda,Raisa";
    }

    public static boolean isSorted(int[] ary){
	for (int x = 0; x < ary.length - 1; x++){
	    if (ary[x] > ary[x+1]){
		return false;
	    }
	}
	return true;
    }

    public static void selectionSort(int[] data){
	int index = 0;
	for (int x = 0; x < data.length; x++){
	    int min = data[x];
	    for (int y = x + 1; y < data.length; y++){
		if (min > data[y]){
		    min = data[y];
		    index = y;
		}
	    }
	    if (data[x] > min){
		data[index] = data[x];
	        data[x] = min;
	    }
	}
    }

    public static void insertionSort(int[] data){
	for (int x = 1; x < data.length; x++){
	    int temp = data[x - 1];
	    if (data[x] < data[x-1]){
		data[x-1] = data[x];
		data[x] = temp;
		for (int y = x; y > 0; y--){
		    int min = data[y-1];
		    if (data[y] < data[y-1]){
			data[y-1] = data[y];
			data[y] = min;
		    }
		}
	    }
	}
    }

    public static void bubbleSort(int[] data){
	while (!isSorted(data)){
	    int x = 1;
	    int last = data.length - 1;
	    while (x < data.length){
		int temp = data[x-1];
		if (data[x] < data[x-1]){
		    data[x-1] = data[x];
		    data[x] = temp;
		}
		x++;
		if (x == last + 1){
		    x = 1;
		    last--;
		}
	    }
	}
    }
    
    
    public static void main(String[]artie){     
        int[] randish = new int[15];
        for(int i = 0 ; i < randish.length; i++){     
            randish[i] =(int)(Math.random()*100);      
        }
	//System.out.println(isSorted(randish));
	System.out.println(Arrays.toString(randish));
	insertionSort(randish);
	System.out.println(Arrays.toString(randish));
    }    
    
         
}
