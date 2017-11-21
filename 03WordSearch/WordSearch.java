import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearch{
    
    private char[][]data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows, int cols){
	data = new char[rows][cols];
	clear();
    }
    
    //constructs entire word search, not only solutions
    public WordSearch(int rows, int cols, String filename){
	randgen = new Random();
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	data = new char[rows][cols];
	clear();
	addAllWords();
	fillEmptySpace();
    }
    
    //constructs entire word search, not only solutions
    public WordSearch(int rows, int cols, String filename, int randSeed){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	randgen = new Random(randSeed);
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	data = new char[rows][cols];
	clear();
	addAllWords();
	fillEmptySpace();
    }

    //constructs word search with only solutions
    public WordSearch(int rows, int cols, String filename, int randSeed, String answer){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	randgen = new Random(randSeed);
	try {
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	data = new char[rows][cols];
	clear();
	addAllWords();
    }

    public String getAddedWords(){
	String ans = "[";
	for (int x = 0; x < wordsAdded.size(); x++){
	    ans = ans + wordsAdded.get(x) + ", ";
	}
	return ans + "]";
    }

    public int getRandomSeed(){
	int seed = (int)(Math.random()*100000);
	return seed;
    }


    private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
	boolean ans = true;
	int r = row;
	int c = col;
	if ((rowIncrement == 0 && colIncrement == 0) ||
	    (colIncrement == -1 && word.length() - 1 > col) ||
	    (rowIncrement == -1 && word.length() - 1 > row) ||
	    (colIncrement == 1 && word.length() + col > data[r].length) ||
	    (rowIncrement == 1 && word.length() + row > data.length)){
	        return false;
	}
	else {
	    for (int x = 0; x < word.length(); x++){
		if (data[r][c] != word.charAt(x) && data[r][c] != '_'){
		    ans = false;
		    return false;
		}
		r = r + rowIncrement;
		c = c + colIncrement;
	    }
	    if (ans){
		for (int x = 0; x < word.length(); x++){
		    data[row][col] = word.charAt(x);
		    row = row + rowIncrement;
		    col = col + colIncrement;
		}
	    }
	}
	return ans;
    }

    private boolean addAllWords(){
	int CT = 0;
	for (int x = 0; x < wordsToAdd.size(); x++){
	    while (CT < 100000){
		try{
		if (addWord(randgen.nextInt(data.length), randgen.nextInt(data[x].length), wordsToAdd.get(x), randgen.nextInt(3) - 1, randgen.nextInt(3) - 1)){
		    wordsAdded.add(wordsToAdd.get(x));
		    wordsToAdd.remove(wordsToAdd.get(x));
		}
		CT = CT + 1;
		}
		catch (IndexOutOfBoundsException e){
		    CT = CT + 1;
		}
	    }
	}
	return true;
    }

    private void clear(){
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
	    }
	}
    }
    private void fillEmptySpace(){
	String str = "abcdefghijklmnopqrstuvwxyz";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		if (data[x][y] == '_'){
		    data[x][y] = str.charAt(randgen.nextInt(str.length()));
		}
	    }
	}
    }

    public String toString(){
	String ans = "";
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		ans = ans + data[x][y] + " ";
	    }
	    ans = ans + "\n";
	}
	ans = ans + "\n";
	for (int x = 0; x < wordsAdded.size(); x++){
	    ans = ans + wordsAdded.get(x) + " ";
	}
	return ans + "\n"; 
    }

    public boolean addWordHorizontal(String word, int row, int col){
	boolean ans = true;
	if (word.length() > (data[row].length - col)){
	    return false;
	}
	for (int x = col, y = 0; x < (col + word.length()); x++, y++){
	    if (data[row][x] != word.charAt(y) && data[row][x] != '_'){
		ans = false;
		return ans;
	    }
	}
	if (ans) {
		for (int x = col, y = 0; x < (col + word.length()); x++, y++){
		    data[row][x] = word.charAt(y);
		}
	    }
	return ans;
    }

    public boolean addWordVertical(String word, int row, int col){
	boolean ans = true;
	if (word.length() > (data.length - row)){
	    return false;
	}
	for (int x = row, y = 0; x < (row + word.length()); x++, y++){
	    if (data[x][col] != word.charAt(y) && data[x][col] != '_'){
		ans = false;
		return ans;
	    }
	}
	if (ans) {
		for (int x = row, y = 0; x < (row + word.length()); x++, y++){
		    data[x][col] = word.charAt(y);
		}
	    }
	return ans;
    }

    public boolean addWordDiagonal(String word, int row, int col){
	int col2 = col;
	boolean ans = true;
	if (word.length() > (data.length - row)){
	    return false;
	}
	for (int x = row, y = 0; x < (row + word.length()); x++, y++){
	    if (data[x][col] != word.charAt(y) && data[x][col] != '_'){
		ans = false;
		return ans;
	    }
	    col = col + 1;
	}
	if (ans) {
		for (int x = row, y = 0; x < (row + word.length()); x++, y++){
		    data[x][col2] = word.charAt(y);
		    col2 = col2 + 1;
		}
	    }
	return ans;
    }

    public static void main(String[] args){
	if (args.length == 0){
	    System.out.println("Please insert parameters into the terminal command line.\n");
	    System.out.println("Use the following syntax to insert the parameters: java WordSearch rows cols filename randomSeed answers\n");
	    System.out.println("You must include the rows, cols, and filename parameters. The rows and cols parameters must be integers.\n");
	    System.out.println("The filename must be a .txt file.\n");
	    System.out.println("The randomSeed and answers parameters are optional.\n");
	    System.out.println("If you would like to print the puzzle solution, you must insert an integer for the randomSeed parameter. Then, type key for the answers parameter.");
	}
	else if (args.length < 3){
	    System.out.println("Error: You are missing parameters. Make sure you have inputted an integer for the rows and cols parameters and a .txt file for the filename.");
	}
	else {
	    try {
		Integer.parseInt(args[0]);
		Integer.parseInt(args[1]);
	    }
	    catch(NumberFormatException e) {
		System.out.println("Error: You input a non-integer parameter for rows and/or cols. Please input an integer for these parameters.");
		System.exit(1);
	    }
	    if (args.length == 3){
		int seed = (int)(Math.random()*100000);
		WordSearch a = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], seed);
		System.out.println(a);
		System.out.println("The computer-generated randomSeed is " + seed);
	    }
	    else if (args.length >= 4){
		try{
		    Integer.parseInt(args[3]);
		}
		catch(NumberFormatException e){
		    System.out.println("Error: You input a non-integer parameter for randomSeed. Please input an integer for this parameter.");
		    System.exit(1);
		}
		if (args.length >= 5 && args[4].equals("key")){
		    WordSearch b = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
		    System.out.println(b);
		    }
		else {
		    WordSearch c = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
		    System.out.println(c);
		}
	    }
	}
    }
}
