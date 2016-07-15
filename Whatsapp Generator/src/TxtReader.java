import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {
	String fileName = "";
	public ArrayList<String> buffer = new ArrayList<String>();
	public ArrayList<String> classes = new ArrayList<String>();
	public static void main(String [] args){
		try {
			TxtReader test = new TxtReader("jess.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TxtReader(String input) throws IOException{
		fileName = input;
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String temp = br.readLine();
			temp.replace("(╯° д°)╯?ص 6uɐnʿ 6uɿ!ʿ", "kk");
			buffer.add(temp);
			String[]tokens = temp.split("-|:");
			System.out.println(temp);
			//System.out.println(tokens[2].replace(" ", ""));
			if(tokens.length==4){
				String name = tokens[2].replace(" ", "");
				if(!classes.contains(name)){
					classes.add(name);
				}
			}
		}
		br.close();
	}
}
