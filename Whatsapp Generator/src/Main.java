import java.io.IOException;

public class Main {
	public static void main(String []args){
		try {
			TxtReader tr = new TxtReader("jess.txt");
			htmlWriter hw = new htmlWriter(tr.buffer,tr.classes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
