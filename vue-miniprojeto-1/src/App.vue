<script setup>
import { RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div id="app">
        <nav class="navbar navbar-expand-lg fixed-top">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/"><font-awesome-icon icon="fa-solid fa-bars" /> Listagem</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cadastro"><font-awesome-icon icon="fa-solid fa-user-tie" /> Cadastro</a>
                    </li>
                </ul>
            </div>
            </div>
        </nav>
            <RouterView />
    </div>
  </header>

</template>

<style scoped>
</style>