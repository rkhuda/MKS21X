public class ReversedCharSequence implements CharSequence {

    private String data;

    public ReversedCharSequence(ReversedCharSequence r){
	data = r.toString();
    }

    public ReversedCharSequence(String s){
	data = s;
	String ans = "";
	for (int x = s.length() - 1; x >= 0; x--){
	    ans = ans + data.substring(x, x+1);
	}
	data = ans;
    }

    public String subSequence(int start, int end){
	ReversedCharSequence r = new ReversedCharSequence(data);
	return data.substring(start, end);
    }
    
    public char charAt(int index){
	return data.charAt(index);
    }

    public int length(){
	return data.length();
    }

    public String toString(){
	return data;
    }
    
}
