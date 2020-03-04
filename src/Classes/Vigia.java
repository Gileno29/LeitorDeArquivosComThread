package Classes;

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
	int i;
	public void run() {
		while(true) {
			try(WatchService service = FileSystems.getDefault().newWatchService()){
				Map<WatchKey, Path> keyMap= new HashMap<>(); 
				
				Path path= Paths.get("C:/Users/Gileno/eclipse-workspace/LeitorDeArquivosComTread/src/Classes/inicial");
				
				keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE), path);
				WatchKey watchkey;
				watchkey= service.take();
				
				
				
				//Path eventDir= keyMap.get(watchkey);
				
				/*for(WatchEvent<?> event :watchkey.pollEvents() ) {
					WatchEvent.Kind<?> kind= event.kind();
					Path eventPath= (Path)event.context();
					
					System.out.println(eventDir + " : "+ kind +" : "+ eventPath );
				}*/
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			i++;
			
		}
		
	}

}
