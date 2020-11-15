export default {
  template: `
    <div>
        <table>
        <tr>
            <td>이름</td>
            <td>
                <input type="text" id="name" ref="name" v-model="name">
            </td>
        </tr>
        <tr>
            <td>이메일</td>
            <td>
                <input type="text" id="mailid" ref="mailid" v-model="mailid">
            </td>
        </tr>
        <tr>
            <td>고용일</td>
            <td>
                <input type="date" id="start_date" ref="start_date" v-model="start_date">
            </td>
        </tr>
        <tr>
            <td>관리자</td>
            <td>
                <select ref="manager_id" id="manager_id" v-model="manager_id">
                    <option value="1">관리자1</option>
                    <option value="2">관리자2</option>
                    <option value="3">관리자3</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>직책</td>
            <td>
                <select ref="title" id="title" v-model="title">
                    <option value="사장">사장</option>
                    <option value="기획부장">기획부장</option>
                    <option value="영업부장">영업부장</option>
                    <option value="총무부장">총무부장</option>
                    <option value="인사부장">인사부장</option>
                    <option value="과장">과장</option>
                    <option value="영업대표이사">영업대표이사</option>
                    <option value="사원">사원</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>부서</td>
            <td>
                <select ref="dept_id" id="dept_id" v-model="dept_id">
                    <option value="110">기획부1</option>
                    <option value="111">기획부2</option>
                    <option value="112">기획부3</option>
                    <option value="113">기획부4</option>
                    <option value="102">영업부1</option>
                    <option value="103">영업부2</option>
                    <option value="104">영업부3</option>
                    <option value="105">영업부4</option>
                    <option value="101">총무부1</option>
                    <option value="118">인사부1</option>
                    <option value="120">회계부5</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>월급</td>
            <td>
                <input type="text" id="salary" ref="salary" v-model="salary">
            </td>
        </tr>
        <tr>
            <td>커미션</td>
            <td>
                <input type="commission" id="commission_pct" ref="commission_pct" v-model="commission_pct">
            </td>
        </tr>
        </table>
        <button @click="insert">사원추가</button>
        <button @click="list">사원목록</button>
    </div>
    `,
  data() {
    return {
      id: '',
      name: '',
      mailid: '',
      start_date: '',
      manager_id: '',
      title: '',
      dept_id: '',
      salary: '',
      commission_pct: '',
    };
  },
  methods: {
    insert() {
      axios
        .post('http://localhost:8097/hrmboot/api/employee', {
          name: this.name,
          mailid: this.mailid,
          start_date: this.start_date,
          manager_id: this.manager_id,
          title: this.title,
          dept_id: this.dept_id,
          salary: this.salary,
          commission_pct: this.commission_pct,
        })
        .then(() => {
          alert('등록이 완료되었습니다.');
          this.list();
        })
        .catch((error) => {
          this.error = error;
        });
    },
    list() {
      this.$router.push('/list');
    },
  },
};
