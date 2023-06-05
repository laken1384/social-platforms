<template>
  <div class="home">
    <div class="user-profile">
      <router-link to="/mypost">我的貼文</router-link> |
      <router-link to="/login">登出</router-link>
    </div>
    <div class="posts">
      <div class="post" v-for="post in posts" :key="post.id">
        <div style="display: flex;justify-content: center;">
          <h2>{{ post.title }}</h2>

        </div>
        <p>{{ post.username + " : 於" + post.createdAt + "發布"}}</p>
        <p>{{ post.context }}</p>
        <comment :initial-comments="post.comment"></comment>
      </div>
    </div>
  </div>
</template>

<script>
import Comment from "@/components/CommentSection.vue";
import { allpost } from "@/api.js"
import '@fortawesome/fontawesome-free/css/all.css'; // 引入Font Awesome的CSS样式
export default {
  name: "HomePage",
  components: {
    Comment,
  },
  data() {
    return {
      title: "",
      context: "",
      posts: [],
      newCommentText: "",
      showDialog: false,
    }
  },
  mounted() {
    this.fetchPosts(); // 在 mounted 生命周期钩子中调用获取数据的方法
  },
  methods: {
    fetchPosts() {
        allpost()
        .then((response) => {
          let data = response.data; // 将获取到的数据赋值给组件的 data 属性
          let datasort = data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));
          this.posts = datasort.map(a => {
            let b = a.comment
            a.comment = [{postID: a.postID}, ...b];
            return a;
          });
          console.log(datasort);
        }).catch((error) => {
          console.error(error);
        });
      },
    addComment(post) {
      const newComment = {
        id: Date.now(),
        text: this.newCommentText,
      };
      post.comments.push(newComment);
      this.newCommentText = "";
    },
  },
};
</script>

<style scoped>
.home {
  /* 頁面的樣式 */
}

.user-profile {
  background: #d6fbae;
  color: #f0f0f0;
  padding: 10px;
  height: 20px;
  display: inline-block;
  vertical-align: middle;
  padding: 12px 24px;
  border: 1px solid #96b07a;
  border-radius: 8px;
  background: #d6fbae;
  background: -moz-linear-gradient(top, #d6fbae, #96b07a);
  background: linear-gradient(to bottom, #d6fbae, #96b07a);
  -webkit-box-shadow: #ffffd1 0px 0px 40px 0px;
  -moz-box-shadow: #ffffd1 0px 0px 40px 0px;
  box-shadow: #ffffd1 0px 0px 40px 0px;
  text-shadow: #ffffe2 1px 1px 1px;
  font: normal normal bold 20px arial;
  color: #111111;
  text-decoration: none;
  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
.form-group {
  margin-bottom: 10px;
  text-align: left;
  color: #ffffff;
}
input[type="text"],
input[type="textarea"] {
  -webkit-appearance: none;
  width: 70%;
  padding: 5px;
}
.posts {
  margin-top: 20px;
  color: #ffffff;
}

.post {
  margin-bottom: 20px;
  margin-right: 20px;
  margin-left: 20px;
  border: 2px solid white;
}

.post h2 {
    text-decoration: underline;
}

.button {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    padding: 6px 12px;
    border: 1px solid #258f81;
    border-radius: 8px;
    background: #3ce9d1;
    background: -moz-linear-gradient(top, #3ce9d1, #258f81);
    background: linear-gradient(to bottom, #3ce9d1, #258f81);
    -webkit-box-shadow: #37d7c1 0px 0px 40px 0px;
    -moz-box-shadow: #37d7c1 0px 0px 40px 0px;
    box-shadow: #37d7c1 0px 0px 40px 0px;
    text-shadow: #175a51 1px 1px 1px;
    font: normal normal bold 10px arial;
    color: #ffffff;
    text-decoration: none;
    height: 30px;
}
.button:hover {
    border: 1px solid #2eb3a1;
    background: #48fffb;
    background: -moz-linear-gradient(top, #48fffb, #2cac9b);
    background: linear-gradient(to bottom, #48fffb, #2cac9b);
    color: #ffffff;
    text-decoration: none;
}
</style>
