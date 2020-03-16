<template>
    <div id="flyer-list">
      <ul>
        <li v-for="(item, index) in list" :key="index">{{ index }}: {{ item }}</li>
      </ul>
    </div>
</template>

<script>
export default {
  name: 'ValenList',
  data () {
    return {
      list: ['apple', 'pear', 'banana']
    }
  }
}
</script>

<style>

</style>
