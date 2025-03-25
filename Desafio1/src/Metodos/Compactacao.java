package Metodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactacao {
 public static void compactarArquivos (String[] arquivos, String zipFile) {
	 try {
		 FileOutputStream fos = new FileOutputStream ( zipFile);
		 ZipOutputStream zos = new ZipOutputStream(fos);
		
		 for ( String arquivo : arquivos ) {
			 File file = new File (arquivo);
			 FileInputStream fis = new FileInputStream(file);
			 
			 ZipEntry zipEntry = new ZipEntry ( file.getName());
			 zos.putNextEntry(zipEntry);
			 
			 byte[] buffer = new byte[1024];
			 int len;
			 while ((len = fis.read(buffer)) > 0) {
				 zos.write(buffer, 0, len);
			 }
			 
				 zos.closeEntry();
				 fis.close();
				 
			 }
		 zos.close();
		 fos.close();
	        System.out.println("Arquivos compactados em: " + zipFile);
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
 public static void main(String[] args) {
    
     String[] arquivos = {"anexo/Anexo_I.pdf", "anexo/Anexo_II.pdf"};
     
   
     String nomeArquivoZip = "anexos.zip";

   
     compactarArquivos(arquivos, nomeArquivoZip);
 }
}
		  
	


