<template>
  <div id="app">
    <h1>Buscar Operadora</h1>
    <input v-model="registroANS" placeholder="Digite o Registro ANS" />
    <button @click="buscarOperadora">Buscar</button>

    <div v-if="operadora">
      <h2>Operadora Encontrada</h2>
      <ul>
        <li><strong>Razão Social:</strong> {{ operadora.Razao_Social }}</li>
        <li><strong>Nome Fantasia:</strong> {{ operadora.Nome_Fantasia }}</li>
        <li><strong>CNPJ:</strong> {{ operadora.CNPJ }}</li>
        <li><strong>Cidade:</strong> {{ operadora.Cidade }}</li>
        <li><strong>UF:</strong> {{ operadora.UF }}</li>
        <li><strong>Telefone:</strong> {{ operadora.Telefone }}</li>
        <li><strong>Representante:</strong> {{ operadora.Representante }}</li>
      </ul>
    </div>

    <div v-if="errorMessage" style="color: red;">
      <p>{{ errorMessage }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      registroANS: '',
      operadora: null,
      errorMessage: null
    };
  },
  methods: {
    async buscarOperadora() {
      if (!this.registroANS) {
        this.errorMessage = "O Registro ANS é obrigatório.";
        this.operadora = null;
        return;
      }

      try {
        const response = await fetch(`http://127.0.0.1:5000/search?Registro_ANS=${this.registroANS}`);
        const data = await response.json();

        if (response.ok) {
          this.operadora = data;
          this.errorMessage = null;
        } else {
          this.operadora = null;
          this.errorMessage = data.message || "Operadora não encontrada.";
        }
      } catch (error) {
        this.operadora = null;
        this.errorMessage = "Erro ao conectar ao servidor.";
      }
    }
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
input {
  padding: 10px;
  font-size: 14px;
  margin-bottom: 10px;
}
button {
  padding: 10px;
  font-size: 14px;
  cursor: pointer;
}
</style>
