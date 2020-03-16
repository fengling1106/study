<template>
    <div id="counter" class="mycounter">
      <button class="addbtn"  @click="add">增加</button>
      <button class="decbtn"  @click="dec">减少</button>
      <div>结果：{{ num }}</div>
    </div>
</template>

<script>
export default {
  name: 'ValenCounter',
  props: ['num'],
  methods: {
    add: function () {
      this.$emit('add')
    },
    dec: function () {
      this.$emit('dec')
    }
  },
  data () {
    return {
    }
  }
}

</script>

<style>
  .addbtn{width:100px;height:50px;color:red;font-size:30px;}
  .decbtn{width:100px;height:50px;color:blue;font-size:30px;}
</style>
