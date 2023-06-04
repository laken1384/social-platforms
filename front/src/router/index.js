import { createRouter, createWebHistory } from "vue-router";
// import HomeView from "../views/HomeView.vue";
const routes = [
  {
    path: "/" ,
    name: "home",
    component: () =>
      import("../views/LoginView.vue"),
  },
  {
    path: "/login" ,
    name: "login",
    component: () =>
      import("../views/LoginView.vue"),
  },
  {
    path: "/main",
    name: "main",
    component: () =>
      import("../views/MainView.vue"),
  },
  {
    path: "/mypost",
    name: "mypost",
    component: () =>
      import("../views/MypostView.vue"),
  },
  {
    path: "/post",
    name: "post",
    component: () =>
      import("../views/CreatePostView.vue"),
  },
  {
    path: "/sginup",
    name: "sginup",
    component: () =>
      import("../views/SginupView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
