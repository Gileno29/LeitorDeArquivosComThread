package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveDir {
	private static final String DESTINY_DIRECTORY= "C:\\Users\\Gileno\\eclipse-workspace\\LeitorDeArquivosComTread\\src\\Classes\\processando"+"\\";
	private static final String ORIGIN= "C:\\Users\\Gileno\\eclipse-workspace\\LeitorDeArquivosComTread\\src\\Classes\\inicial"+"\\";
	
	public static final void cpoiaArq(File[] file, String fileD) {
		try {
			for(int i=0; i<file.length; i++) {
				Files.copy(Paths.get(ORIGIN+file[i].getName()),Paths.get(DESTINY_DIRECTORY+fileD), StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (IOException e) {
			System.out.println("Erro ao copiar arquivo"+ e);
			
		}
	}
	
}
