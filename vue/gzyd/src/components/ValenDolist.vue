<template>
    <div id="dolist">
      <input type="text" name="" v-model="username">
      <input type="button" @click="submit" value="提交">
      <ul>
        <li v-for="(item,index) in list" :key="index">{{ item }}</li>
      </ul>
    </div>
</template>

<script type="text/javascript">
export default {
  name: 'ValenDolist',
  data () {
    return {
      username: '',
      list: []
    }
  },
  methods: {
    submit: function () {
      this.list.push(this.username)
      this.username = ''
    }
  }
}
</script>

<style>

</style>
