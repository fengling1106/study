<template>
    <div id="compute">
      <input type="" name="" v-model="firstNumber">
      <input type="" name="" v-model="secondNumber">
      <div id = "cpuresult">结果是：{{ result }}</div>
      <div id = "changecount">变化次数：{{count}} </div>
    </div>
</template>

<script type="text/javascript">
export default {
  name: 'ValenAdd',
  data () {
    return {
      firstNumber: 0,
      secondNumber: 0,
      count: 0
    }
  },
  computed: {
    result: function () {
      return Number(this.firstNumber) + Number(this.secondNumber)
    }
  },
  watch: {
    result: function () {
      this.count++
    }
  }
}
</script>

<style>

</style>
