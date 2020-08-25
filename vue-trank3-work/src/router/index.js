import Vue from 'vue'
import Router from 'vue-router'
import admin from '@/components/admin'
import PeopleVue from '@/components/people_management/PeopleVue'
import PemissionVue from '@/components/people_management/PemissionVue'
import RoleVue from '@/components/people_management/RoleVue'
import DepartmentVue from '@/components/people_management/DepartmentVue'
import Article from '@/components/article_management/Article'
import Category from '@/components/category_management/CategoryVue'
import Attendance from '@/components/category_management/AttendanceVue'
import Meeting from '@/components/meeting-management/Meeting'
import Room from '@/components/meeting-management/Room'
import LoginVue from '@/components/login/LoginVue'
import Carlist from '@/components/car-management/Carlist'
import Sendlist from '@/components/car-management/Sendlist'
import Garagelist from '@/components/car-management/Garagelist'


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
        },
        // 考勤类别
        {
          path: '/category',
          name: 'Category',
          component: Category,
        },
        // 考勤信息
        {
          path: '/attendance',
          name: 'Attendance',
          component: Attendance,
        },
        {
          path: '/Meeting',
          name: 'Meeting',
          component: Meeting,
        },
        {
          path: '/Room',
          name: 'Room',
          component: Room,
        },
        {
          path: '/LoginVue',
          name: 'LoginVue',
          component: LoginVue,
        },
        {
          path: '/carlist',
          name: 'Carlist',
          component: Carlist,
        },
        {
          path: '/garagelist',
          name: 'Garagelist',
          component: Garagelist,
        },
        {
          path: '/sendlist',
          name: 'Sendlist',
          component: Sendlist,
        }

      ]
    },

  ]
})
