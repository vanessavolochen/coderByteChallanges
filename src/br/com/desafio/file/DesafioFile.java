package br.com.desafio.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioFile {
	
	public static void main (String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		String newFile = "newFile.txt";
		File file = new File(path + File.separator + newFile);
		String content = "Conteudo desafio -> " + LocalDateTime.now().toString();
		
		try {
			file.createNewFile();
			FileWriter  writer = new FileWriter(file);
			writer.write(content);
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Path> fileList= Files.walk(Paths.get(path)).filter(Files::isRegularFile)
				.map(x -> x.getFileName())
				.sorted()
				.collect(Collectors.toList());
		
		fileList.forEach(fl -> System.out.println(fl.getFileName()));
		
	}

}
