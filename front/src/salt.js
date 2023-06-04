import { SHA256 } from 'crypto-js';
let salt = "826c584d-d5b8-4f2e-ac8b-88c182fe6dc5"
function hashWithSalt(password) {
  const saltedPassword = password + salt; // 将密码和盐值组合
  const hashedPassword = SHA256(saltedPassword).toString(); // 使用SHA256进行哈希处理并转为字符串
  return hashedPassword;
}

export default hashWithSalt;