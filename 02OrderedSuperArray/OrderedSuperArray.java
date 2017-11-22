public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] ary){
	super();
	for (int x = 0; x < ary.length; x++){
	    super.add(ary[x]);
	}
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    public void add(int index, String value){
	add(value);
    }

    public int indexOfBinary(String element){
	int index = 0;
	int start = 0;
	int end = size();
	if (get(size()/2).equals(element)){
	    for (int x = size()/2; x >= 0; x--){
		if (get(x).equals(element)){
		    index = x;
		}
	    }
	}
	else {
	    while (start != end){
		if (get(start + ((end - start)/2)).compareTo(element) < 0){
			start = start + ((end - start)/2);
		    }
		else if (get(start + ((end - start)/2)).equals(element)){
		    for (int x = start + ((end - start)/2); x >= start; x--){
			if (get(x).equals(element)){
			    index = x;
			}
		    }
		    return index;
		    }
		else {
		    end = start + ((end - start)/2);
		}
	    }
	}
	return index;
    }

    public int lastIndexOfBinary(String element){
	int index = 0;
	int start = 0;
	int end = size();
	if (get(size()/2).equals(element)){
	    for (int x = size()/2; x < size(); x++){
		if (get(x).equals(element)){
		    index = x;
		}
	    }
	}
	else {
	    while (start != end){
		if (get(start + ((end - start)/2)).compareTo(element) < 0){
		    start = start + ((end - start)/2);
		}
		else if (get(start + ((end - start)/2)).equals(element)){
		    for (int x = start + ((end - start)/2); x < end; x++){
			if (get(x).equals(element)){
			    index = x;
			}
		    }
		    return index;
		}
		else {
		    end = start + ((end - start)/2);
		}
	    }
	}
	return index;
    }

    private int findIndex(String value){
	boolean ans = false;
	int index = 0;
	for (int x = size() - 1; x >= 0; x--){
	    if (get(x).compareTo(value) < 0 && ans == false){
		index = x + 1;
		ans = true;
	    }
	    else if (get(x).compareTo(value) == 0 && ans == false){
		index = x;
		ans = true;
	    }
	}
	return index;
    }

    private int findIndexBinary(String value){
	int index = 0;
	int start = 0;
	int end = size();
	if (get(size()/2).compareTo(value) == 0){
	    index = size()/2;
	}
	else {
	    if (get(size()/2).compareTo(value) < 0){
		start = size()/2;
		while (start >= 0){
		    if (end - start > 1){
			if (get(start + (end - start)/2).compareTo(value) < 0){
			    start = start + ((end - start)/2);
			}
		    }
		    else {
			index = start + 1;
		    }
		}
	    }
	    else {
		end = size()/2;
		while (end >= 0){
		    if (end - start > 1){
			if (get(start + (end - start)/2).compareTo(value) < 0){
			    start = start + ((end - start)/2);
			}
			else {
			    index = start + 1;
			}
		    }
		}
	    }
	}
	return index;
    }

    public boolean add(String value){
	super.add(findIndex(value), value);
	return true;
    }
}
