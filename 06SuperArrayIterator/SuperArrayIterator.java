public class SuperArrayIterator implements Iterator<String>{

    private int current;
    private int end;
    private String[] data;

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
