<template xmlns:src="http://www.w3.org/1999/xhtml">
  <div>
    <div class="block">
      <el-carousel height="150px">
        <el-carousel-item v-for="item in 3" :key="item">
          <h3>{{item}}</h3>
        </el-carousel-item>
      </el-carousel>
    </div>
    <div>
      <span >{{message}}</span>
      <button v-on:click="select">查询</button>
      <button v-on:click="addUser">新增</button>
      <input v-model="message"/>
    </div>
    <div>
      用户名：<input v-model="username"/>
      密  码：<input v-model="password"/>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      items: ['../assets/logo.png', '../src/assets/angular.jpg', '../src/assets/react.jpg'],
      message: 'asasd asd',
      username: '',
      password: ''
    }
  },
  methods: {
    select: function () {
      /* this.message = this.message.split(' ').reverse().join(' ') */
      var that = this
      this.$axios.post('http://localhost:8080/select', {'username': that.username, 'password': that.password})
        .then(function (res) {
          that.username = res.data.username
          that.password = res.data.password
        })
        .catch(function (err) {
          console.log(err)
        })
    },
    addUser: function () {
      var that = this
      this.$axios.post('http://localhost:8080/addUser', {
        'username': that.username, 'password': that.password
      })
        .then(function (res) {
          that.username = res.data.username
          that.password = res.data.password
        })
        .catch(function (err) {
          console.log(err)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(n) {
    background-color: #99a9bf;
    background-image: url("../assets/react.jpg");
    background-size: 100%;
  }
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
    background-image: url("../assets/logo.png");
    background-size: 100%;
  }
  .el-carousel__item:nth-child(3n) {
    background-color: #99a9bf;
    background-image: url("../assets/angular.jpg");
    background-size: 100%;
  }
</style>
