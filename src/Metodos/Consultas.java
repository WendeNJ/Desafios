package Metodos;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Consultas {

		public String[] obterLinks() {
			String [] links = new String[2];
			
			
String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
		        try {
		            Document doc = Jsoup.connect(url).get();
		            Elements pdflinks = doc.select("a[href]");
		            int i = 0;
		            for ( Element elemento : pdflinks) {
		            	String conteudoPdf = elemento.attr("href");
		            	if ( conteudoPdf.endsWith(".pdf") && (conteudoPdf.contains("Anexo_I") || conteudoPdf.contains("Anexo_II"))) {
		               links[i] = conteudoPdf;
		               i++;
		               if( i == 2) break;
		              
		             
		            	
		            	}
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } return links;
		}
		    }

	
	
	
	


