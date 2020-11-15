import Vue from 'vue';
import VueRouter from 'vue-router';
import Insert from '@/components/Insert.vue';
import List from '@/components/List.vue';
import Index from '@/components/Index.vue';

Vue.use(VueRouter);

export const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
    },
    {
      path: '/list',
      name: 'list',
      component: List,
    },
    {
      path: '/insert',
      name: 'insert',
      component: Insert,
    },
  ],
});
