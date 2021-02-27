# bbs-api (Japanese)/([English](README.md))
掲示板アプリケーション用のRESTful CRUD API。 (Groovy + Spring Boot)

## 環境
- Java 11
- MySQL 8

## ローカルでの実行方法

### 1. このリポジトリをクローン
コマンドプロンプトを開き、以下のgitコマンドを実行してください。
```shell
git clone https://github.com/Tanishy/bbs-api.git
```

### 2. DBとテーブルを作成
1. MySQLサーバーにログインしてください。

2. 以下のSQLを実行し、データベース `bbs` を作成してください。
```
CREATE DATABASE bbs;
```

3. 以下のSQLを実行し、テーブル `message` を作成してください。
   ※このステップは任意です。テーブルはアプリケーション実行時にHibernateによって自動生成されます。
```
CREATE TABLE message (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email varchar(254) NOT NULL,
    subject VARCHAR(40),
    content VARCHAR(400) NOT NULL,
    posted_date DATETIME NOT NULL
);
```

### 3. DB接続設定を変更する
`application.yml` の `username` と `password` を自身のアカウントのものに変更してください。
```yaml
spring:
    dataSource:
        url: jdbc:mysql://localhost:3306/bbs?serverTimezone=JST
        username: YOUR USERNAME
        password: YOUR PASSWORD
```

### 4. サーバーを起動する
コマンドプロンプトを開き、以下のgradleコマンドを実行してください。
```shell
gradlew bootRun
```

### 5. クライアント(アプリケーション、ブラウザ等)からアクセスする

- 全件取得
  - メソッド : GET
  - URL : http://localhost:8080/bbs/api/v1/messages

- 1件取得
  - メソッド : GET
  - URL : http://localhost:8080/bbs/api/v1/message/{メッセージのID}

- 登録
  - メソッド : POST
  - URL : http://localhost:8080/bbs/api/v1/message
  - ボディ : [ペイロードを参照](#登録/更新のペイロード)

- 更新
   - メソッド : PUT
   - URL : http://localhost:8080/bbs/api/v1/message/{メッセージのID}
  - ボディ : [ペイロードを参照](#登録/更新のペイロード)

- 削除
   - メソッド : DELETE
   - URL : http://localhost:8080/bbs/api/v1/message/{メッセージのID}

### 登録/更新のペイロード

フィールド | 概要 | 必須 | 最大長
------|------------|---|---
name | 名前 | ○ | 20
email | メールアドレス | × | 254
subject | 件名 | × | 40
content | 本文 | ○ | 400

### ※注意
サーバー停止時にmessageテーブルは削除されます。
テーブルのレコードを維持したい場合は、 `application.yml` の `jpa.hibernate.ddl-auto` の値を `update` に変更してください。