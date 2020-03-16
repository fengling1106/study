<template>
  <div id="app">
    <router-link to="/about">关于 \ </router-link>
    <router-link to="/home">首页</router-link>
    <router-view/>
    <v-news :title="title" :content="content"></v-news>
    <v-list></v-list>
    <v-add></v-add>
    <v-dolist></v-dolist>
    <v-counter :num="num" @add="add" @dec="dec"></v-counter>
  </div>
</template>

<script>
import ValenNews from './components/ValenNews.vue'
import ValenList from './components/ValenList.vue'
import ValenAdd from './components/ValenAdd.vue'
import ValenDolist from './components/ValenDolist.vue'
import ValenCounter from './components/ValenCounter.vue'

export default {
  name: 'App',
  components: {
    'v-news': ValenNews,
    'v-list': ValenList,
    'v-add': ValenAdd,
    'v-dolist': ValenDolist,
    'v-counter': ValenCounter
  },
  methods: {
    add: function () {
      this.num++
    },
    dec: function () {
      this.num--
    }
  },
  data () {
    return {
      title: '全球股市大跌',
      content: '因为俄罗斯与沙特干架，所以股市大跌',
      num: 0
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  background-color:deepskyblue;
}
</style>
