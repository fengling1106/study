<template>
  <div class="about-css">
    这是“关于”页面
    <br>
    <br>
    <br>
    {{ this.$store.state.count }}
    <button @click='incre'>加</button>
    <div>
      <router-link to="/about/about1">about1</router-link>
      <router-link to="/about/about2">about2</router-link>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import store from '../vuex/store.js'
export default {
  name: 'About',
  data () {
    return {
    }
  },
  store,

  methods: {
    incre: function () {
      this.$store.commit('increment')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
  .about-css{width:100%;height:90%;background:rgb(241, 93, 93);}
</style>
