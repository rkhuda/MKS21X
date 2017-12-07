import java.util.Arrays;
    
public class Sorts{

    public static String name(){
	return "01.Khuda.Raisa";
    }
    /*
    public static boolean isSorted(int[] ary){
	for (int x = 0; x < ary.length - 1; x++){
	    if (ary[x] > ary[x+1]){
		return false;
	    }
	}
	return true;
    }

    private static void swap(int[] ary, int a, int b){
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
    */

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
    
    /*
    public static void main(String[]artie){     
        int[] randish = new int[15];
        for(int i = 0 ; i < randish.length; i++){     
            randish[i] =(int)(Math.random()*100);      
        }
	System.out.println(isSorted(randish));
	System.out.println(Arrays.toString(randish));
	selectionSort(randish);
	System.out.println(Arrays.toString(randish));
    }    
    */
         
}
