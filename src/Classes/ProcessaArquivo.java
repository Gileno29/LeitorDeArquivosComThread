package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessaArquivo extends Thread {
	private File path;
	private static final String SRC_DIRECTORY="C:/Users/Gileno/eclipse-workspace/LeitorDeArquivosComTread/src/Classes/processando";
	
	
	
	public void run() {
		
		while(true) {
			//leitura da fila
			//Criação do novo arquivo
			if(visualizador()!=null) {
				
				
			}
			
		}
		
	}
	
	
	public String visualizador(){
		 File file = new File(SRC_DIRECTORY);
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
				//String f= addBuffer(linha);
				//return f;
				
			}while(linha!=null && linha!=" ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public void somar(String number) {
		
		
	}

}
