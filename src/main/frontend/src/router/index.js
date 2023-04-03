import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'LoginView',
      component: LoginView
    },
    {
      path: "/session",
      name: "LayoutSession",
      component: () => import('../layouts/LayoutSession.vue'),
      meta: {requiresAuth: true},  
      children:[
        {
          path: 'user',
          name: 'user',
          component: ()=> import('../layouts/userLayout/UserLayout.vue'),
          meta: {requiresAuth: true},
          children: [
            // aqui es donde deben ir todas las vistas que tiene el usuario
          ]
        },
        {
          path: 'responsable',
          name: 'responsable',
          component: () => import('../layouts/ResponsableLayout/ResponsableLayout.vue'),
          meta: {requiresAuth: true},
          children: [
            // aqui es donde deben ir todas las vistas que tiene el responsable
          ]
        },
        {
          path: 'admin',
          name: 'admin',
          component: () => import('../layouts/superAdminLayout/SuperAdminLayout.vue'),
          meta: {requiresAuth: true},
          children: [
            // aqui es donde deben ir todas las vistas que tiene el admin
            {
              path: 'CreateUser',
              name: 'CreateUserView',
              component: () => import('../views/Admin/CreateUserView.vue'),
              meta: {requiresAuth: true},


            } 
          ]
        }
      ]
    }
  ]
});


export default router
