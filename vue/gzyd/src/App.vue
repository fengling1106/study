<template>
  <div id="app">
    <router-link to="/about">关于 \ </router-link>
    <router-link to="/home">首页</router-link>
    <br/>
    <router-link to="/page">测试页</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {

  },
  methods: {

  },
  data () {
    return {
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
  margin-top: 5px;
  width:1400px;
  height: 600px;
  border: rgb(240, 178, 209);
  background-color:rgb(178, 224, 240);
}
</style>
