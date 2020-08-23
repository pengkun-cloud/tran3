// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// 引入element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

// 引入axios，并加到原型链中
import axios from 'axios'
import QS from 'qs'
Vue.prototype.$axios = axios
Vue.prototype.$qs = QS

//引入js-cookie
import Cookies from 'js-cookie'

// 把cooke发送到服务器
axios.defaults.withCredentials = false

axios.default.withCredentials = true

axios.interceptors.request.use(function (config) {
  var token = Cookies.get('token')
  config.headers['x-auth'] = token
  console.log(config)
  return config
})
axios.interceptors.response.use(function (config) {
  // if (config.data.code === 202) {
  //   location.href = '/LoginVue'
  // }

  return config
  // return config
})


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
