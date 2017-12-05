public class Barcode implements Comparable<Barcode> {
    
    String _zip;
    String barcode;
    String[] zipToBar;
    
    public Barcode(String zip){
	_zip = zip;
	
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else {
	    try {
		for (int x = 0; x < zip.length(); x++){
		    Integer.parseInt(zip.substring(x, x+1));
		}
	    }
	    catch(NumberFormatException e) {
		throw new IllegalArgumentException();
	    }
	}
    }

    public String toString(){
	return getCode() + " (" + getZip() + ")";
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public static String toCode(String zip){
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else {
	    try {
		for (int x = 0; x < zip.length(); x++){
		    Integer.parseInt(zip.substring(x, x+1));
		}
	    }
	    catch(NumberFormatException e) {
		throw new IllegalArgumentException();
	    }
	}
	
	String[] barcode = new String[10];
	barcode[0] = "||:::";
	barcode[1] = ":::||";
	barcode[2] = "::|:|";
	barcode[3] = "::||:";
	barcode[4] = ":|::|";
	barcode[5] = ":|:|:";
	barcode[6] = ":||::";
	barcode[7] = "|:::|";
	barcode[8] = "|::|:";
	barcode[9] = "|:|::";
	
	int checksum = 0;
	String code = "|";
	for(int x = 0; x < zip.length(); x++){
	    code = code + barcode[Integer.parseInt(zip.substring(x, x+1))];
	    checksum = checksum + Integer.parseInt(zip.substring(x, x+1));;
	}
	code = code + barcode[checksum % 10] + "|";
	return code;
    }

    public static String toZip(String code){
	String zip = "";
	int checksum = 0;

	String[] barcode = new String[10];
	barcode[0] = "||:::";
	barcode[1] = ":::||";
	barcode[2] = "::|:|";
	barcode[3] = "::||:";
	barcode[4] = ":|::|";
	barcode[5] = ":|:|:";
	barcode[6] = ":||::";
	barcode[7] = "|:::|";
	barcode[8] = "|::|:";
	barcode[9] = "|:|::";
	
	if (code.length() != 32 || !code.substring(0, 1).equals("|") ||
	    !code.substring(code.length() - 1, code.length()).equals("|")){
	    throw new IllegalArgumentException();
	}
	else {
	    
	    for (int x = 0; x < code.length(); x++){
		if (!code.substring(x, x+1).equals("|") &&
		    !code.substring(x, x+1).equals(":")){
		    throw new IllegalArgumentException();
		}
	    }
	    
	    int x = 1;
	    int y = 0;
	    while (x < code.length() - 5) {
		if (code.substring(x, x + 5).equals(barcode[y])){
		    zip = zip + y;
		    checksum = checksum + y;
		    x = x + 5;
		    y = 0;
		}
		else {
		    y++;
		}
	    }
	    for (int i = 0; i < zip.length(); i++){
		if (zip.substring(i, i+1).equals("|") ||
		    zip.substring(i, i+1).equals(":")){
		    throw new IllegalArgumentException();
		}
	    }
	    checksum = (checksum - Integer.parseInt(zip.substring(5, 6))) % 10;
	    if (!code.substring(26, 31).equals(barcode[checksum])){
	    	throw new IllegalArgumentException();
	    }
	    
	}
	return zip.substring(0, 5);
    }

    public String getCode(){
	
	zipToCode();
	
	barcode = "|";
	int checksum = 0;
	for(int x = 0; x < _zip.length(); x++){
	    barcode = barcode + zipToBar[Integer.parseInt(_zip.substring(x, x+1))];
	    checksum = checksum + Integer.parseInt(_zip.substring(x, x+1));
	}
	barcode = barcode + zipToBar[checksum % 10] + "|";
	return barcode;
    }

    public String getZip(){
	return _zip;
    }

    public boolean equals(Barcode other){
	return getZip().compareTo(other.getZip()) == 0;
    }

    private void zipToCode(){
	zipToBar = new String[10];
	zipToBar[0] = "||:::";
	zipToBar[1] = ":::||";
	zipToBar[2] = "::|:|";
	zipToBar[3] = "::||:";
	zipToBar[4] = ":|::|";
	zipToBar[5] = ":|:|:";
	zipToBar[6] = ":||::";
	zipToBar[7] = "|:::|";
	zipToBar[8] = "|::|:";
	zipToBar[9] = "|:|::";
    }
	
}
