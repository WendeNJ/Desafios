# API Flask - Busca de Operadoras

## Sobre
Esta API permite buscar operadoras de saúde pelo Registro ANS a partir de um arquivo CSV.

## Requisitos
- Python 3
- Flask



1. Execute a API:
   ```sh
   python app.py
   ```

## Uso
Faça uma requisição GET para:
```
http://127.0.0.1:5000/search?Registro_ANS=<numero>
```
Se a operadora for encontrada, os dados serão retornados em JSON.

### Exemplos de consulta


#### Requisição:
```
http://127.0.0.1:5000/search?Registro_ANS=421545
```
#### Resposta:
```json
{
 {
  "Bairro": "VILA ROMANA",
  "CEP": "05049000",
  "CNPJ": "22869997000153",
  "Cargo_Representante": "SÓCIO ADMINISTRADORA",
  "Cidade": "São Paulo",
  "Complemento": "SALA 126",
  "DDD": "11",
  "Data_Registro_ANS": "2019-06-13",
  "Endereco_eletronico": "labmarisol@gmail.com",
  "Fax": "",
  "Logradouro": "RUA CATÃO",
  "Modalidade": "Odontologia de Grupo",
  "Nome_Fantasia": "",
  "Numero": "128",
  "Razao_Social": "2B ODONTOLOGIA OPERADORA DE PLANOS ODONTOLÓGICOS LTDA",
  "Regiao_de_Comercializacao": "4",
  "Registro_ANS": "421545",
  "Representante": "MARISOL BECHELLI",
  "Telefone": "34415852",
  "UF": "SP"
}
}
```




