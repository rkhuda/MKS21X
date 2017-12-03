public class Barcode implements Comparable<Barcode> {
    
    String zipcode;
    String barcode;
    String[] code;

    public Barcode(String zip){
	zipcode = zip;
    }

    public String getZip(){
	return zipcode;
    }

    public String getCode(){
	
	zipToCode();
	
	barcode = "|";
	for(int x = 0; x < zipcode.length(); x++){
	    barcode = barcode + " " + code[Integer.parseInt(zipcode.substring(x, x+1))];
	}
	barcode = barcode + " |";
	return barcode;
    }

    public String toString(){
	return getCode() + " (" + getZip() + ")";
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public boolean equals(Barcode other){
	return getZip().compareTo(other.getZip()) == 0;
    }

    private void zipToCode(){
	code = new String[10];
	code[0] = "||:::";
	code[1] = ":::||";
	code[2] = "::|:|";
	code[3] = "::||:";
	code[4] = ":|::|";
	code[5] = ":|:|:";
	code[6] = ":||::";
	code[7] = "|:::|";
	code[8] = "|::|:";
	code[9] = "|:|::";
    }
}
