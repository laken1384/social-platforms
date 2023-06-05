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
- 可於文章下方留言，回顯示留言者帳號名稱及內容。
### 特色
- 有做參數化查詢，防止SQL Injection
- 利用Stored Procedure阻止XSS攻擊

### 功能介面

登入畫面：

<img width="800" alt="截圖 2023-06-05 10 53 40" src="https://github.com/laken1384/social-platforms/assets/43467156/b4705923-564e-47f6-b648-86702019d630">


註冊畫面：

<img width="800" alt="截圖 2023-06-05 10 53 54" src="https://github.com/laken1384/social-platforms/assets/43467156/180ba613-1a2b-45e7-8771-1350da04a7f4">


可看到全部貼文，上方可作切換，看到自己發的文：

<img width="800" alt="截圖 2023-06-05 10 53 07" src="https://github.com/laken1384/social-platforms/assets/43467156/892c571d-af43-4fd5-a86a-9db35684fdec">


可看到自己的貼文：
   - 右上角的叉叉可以刪除貼文
   - 下方可以新增貼文

<img width="800" alt="截圖 2023-06-05 10 53 29" src="https://github.com/laken1384/social-platforms/assets/43467156/195ab463-a96e-47ca-9492-7765b7a6fbf9">


