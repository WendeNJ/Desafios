🚀 Desafio 1 - Web Scraping e Manipulação de Arquivos
Este projeto automatiza a busca e download dos anexos da ANS. Ele acessa o site oficial, localiza os links dos PDFs, baixa os arquivos e os compacta em um único ZIP.

🔹 O que o código faz?
✔️ Acessa a página da ANS.
✔️ Identifica os links dos anexos I e II.
✔️ Faz o download dos PDFs.
✔️ Compacta os arquivos baixados em um ZIP.

🛠 Tecnologias utilizadas
📌 Java
📌 JSoup (para web scraping)
📌 Java IO e Zip (para manipulação de arquivos)

🚀 Como executar?
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/WendeNJ/Desafios.git
cd Desafios/Desafio1
Compile e execute o programa no seu ambiente Java.

📂 Estrutura do projeto
kotlin
Copiar
Editar
Desafio1/
│── src/
│   ├── Metodos/
│   │   ├── Consultas.java     # Obtém os links dos PDFs no site
│   │   ├── Downloads.java     # Faz o download dos arquivos
│   │   ├── Compactacao.java   # Compacta os PDFs em um ZIP
│   ├── Program/
│   │   ├── ProgramaPrincipal.java # Orquestra todas as funções
│── anexo/   # Pasta onde os PDFs e o ZIP serão salvos
⚠ Observações
⚡ Se os links dos anexos mudarem no site da ANS, pode ser necessário ajustar o código.
⚡ Certifique-se de incluir o JSoup no seu projeto para que o scraping funcione corretamente.

