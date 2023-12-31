import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/cadastro',
      name: 'Cadastro',
      component: () => import('../views/CadastroView.vue')
    },
    {
        path: '/cadastro/:id',
        name: 'CadastroEdit',
        component: () => import('../views/CadastroView.vue')
      }
  ]
})

export default router