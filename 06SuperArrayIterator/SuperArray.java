public class SuperArray{
    
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int startingCapacity){
	data = new String[startingCapacity];
	size = 0;
    }

    public void clear(){
	size = 0;
	String[] data2 = new String[size];
	data = data2;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public boolean add(String element){
	if (data.length == size()){
	    resize();
	}
	String[] data2 = new String[data.length];
	for (int x = 0; x <= size(); x++){
	    data2[x] = data[x];
	}
	data2[size()] = element;
	data = data2;
	size = size + 1;
	return true;
    }

    public String toString(){
	String ans = "[";
	for (int x = 0; x < data.length - 1; x++){
	    ans = ans + data[x] + ", ";
	}
	ans = ans + data[data.length - 1] + "]";
	return ans;
    }

    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    String old = data[index];
	    data[index] = element;
	    return old;
	}
    }

    private void resize(){
	String[] data2 = new String[size() + size() + 1];
	for (int x = 0; x < size(); x++){
	    data2[x] = data[x];
	}
	data = data2;
    }

    public boolean contains(String element){
	for (int x = 0; x < size(); x++){
	    if (data[x].equals(element)){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String element){
	for (int x = 0; x < size(); x++){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String element){
	for (int x = size() - 1; x >= 0; x--){
	    if (data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }

    public void add(int index, String element){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (data.length == size()){
	    resize();
	}
	String[] data2 = new String[data.length];
	for (int x = 0; x < index; x++){
	    data2[x] = data[x];
	}
	data2[index] = element;
	for (int x = index; x < size(); x++){
	    data2[x + 1] = data[x];
	}
	data = data2;
	size = size + 1;
    }

    public String remove(int index){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	for (int x = index; x < size() - 1; x++){
	    data[x] = data[x+1];
	}
	size = size - 1;
	return old;
    }

    public boolean remove(String element){
	int index = -1;
	for (int x = 0; x < size(); x++){
	    if (data[x].equals(element) && index == -1){
		index = x;
	    }
	}
	if (index == -1){
	    return false;
	}
	else {
	    for (int x = index; x < size(); x++){
		data[x] = data[x+1];
	    }
	    remove(size());
	    return true;
	}
	
    }
	
}
