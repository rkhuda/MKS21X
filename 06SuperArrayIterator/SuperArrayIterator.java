import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

    int current;
    int end;
    String[] data;

    public SuperArrayIterator(String[] superarray, int start, int stop){
	data = superarray;
	current = start;
	end = stop;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

    public boolean hasNext(){
	return current <= end;
    }

    public String next(){
	if (hasNext()){
	    current++;
	}
	else {
	    System.exit(0);
	}
	return data[current - 1];
    }
}
