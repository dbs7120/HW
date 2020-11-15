import Insert from './components/Insert.js';
import List from './components/List.js';
import Index from './components/Index.js';

export default new VueRouter({
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
