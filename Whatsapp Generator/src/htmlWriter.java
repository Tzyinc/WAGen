import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class htmlWriter {
	public static void main(String [] args){
		
	}
	public htmlWriter(ArrayList<String> buffer, ArrayList<String> classes) throws IOException{
		FileWriter fw = new FileWriter("index.html");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" /><style>body{font-family: Helvetica Neue,Helvetica,Arial,sans-serif;}h5{margin:0px;color: #3f3f3f;}");
		
		for(int i=0; i<classes.size(); i++){
			String str = "div."+classes.get(i)+"{position: relative;padding: 5px;margin: 15px;margin-right:40%;color: #000;background: #f3961c;border-radius: 10px;background: #f6f6f6;}";
			bw.write(str);
			/*
			str = "div."+classes.get(i)+":after {content: \"\";display: block;position: absolute;top: 0px;left: -15px;width: 0;border-width: 15px 15px 0;border-style: solid;border-color: #f6f6f6 transparent;}";
			bw.write(str);*/
		}
		bw.write("</style></head><body><script>function classfn(className){var i;var ");
		for(int i=0; i<classes.size(); i++){
			String str = "name = document.getElementsByClassName('"+classes.get(i)+"');for(i=0; i<name.length; i++) {name[i].style.backgroundColor = '#f6f6f6';name[i].style.marginRight = '20%';name[i].style.marginLeft = '0%';}";
			bw.write(str);
		}
		bw.write("name = document.getElementsByClassName(className);for(i=0; i<name.length; i++) {name[i].style.backgroundColor = '#DCF8C6';name[i].style.marginLeft = '20%';name[i].style.marginRight = '0%';}}</script>");
		for(int i=0; i<classes.size()-1; i++){
			String str = "<button onclick=\"classfn('"+classes.get(i)+"')\">"+classes.get(i)+"</button>";
			bw.write(str);
		}
		
		for(int i=0; i<buffer.size(); i++){
			writeMsg(bw,buffer.get(i));
		}
		bw.write("</body></html>");
	}
	
	public void writeMsg(BufferedWriter bw, String str) throws IOException{
		String[]tokens = str.split("-|:");
		String name = "";
		if (tokens.length==4){
			 name = tokens[2].replace(" ", "");
		}
		bw.write("<div class=\"");
		bw.write(name);
		bw.write("\"><h5>");
		String temp = str;
		if (tokens.length==4){
			temp = tokens[0]+tokens[1]+tokens[2]+"</h5>"+tokens[3];
		}
		bw.write(temp);
		bw.write("</div>");
		
	}
}