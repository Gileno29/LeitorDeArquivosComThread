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
	private File[] path;
	private File dst;
	private String[] f =null;
	private BufferedReader ler;
	public void run() {
		int i=0;
		while(true) {
			if(visualizador()!=null) {
				String[] resultado= visualizador();
				System.out.println(resultado);
				System.out.println(this.path);
				for(i=0; i<path.length; i++) {
					MoveDir.cpoiaArq(path, path[i].getName());
					
				}
				
				
			} else {
				System.out.println("entrou");
				try {
					System.out.println("Thread de vigia adormeceu");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("a treade de vigia Não Adormeceu");
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	//lista arquivos na pasta 
	public String[] visualizador(){
		 File file = new File("C:/Users/Gileno/eclipse-workspace/LeitorDeArquivosComTread/src/Classes/inicial");
		 int i=0;
		 File[] tamanho= file.listFiles();//joga o tamanho do arquivo e joga no array
		 if (tamanho.length!=0) {
			 //System.out.println("entrou");
			 File afile[] = file.listFiles();
			 //System.out.println(afile[0]);
			
			 for(i=0; i<afile.length; i++) {
				 this.f[i]=lerArq(afile[i]);// TA DANDO ERRO NO CARAI DO ADDBUFFER
				 if(f[i]!=null) {
					 System.out.println(f[i]+" Position "+i);
					 this.path[i]=afile[i]; 
				 }else {
					 System.out.println("valor nulo"+ f[i]);
				 }
			 }
			 return f;
		 }
		 
		return null;	 
	}
	
	
	
	public String lerArq(File afile) {
		
		FileReader fr;
		
		
		try {
			fr= new FileReader(afile);
			ler = new BufferedReader(fr);
			String linha;
			do{
				linha= ler.readLine();
				System.out.println("essa é a linha"+linha);
				String f= addBuffer(linha);	
				
				System.out.println("Valor da variavel que recebe o addBuffer "+ f);
				
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
	
	public String addBuffer(String l) {
		FilaArquivos f= new FilaArquivos();
		
		f.inserir(l);
		System.out.println("Visualizar do addbuffer "+f.visualizar());
		
		return f.visualizar();

}
	
}
