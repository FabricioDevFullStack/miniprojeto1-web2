<template>
  <div>
    <h1>Usuários Cadastrados</h1>
    <br/>
    <table class="table" v-if="usuarios.length > 0">
      <thead>
        <tr>
          <th><b>Nome</b></th>
          <th><b>Papeis</b></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="usuario in usuarios" :key="usuario.id">
          <td>{{ usuario.nome }}</td>
          <td v-if="usuario.papeis.length > 0">
            <ol>
              <li v-for="papel in usuario.papeis" :key="papel.id">{{ papel.descricao }}</li>
            </ol>
          </td>
          <td v-else><ul>---</ul></td>
        </tr>
      </tbody>
    </table>
    <div v-else>
      <p>Nenhum usuário cadastrado</p>
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
    }
  },

  beforeMount() {
    this.getUsuarios()
  }
};
</script>