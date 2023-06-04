import axios from 'axios';

const API_SERVER = 'http://127.0.0.1:8889';

const login = axios.create({
  baseURL: API_SERVER,
  withCredentials: true,  // 跨域請求時包含 Cookie
  headers: {
    'Content-Type': 'application/json'
  }
});

export const Login = (cell) => login.post('/login', cell);
export const Sginup = (cell) => login.post('/signup', cell);
export const personpost = () => login.post('/personpost');
export const allpost = () => login.get('/allpost');

export const addContext = (cell) => login.post('/create_post', cell);
export const delpost = (cell) => login.post('/delpost', cell);