package Metodos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import Exceptions.DownloadException;



public class Downloads {

	public static void downloadsPdf (String pdfURL, String nomeArquivo) {
		File diretorio = new File ("anexo");
		if (!diretorio.exists()) {
			diretorio.mkdirs();
			
		}
	try { 
	
		URL url = new URL (pdfURL);
		
		InputStream inputStream = url.openStream();
		
		FileOutputStream fos = new FileOutputStream( diretorio + "/" + nomeArquivo);
		
		byte[] buffer = new byte[4096];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);
			
		} System.out.println("O PDF :  " + nomeArquivo + " FOI BAIXADO COM SUCESSO ");
		inputStream.close();
		
		fos.close();
	} catch (IOException e ) {
		try {
			throw new DownloadException(" ERRO AO BAIXAR O ARQUIVO : " + e.getMessage());
		} catch (DownloadException de) {
			de.printStackTrace();
		}

		
	}
	  
	}

}
