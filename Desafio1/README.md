# Desafio 1 - Web Scraping e Manipulação de Arquivos

Este projeto realiza web scraping para buscar os links dos anexos no site da ANS, faz o download dos arquivos PDF e, em seguida, os compacta em um arquivo ZIP.

## 📌 O que o código faz?

- Acessa a página da ANS.
- Encontra os links dos anexos I e II.
- Baixa os PDFs.
- Compacta os arquivos em um ZIP.

## 🛠 Tecnologias utilizadas

- Java
- JSoup (para web scraping)
- Java IO e Zip (para manipulação de arquivos)

## 🚀 Como executar?

1. Clone o repositório:

   ```bash
   git clone https://github.com/WendeNJ/Desafios.git
   cd Desafios/Desafio1

   ## 📂 Estrutura do Projeto


---
  ## 📂 Estrutura do Projeto
  
### Detalhes:

- **src/Metodos/Consultas.java**: Realiza o scraping e obtém os links dos arquivos PDF da página da ANS.
- **src/Metodos/Downloads.java**: Baixa os arquivos PDF encontrados.
- **src/Metodos/Compactacao.java**: Compacta os PDFs baixados em um arquivo ZIP.
- **src/Program/ProgramaPrincipal.java**: Executa todas as funções descritas acima, orquestrando o processo completo.
- **anexo/**: Diretório onde os PDFs e o arquivo ZIP resultante são salvos.

---
Caso os links dos anexos mudem no site da ANS, pode ser necessário ajustar o código.

Certifique-se de ter o JSoup configurado no seu projeto para o scraping funcionar corretamente.

