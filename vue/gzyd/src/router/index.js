import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import About from '@/views/About'
import Home from '@/views/Home'
import Page from '@/views/Page'
import About1 from '@/views/About1'
import About2 from '@/views/About2'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      children: [
        {
          path: 'about1',
          component: About1
        },
        {
          path: 'about2',
          component: About2
        }
      ]
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/page',
      name: 'page',
      component: Page
    }
  ]
})
