// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import Vuex from 'vuex';

// ui 没有引入的话element样式会有问题
//安装命令 npm i element-ui -S
import 'element-ui/lib/theme-chalk/index.css'

//引入离子 星空 需要先安装 npm install vue-particles --save-dev
//然后在App.vue文件加入vue-particles
//参考https://vue-particles.netlify.com/
import VueParticles from 'vue-particles'

import publicMethod from './utils/strUtil'
 
 
Vue.prototype.publicMethod = publicMethod

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(Vuex)
Vue.use(VueParticles) 

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  Vuex,
  components: { App },
  template: '<App/>'
})
