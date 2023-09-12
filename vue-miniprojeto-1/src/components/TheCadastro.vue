<template>
    <div>
      <h1>Cadastrar Usuário</h1>
      <br/>
      <form @submit.prevent>
        <div class="form-group">
          <label for="name">Nome: </label>
          <input type="text" id="name" v-model="usuario.nome" required>
        </div>
        <div class="form-group">
          <label for="papel">Papeis: </label>
          <input type="text" id="papel" v-model="papel.descricao">
          &nbsp;<button @click="adicionarPapel">Adicionar</button>
        </div>
        <div>
          <ol style="margin-left: 100px;">
            <li v-for="papel in usuario.papeis" :key="papel.dataCadastro">{{ papel.descricao }}</li>
          </ol>
        </div>
        <button type="submit" @click="submitForm">Cadastrar</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    data() {
      return {
        usuario: {
          id: 0,
          dataCadastro: Date.now(),
          nome: '',
          papeis: []
        },
        papel: {
          id: 0,
          dataCadastro: Date.now(),
          descricao: ''
        }
      };
    },
    methods: {
      submitForm() {
        if(this.usuario.nome) {
          axios.post('http://localhost:8080/usuarios', this.usuario)
                     .then(response => {
                        console.log(response.data)
                     })
                     .catch(error => {
                        console.log(error)
                     })
                     .finally(() => {
                        this.$router.push('/')
                     })
        }
      },
  
      adicionarPapel() {
        if(this.papel.descricao)
          this.usuario.papeis.push(this.papel)
  
        this.papel = {
          id: 0,
          dataCadastro: Date.now(),
          descricao: ''
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .form-group {
    margin-bottom: 20px;
  }
  </style>