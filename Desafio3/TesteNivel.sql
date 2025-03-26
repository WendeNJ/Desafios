-- Criacao da tabela de demonstracoes contabeis dos ultimos 2 anos
CREATE TABLE `demonstracoes_contabeis` (
  `data` date DEFAULT NULL,
  `reg_ans` int DEFAULT NULL,
  `cd_conta_contabil` int DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `vl_saldo_inicial` decimal(15,2) DEFAULT NULL,
  `vl_saldo_final` decimal(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Criacao tabela relatorio 
CREATE TABLE `relatorio` (
  `Registro_ANS` int DEFAULT NULL,
  `CNPJ` bigint DEFAULT NULL,
  `Razao_Social` text COLLATE utf8mb4_unicode_ci,
  `Nome_Fantasia` text COLLATE utf8mb4_unicode_ci,
  `Modalidade` text COLLATE utf8mb4_unicode_ci,
  `Logradouro` text COLLATE utf8mb4_unicode_ci,
  `Numero` int DEFAULT NULL,
  `Complemento` text COLLATE utf8mb4_unicode_ci,
  `Bairro` text COLLATE utf8mb4_unicode_ci,
  `Cidade` text COLLATE utf8mb4_unicode_ci,
  `UF` text COLLATE utf8mb4_unicode_ci,
  `CEP` text COLLATE utf8mb4_unicode_ci,
  `DDD` int DEFAULT NULL,
  `Telefone` int DEFAULT NULL,
  `Fax` text COLLATE utf8mb4_unicode_ci,
  `Endereco_eletronico` text COLLATE utf8mb4_unicode_ci,
  `Representante` text COLLATE utf8mb4_unicode_ci,
  `Cargo_Representante` text COLLATE utf8mb4_unicode_ci,
  `Regiao_de_Comercializacao` int DEFAULT NULL,
  `Data_Registro_ANS` text COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--Maiores Despesas ultimo trimestre
SELECT 
    r.Razao_Social,
    SUM(d.vl_saldo_inicial - d.vl_saldo_final) AS total_despesa
FROM relatorio r
JOIN demonstracoes_contabeis d ON r.Registro_ANS = d.reg_ans
WHERE d.data BETWEEN '2024-10-01' AND '2024-12-31'
  AND (d.descricao LIKE '%Eventos%' OR d.descricao LIKE '%Sinistros%' OR d.descricao LIKE '%Assistência Médico-Hospitalar%')
GROUP BY r.Razao_Social
ORDER BY total_despesa DESC
LIMIT 10;

-- Maiores Despesas Ultimo ano
SELECT 
    r.Razao_Social,
    SUM(d.vl_saldo_inicial - d.vl_saldo_final) AS total_despesa
FROM relatorio r
JOIN demonstracoes_contabeis d ON r.Registro_ANS = d.reg_ans
WHERE d.data BETWEEN '2024-01-01' AND '2024-12-31'
  AND (d.descricao LIKE '%Eventos%' OR d.descricao LIKE '%Sinistros%' OR d.descricao LIKE '%Assistência Médico-Hospitalar%')
GROUP BY r.Razao_Social
ORDER BY total_despesa DESC
LIMIT 10;

-- Importacao do Arquivo csv dos ultimos 2 anos
-- Para a importacao dos outros 7 arquivos fiz somente a mudanca no nome do arquivo.csv (2T,3T,4T) 
-- e assim sucessivamente

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1T2023.csv'
INTO TABLE demonstracoes_contabeis
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(@data, reg_ans, cd_conta_contabil, descricao, @vl_saldo_inicial, @vl_saldo_final)
SET 
    data = STR_TO_DATE(@data, '%Y-%m-%d'),
    vl_saldo_inicial = REPLACE(@vl_saldo_inicial, ',', '.'),
    vl_saldo_final = REPLACE(@vl_saldo_final, ',', '.');



-- OPTEI POR NAO FAZER AUTOMACAO
