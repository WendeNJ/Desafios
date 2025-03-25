package Program;

import java.io.File;

import Metodos.Compactacao;
import Metodos.Consultas;
import Metodos.Downloads;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        try {
            // Instancia o objeto Consultas para obter os links dos PDFs
            Consultas consultas = new Consultas();
            String[] links = consultas.obterLinks();
            
            // Verifica se o link do primeiro PDF não é nulo e faz o download
            if (links[0] != null) {
                Downloads.downloadsPdf(links[0], "Anexo_I.pdf");
            }
            
            // Verifica se o link do segundo PDF não é nulo e faz o download
            if (links[1] != null) {
                Downloads.downloadsPdf(links[1], "Anexo_II.pdf");

                // Compacta os dois arquivos PDF após o download
                String[] arquivosParaCompactar = {"anexo" + File.separator + "Anexo_I.pdf", 
                                                   "anexo" + File.separator + "Anexo_II.pdf"};
                String arquivoZip = "anexo" + File.separator + "anexos.zip";
                Compactacao.compactarArquivos(arquivosParaCompactar, arquivoZip);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ocorreu um erro durante a execução do programa: " + e.getMessage());
        }
    }
}
