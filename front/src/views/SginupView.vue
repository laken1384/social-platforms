<template>
  <div class="vue">
    <div class="login">
      <h1>Sgin Up</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="phone">Phone:</label>
          <input type="number" inputmode="numeric" id="phone" v-model="phone" required>
        </div>
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" v-model="email" required>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <button class="button" type="submit">Submit</button>
        <router-link class="button2" to="/login">back</router-link>


      </form>
    </div>
    <div id="snackbarContainer" class="snackbar-container">
      {{ snackbarMessage }}
    </div>
  </div>
</template>

<script>
import { Sginup } from "@/api.js";
// import { hashWithSalt } from "@/salt.js"
export default {
  name: "LoginPage",
  data() {
    return {
      username: "",
      password: "",
      snackbarMessage: "", // Snackbar 的提示信息
      showSnackbar: false // 控制 Snackbar 的显示状态
    };
  },
  methods: {
    login() {
      const data = {
        userID: this.phone,
        userName: this.username,
        email: this.email,
        password: this.password
      };
      Sginup(data)
        .then(response => {
          // 登录成功后的处理

          console.log(response.data);
          this.$router.push("/main");
        })
        .catch(error => {
          // 登录失败或发生错误的处理
          console.error(error);
          setTimeout(() => {
            this.showSnackbar = false; // 3秒后隐藏 Snackbar
          }, 3000);
        });
    },
  },
};
</script>

<style scoped>
.login {
  /* 登入頁面的樣式 */
  width: 300px;
  height: 400px;
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
input[type="password"],
input[type="email"],
input[type="number"] {
  -webkit-appearance: none;
  width: 70%;
  padding: 5px;
}
input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
input[type="number"] {
  -moz-appearance: textfield;
}
</style>