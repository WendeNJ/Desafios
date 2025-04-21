# Desafio 2 - Extração e Processamento de Dados de PDF

Este projeto tem como objetivo extrair dados de uma tabela contida em um PDF, processar as informações e gerar um arquivo CSV, que é posteriormente compactado em um arquivo ZIP. Além disso, as abreviações das colunas são substituídas pelas descriçoes completas.

## O que o código faz:

1. **Extração de Dados do PDF**: 
   O código utiliza a biblioteca `tabula` para extrair os dados da tabela "Rol de Procedimentos e Eventos em Saúde" do arquivo PDF. Ele lê todas as páginas do PDF especificado.

2. **Substituição de Abreviações**: 
   As abreviações das colunas **OD** e **AMB** são substituídas pelas descrições completas:
   - **OD** é substituído por "Seg.Odontologico"
   - **AMB** é substituído por "Seg.Ambulatorial"

3. **Geração do Arquivo CSV**: 
   Após o processamento, os dados são salvos em um arquivo CSV (`Teste_Wenderson.csv`), usando `pandas`.

4. **Compactação do CSV**: 
   O arquivo CSV gerado é compactado em um arquivo ZIP (`Teste_Wenderson.zip`) utilizando a biblioteca `zipfile`.

## Como executar o código:

1. **Pré-requisitos**: 
   Certifique-se de ter as bibliotecas necessárias instaladas. Você pode instalá-las com o seguinte comando:

   ```bash
   pip install tabula-py PyPDF2 pandas



Obrigado!
