<template>
  <div class="comments">
    <h3>留言</h3>
    <ul>
      <li v-for="comment in comments.slice(1)" :key="comment.id">
        <strong>{{ comment.userName }}</strong>: {{ comment.comments }}
      </li>
    </ul>
    <form @submit.prevent="addComment(ID)">
      <input type="text" v-model="newCommentText" required>
      <button type="submit">Add Comment</button>
    </form>
  </div>
</template>

<script>
import { addcomment } from "@/api.js";
export default {
  props: {
    initialComments: {
      type: Array,
      default: () => [],
    },
    initialID: {
    type: String,
    required: true
  },
  },
  data() {
    return {
      comments: this.initialComments,
      ID: this.initialID,
      newCommentText: "",
    };
  },
  methods: {
    addComment() {
      let postID = this.comments[0].postID;
      addcomment({
        content: this.newCommentText,
        postID: postID
      }).then(() => {
        location.reload();
        }).catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
.comments {
  margin-top: 10px;
  text-align: left;
  color: #ffffff;
}

form {
  margin-top: 10px;
}

input[type="text"] {
  width: 140px;
  padding: 5px;
}
button {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    padding: 6px 12px;
    border: 1px solid #584388;
    border-radius: 8px;
    background: #a67eff;
    background: -moz-linear-gradient(top, #a67eff, #584388);
    background: linear-gradient(to bottom, #a67eff, #584388);
    -webkit-box-shadow: #c797ff 0px 0px 40px 0px;
    -moz-box-shadow: #c797ff 0px 0px 40px 0px;
    box-shadow: #c797ff 0px 0px 40px 0px;
    text-shadow: #342850 1px 1px 1px;
    font: normal normal bold 10px arial;
    color: #ffffff;
    text-decoration: none;
    width: 140px;
    height: 30px;
}
button:hover {
    border: 1px solid ##684fa0;
    background: #c797ff;
    background: -moz-linear-gradient(top, #c797ff, #6a50a3);
    background: linear-gradient(to bottom, #c797ff, #6a50a3);
    color: #ffffff;
    text-decoration: none;
}
</style>
