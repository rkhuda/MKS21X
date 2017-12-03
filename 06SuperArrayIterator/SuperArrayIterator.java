import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

    private int current;
    private int end;

    public SuperArrayIterator(int start, int stop){
	current = start;
	end = stop;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

    public boolean hasNext(){
	return current <= end;
    }

    public int next(){
	if (hasNext()){
	    current++;
	}
	else {
	    System.exit(0);
	}
	return data.get(current - 1);
    }
}
