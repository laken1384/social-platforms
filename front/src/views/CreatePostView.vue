<template>
  <div class="vue">
    <div class="login">
      <h1>This is a login page</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <button type="submit">Login</button>
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
      snackbarMessage: "", // Snackbar 的提示信息
      showSnackbar: false // 控制 Snackbar 的显示状态
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
          this.snackbarMessage = "登录成功";
          this.showSnackbar = true; // 显示 Snackbar
          setTimeout(() => {
            this.showSnackbar = false; // 3秒后隐藏 Snackbar
          }, 10000);
          console.log(response.data);
          this.$router.push("/main");
        })
        .catch(error => {
          // 登录失败或发生错误的处理
          console.error(error);
          this.snackbarMessage = "登录失败，请检查用户名和密码";
          this.showSnackbar = true; // 显示 Snackbar
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
  width: 370px;
  height: 450px;
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

label {
  display: block;
}

input[type="text"],
input[type="password"] {
  width: 30%;
  padding: 5px;
}
.snackbar-container {
  position: fixed;
  left: 50%;
  transform: translateX(-50%);
  bottom: 20px;
  background-color: #333;
  color: #fff;
  padding: 16px;
  border-radius: 4px;
  opacity: 0;
  transition: opacity 0.3s ease;
  z-index: 9999;
}

.snackbar-container.show {
  opacity: 1;
}
</style>