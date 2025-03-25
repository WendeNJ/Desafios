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

   📂 Estrutura do projeto
kotlin
Copiar
Editar
Desafio1/
│── src/
│   ├── Metodos/
│   │   ├── Consultas.java        # Obtém os links dos PDFs no site
│   │   ├── Downloads.java        # Faz o download dos arquivos
│   │   ├── Compactacao.java      # Compacta os PDFs em um ZIP
│   ├── Program/
│   │   ├── ProgramaPrincipal.java # Orquestra todas as funções
│── anexo/   # Pasta onde os PDFs e o ZIP serão salvos
⚠ Observações
Caso os links dos anexos mudem no site da ANS, pode ser necessário ajustar o código.

Certifique-se de ter o JSoup configurado no seu projeto para o scraping funcionar corretamente.

