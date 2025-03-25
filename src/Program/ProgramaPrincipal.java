package Program;

import Metodos.Consultas;
import Metodos.Downloads;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
	Consultas consultas = new Consultas();
	
	String[] links = consultas.obterLinks();
	
	if (links[0] != null) {
		Downloads.downloadsPdf(links[0], "Anexo_I.pdf");
		
	}
		if (links[1] !=null) {
			Downloads.downloadsPdf(links[1], "Anexo_II.pdf" );
		}
		 
		 

	}

}
