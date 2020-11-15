<template>
  <div id="app">
    <nav-header></nav-header>
    <h2 class="text-center">Vue CLI</h2>
    <router-view></router-view>
  </div>
</template>
<script>
import NavHeader from './components/NavHeader.vue';
export default {
  name: 'App',
  components: {
    NavHeader,
  },
};
</script>
