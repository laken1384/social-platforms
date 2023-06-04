# social-platforms
 Vuejs+SpringBoot+MySQL
啟動步驟：
 - vue(front): 
```shell=
cd front
npm install
npm run serve
```
 - SpringBoot(backend):
 ```
 cd backend
 mvn clean package
 cd target
 java -jar backend-0.0.1-SNAPSHOT.jar
 ```
 或者用Interllij IDEA啟動也可以
注意：須先啟動MySQL資料庫再啟動後端，不然會接不上資料庫，執行不成功

 - MySQL
 建立MySQL資料庫user=root, password=123456, 數據庫名稱為：social
 可利用資料夾中的DB來建立表及Stored Procedure
 
前端位址：http://127.0.0.1:8081
後端位址：http://127.0.0.1:8889

### 介紹
- 使用者登錄時可先註冊，會返回一個Cookie(Http only不會被JS存取)，以後取得貼文都帶此Cookie取資料。
- 貼文部分分為全部貼文及我的貼文，我的貼文可以做刪除，以及可以新增貼文。
- 留言部份僅於前端呈現，時間不足無法及時接上後端，日後有時間會再做修正。
### 特色
- 有做參數化查詢，防止SQL Injection
- 利用Stored Procedure阻止XSS攻擊

### 功能介面

登入畫面：

<img width="800" alt="截圖 2023-06-04 23 22 24" src="https://github.com/laken1384/social-platforms/assets/43467156/04678f29-ee5f-4249-aad9-04657f238a64">

註冊畫面：

<img width="800" alt="截圖 2023-06-04 23 23 11" src="https://github.com/laken1384/social-platforms/assets/43467156/169c2d1e-dfd3-4482-877d-015b93797ab2">

可看到全部貼文：

<img width="800" alt="截圖 2023-06-04 23 25 09" src="https://github.com/laken1384/social-platforms/assets/43467156/3c322e2b-2d9a-4343-91bb-5e9d9cc0b410">

可看到自己的貼文：
   - 右上角的叉叉可以刪除貼文
   - 下方可以新增貼文

<img width="800" alt="截圖 2023-06-04 23 25 19" src="https://github.com/laken1384/social-platforms/assets/43467156/93a2d6b0-0624-4f96-8a5c-2cc8a4e4c735">

