<template>
    <div>
      <h1>Cadastrar Usuário</h1>
      <br/>
      <form @submit.prevent>
        <div class="form-group">
          <label for="name">Nome:&nbsp;</label>
          <input type="text" id="name" v-model="usuario.nome" required>
        </div>
        <div class="form-group">
          <label for="papel">Papel:&nbsp;</label>
          <input type="text" id="papel" v-model="papel.descricao">
          &nbsp;<button class="btn btn-secondary" @click="adicionarPapel">Adicionar</button>
        </div>
        <div>
          <ol style="margin-left: 50px;">
            <li v-for="papel in usuario.papeis" :key="papel.dataCadastro">{{ papel.descricao }} <a title="Excluir Papel" @click="excluiPapel(papel)"><font-awesome-icon icon="fa-solid fa-trash" /></a></li>
          </ol>
        </div>
        <button type="submit" class="btn btn-primary" @click="submitForm">Cadastrar</button>
        <button class="btn btn-secondary" @click="cancelar">Cancelar</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    data() {
      return {
        usuario: {
          id: this.$route.params.id ? this.$route.params.id : 0,
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

          let metodo = this.usuario.id > 0 ? 'put' : 'post'
          axios[metodo]('http://localhost:8080/usuarios', this.usuario)
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
      },

      getUsuario(id) {
        axios.get('http://localhost:8080/usuarios/'+id)
                     .then(response => {
                        this.usuario = response.data
                     })
                     .catch(error => {
                        console.log(error)
                     })
      },

      cancelar() {
        this.$router.push('/')
      },

      excluiPapel(papel) {
        this.usuario.papeis = this.usuario.papeis.filter(p => {
            return new Date(p.dataCadastro).getTime() != new Date(papel.dataCadastro).getTime() 
        })
        
      }
    },

    beforeMount() {
        if(this.usuario.id > 0)
            this.getUsuario(this.usuario.id)
    }
  };
  </script>
  
  <style scoped>
  .form-group {
    margin-bottom: 20px;
  }
  </style>