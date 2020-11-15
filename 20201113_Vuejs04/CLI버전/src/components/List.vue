<template>
  <div v-if="items.length">
    <div>
      <input type="text" v-model="search" />
      <button @click="searchList(search)">검색</button>
    </div>
    <table class="table">
      <tr>
        <th>사원 아이디</th>
        <th>사원명</th>
        <th>부서</th>
        <th>직책</th>
        <th>연봉</th>
      </tr>
      <tr v-for="(emp, index) in items" :key="index + '_items'" v-if="emp.name.includes(search)">
        <td>{{ emp.id }}</td>
        <td>{{ emp.name }}</td>
        <td>{{ emp.dept_id }}</td>
        <td>{{ emp.title }}</td>
        <td>{{ emp.salary }}</td>
      </tr>
    </table>

    <div class="text-right">
      <button class="btn btn-primary" @click="goInsert">사원등록</button>
    </div>
  </div>
  <div v-else class="text-center">
    등록된 사원이 존재하지 않습니다.
  </div>
</template>
<script>
import axios from 'axios';
export default {
  name: 'list',
  data() {
    return {
      items: [],
      search: '',
    };
  },
  created() {
    axios
      .get('http://localhost:8097/hrmboot/api/employee/all')
      .then((response) => {
        console.dir(response);
        this.items = response.data;
      })
      .catch((error) => {
        this.error = error;
      });
  },
  methods: {
    goInsert() {
      this.$router.push('/insert');
    },
    searchList(search) {
      console.log(search);
    },
  },
};
</script>
