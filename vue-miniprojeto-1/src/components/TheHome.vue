<template>
  <div>
    <h1>Usuários Cadastrados</h1>
    <br/>
    <div id="example-div" class="bg-info border d-flex aligns-items-center justify-content-center" style="height:100px">
        <table class="table table-dark table-striped" v-if="usuarios.length > 0">
          <thead>
            <tr>
              <th><b>#</b></th>
              <th><b>Nome</b></th>
              <th><b>Papeis</b></th>
              <th colspan="2"><b>Ações</b></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(usuario, indice) in usuarios" :key="usuario.id">
              <td>{{ indice + 1 }}</td>  
              <td>{{ usuario.nome }}</td>
              <td v-if="usuario.papeis.length > 0">
                <ul class="list-group">
                  <li class="list-group-item" v-for="papel in usuario.papeis" :key="papel.id">{{ papel.descricao }}</li>
                </ul>
              </td>
              <td v-else><ul class="list-group"><li class="list-group-item">---</li></ul></td>
              <td><a title="Editar Usuário" :href="'/cadastro/'+usuario.id"><font-awesome-icon icon="fa-solid fa-pen-to-square" /></a></td>
              <td><a title="Deletar Usuário" @click="deleteUsuario(usuario.id)"><font-awesome-icon icon="fa-solid fa-trash" /></a></td>
            </tr>
          </tbody>
        </table>
        <div v-else>
          <p>Nenhum usuário cadastrado</p>
        </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      usuarios: []
    };
  },

  methods: {
    async getUsuarios() {
      await axios.get('http://localhost:8080/usuarios')
                   .then(response => {
                      this.usuarios = response.data
                   })
                   .catch(error => {
                      console.log(error)
                   })
    },

    deleteUsuario(id) {
        let result = confirm("Deseja apagar usuário ?")
        
        if(result) {
            axios.delete('http://localhost:8080/usuarios/'+id)
                         .then(() => {})
                         .catch(error => {
                            console.log(error)
                         })
                         .finally(() => {
                            this.getUsuarios()
                         })
        }
    }
  },

  beforeMount() {
    this.getUsuarios()
  }
};
</script>