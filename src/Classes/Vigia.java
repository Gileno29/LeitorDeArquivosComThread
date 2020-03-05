package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class Vigia extends Thread{
	private File path;
	public void run() {
		int i=0;
		while(i<1) {
			if(visualizador()!=null) {
				String resultado= visualizador();
				System.out.println(resultado);
				System.out.println(this.path);
			
			}
			
			i++;
			
			
		}
		
	}
	
	public String visualizador(){
		 File file = new File("C:/Users/Gileno/eclipse-workspace/LeitorDeArquivosComTread/src/Classes/inicial");
		 int i=0;
		 File[] tamanho= file.listFiles();
		 if (tamanho.length!=0) {
			 File afile[] = file.listFiles();
			 for(i=0; i<afile.length; i++) {
				 String f;
				 if((f=lerArq(afile[i]))!= null) {
					 this.path=afile[i];
					 return f;
					 
				 }
				 
			 }
			 }else {
				System.out.println("Sem arquivos"); 
		 }
		return null;	 
	}
	
	
	public String lerArq(File arquivo) {
		FileReader fr= null;
		
		
		try {
			fr= new FileReader(arquivo);
			BufferedReader ler= new BufferedReader(fr);
			String linha;
			do{
				linha= ler.readLine();
				String f= addBuffer(linha.length(), linha);
				return f;
				
			}while(linha!=null && linha!=" ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public String addBuffer(int  tamanho, String l) {
		String linha[]= new String[tamanho];
		
		int i=0;
		for(i=0; i<linha.length; i++) {
			linha[i]= l;
			return linha[i];
		}
		return l;
	}


}
