<template>
  <div class="dialog" v-if="isOpen">
    <input type="text" v-model="text1">
    <input type="text" v-model="text2">
    <button @click="closeDialog">关闭</button>
  </div>
</template>

<script>
export default {
  name: "DialogBox",
  data() {
    return {
      isOpen: false,
      text1: "",
      text2: "",
    };
  },
  methods: {
    openDialog() {
      this.isOpen = true;
    },
    closeDialog() {
      this.isOpen = false;
    },
  },
};
</script>

<style scoped>
.dialog {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: #ffffff;
  padding: 20px;
}
</style>
