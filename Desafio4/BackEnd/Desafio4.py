from flask import Flask, request, jsonify
import csv
from flask_cors import CORS
app = Flask(__name__)
CORS(app)

def carregar_operadoras():
    operadoras = []
    with open('Relatorio_Desafio4.csv', mode='r', encoding='utf-8') as file:
        reader = csv.DictReader(file, delimiter=';')
        for row in reader:
            operadoras.append(row)
    return operadoras



@app.route('/search', methods=['GET'])
def search_operadoras():
    registro_ans = request.args.get('Registro_ANS', '')  # Obtém o Registro_ANS da URL

    if not registro_ans:
        return jsonify({"error": "O Registro_ANS é obrigatório."}), 400


    operadoras = carregar_operadoras()


    resultado = next((operadora for operadora in operadoras if operadora['Registro_ANS'] == registro_ans), None)

    if resultado:
        return jsonify(resultado)
    else:
        return jsonify({"message": "Operadora não encontrada."}), 404


if __name__ == '__main__':
    app.run(debug=True)
