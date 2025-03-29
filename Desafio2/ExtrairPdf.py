import os
from zipfile import ZipFile, ZIP_DEFLATED
import re
import tabula
import PyPDF2
import warnings
import pandas as pd
warnings.filterwarnings("ignore")


Substituir_abreviacoes = {
    "OD": "Seg.Odontologico",
    "AMB": "Seg.Ambulatorial"
}

with open("Anexo_I.pdf", "rb") as pdf_file:
    pdf_reader = PyPDF2.PdfReader(pdf_file)
    total_paginas = len(pdf_reader.pages)


paginas_para_ler = [str(p) for p in range(3, total_paginas + 1)]
paginas_str = ",".join(paginas_para_ler)


Lista_tabelas = tabula.read_pdf("Anexo_I.pdf", pages=paginas_str, multiple_tables=True)


print(f"Paginas extraídas: {len(Lista_tabelas)}")


colunas = [
    "PROCEDIMENTO", "RN", "VIGÊNCIA", "OD", "AMB", "HCO", "HSO",
    "REF", "PAC", "DUT", "SUBGRUPO", "GRUPO", "CAPÍTULO"
]


df_final = pd.concat(Lista_tabelas, ignore_index=True)


print(f"Número de colunas antes da atribuição: {len(df_final.columns)}")


if len(df_final.columns) >= 13:

    df_final = df_final.iloc[:, :13]
    df_final.columns = colunas
else:

    df_final.columns = df_final.columns[:13]

print(f"Número de colunas apos a atribuiçao: {len(df_final.columns)}")
df_final = df_final.iloc[:, :13]


df_final = df_final.applymap(lambda x: re.sub(r' :+', ',', str(x)) if isinstance(x, str) else x)


df_final["OD"] = df_final["OD"].map(Substituir_abreviacoes).fillna(df_final["OD"])
df_final["AMB"] = df_final["AMB"].map(Substituir_abreviacoes).fillna(df_final["AMB"])


df_final.to_csv("Teste_Wenderson.csv", index=False, sep=";")

arquivozip = ZipFile( "Teste_Wenderson.zip", "w", compression= ZIP_DEFLATED)
arquivozip.write("Teste_Wenderson.csv" )



print("ARQUIVO ZIP GERADO COM SUCESSO/ DESAFIO CONCLUIDO!")