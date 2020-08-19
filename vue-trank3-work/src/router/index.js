import Vue from 'vue'
import Router from 'vue-router'
import admin from '@/components/admin'
import PeopleVue from '@/components/people_management/PeopleVue'
import PemissionVue from '@/components/people_management/PemissionVue'
import RoleVue from '@/components/people_management/RoleVue'
import DepartmentVue from '@/components/people_management/DepartmentVue'
import Article from '@/components/article_management/Article'



Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
    {
      path: '/admin',
      name: 'admin',
      component: admin,
      children:[
        {
          path: '/PeopleVue',
          name: 'PeopleVue',
          component: PeopleVue,
        },
        {
          path: '/PemissionVue',
          name: 'PemissionVue',
          component: PemissionVue,
        },
        {
          path: '/RoleVue',
          name: 'RoleVue',
          component: RoleVue,
        },
        {
          path: '/DepartmentVue',
          name: 'DepartmentVue',
          component: DepartmentVue,
        },
        {
          path: '/Article',
          name: 'Article',
          component: Article,
        }
      ]
    },

  ]
})
