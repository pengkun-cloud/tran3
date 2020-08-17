import Vue from 'vue'
import Router from 'vue-router'
import admin from '@/components/admin'


Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
    {
      path: '/admin',
      name: 'admin',
      component: admin,
      children:[


      ]
    },

  ]
})
