<template>
  <div class="vue">
    <div class="login">
      <h1>Log IN</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <router-link class="button" to="/sginup">SginUp</router-link>
        <button class="button2" type="submit">Login</button>

      </form>
    </div>
    <div id="snackbarContainer" class="snackbar-container">
      {{ snackbarMessage }}
    </div>
  </div>
</template>

<script>
import { Login } from "@/api.js";

export default {
  name: "LoginPage",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    login() {
      const data = {
        userName: this.username,
        password: this.password
      };
      Login(data)
        .then(response => {
          // 登录成功后的处理
          console.log(response.data);
          this.$router.push("/main");
        })
        .catch(error => {
          // 登录失败或发生错误的处理
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
.login {
  /* 登入頁面的樣式 */
  width: 300px;
  height: 300px;
  background: #8C8CFF;
  border-radius: 50px 5px;
  color: #f0f0f0;
}
.vue {
  display: flex;
  justify-content: center;
  align-items: center;

}
.form-group {
  margin-bottom: 10px;
}
.button {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    padding: 12px 24px;
    border: 1px solid #a12727;
    border-radius: 8px;
    background: #ff4a4a;
    background: -moz-linear-gradient(top, #ff4a4a, #992727);
    background: linear-gradient(to bottom, #ff4a4a, #992727);
    -webkit-box-shadow: #ff5959 0px 0px 40px 0px;
    -moz-box-shadow: #ff5959 0px 0px 40px 0px;
    box-shadow: #ff5959 0px 0px 40px 0px;
    text-shadow: #591717 1px 1px 1px;
    font: normal normal bold 20px arial;
    color: #ffffff;
    text-decoration: none;
}
.button:hover{
    background: #ff5959;
    background: -moz-linear-gradient(top, #ff5959, #b62f2f);
    background: linear-gradient(to bottom, #ff5959, #b62f2f);
    color: #ffffff;
    text-decoration: none;
}
.button2 {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    padding: 12px 24px;
    border: 1px solid #258f7e;
    border-radius: 8px;
    background: #3ce9cc;
    background: -moz-linear-gradient(top, #3ce9cc, #258f7e);
    background: linear-gradient(to bottom, #3ce9cc, #258f7e);
    -webkit-box-shadow: #37d7bc 0px 0px 40px 0px;
    -moz-box-shadow: #37d7bc 0px 0px 40px 0px;
    box-shadow: #37d7bc 0px 0px 40px 0px;
    text-shadow: #175a4f 1px 1px 1px;
    font: normal normal bold 20px arial;
    color: #ffffff;
    text-decoration: none;
}
.button2:hover {
    border: 1px solid #2eb39d;
    background: #48fff5;
    background: -moz-linear-gradient(top, #48fff5, #2cac97);
    background: linear-gradient(to bottom, #48fff5, #2cac97);
    color: #ffffff;
    text-decoration: none;
}
label {
  display: block;
  font-size: 20px;
}

input[type="text"],
input[type="password"] {
  -webkit-appearance: none;
  width: 70%;
  padding: 5px;
}
</style>