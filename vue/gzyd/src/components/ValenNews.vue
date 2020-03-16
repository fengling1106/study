<template>
    <div class="news_box">
      <h1 class="h1_show">新闻标题：{{title}}</h1>
      <p class="content_show">新闻内容：{{content}}</p>
      <input class="in_title" type="text"     v-model="title">
      <input class="in_content" type="text"   v-model="content">
      <input class="button" type="button"  v-on:click="change" v-model="message">
    </div>
</template>

<script>
export default {
  name: 'ValenNews',
  props: {
    title: {
      type: String,
      default: 'your news title'
    },
    content: {
      type: String,
      default: 'news content'
    }
  },
  methods: {
    change: function () {
      if (this.message === '未提交') {
        this.message = '已提交'
      } else {
        this.message = '未提交'
      }
    }
  },
  data () {
    return {
      message: '未提交'
    }
  }
}

</script>

<style>
  .h1_show{color:red}
  .content_show{color:green;font-size:30px;}
  .button{width:80px;height:30px;background-color:blue;}
</style>
