<template>
  <div class="page">
    <v-news :title="title" :content="content"></v-news>
    <v-list></v-list>
    <v-add></v-add>
    <v-dolist></v-dolist>
    <v-counter :num="num" @add="add" @dec="dec"></v-counter>
  </div>
</template>

<script>
import ValenNews from '../components/ValenNews.vue'
import ValenList from '../components/ValenList.vue'
import ValenAdd from '../components/ValenAdd.vue'
import ValenDolist from '../components/ValenDolist.vue'
import ValenCounter from '../components/ValenCounter.vue'

export default {
  name: 'Page',
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
  .page{width:100%;height:90%;background:rgb(93, 128, 241);}
</style>
