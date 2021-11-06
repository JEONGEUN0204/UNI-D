## 개발환경
* Windows 10
* Node.js 16.13.0
* MySQL 8.0
## Server 프로젝트 구조
* models : sequelize 사용에 필요한 데이터 모델을 정의
* routes : 각 API에 대한 라우팅을 진행
* config : 서버 구성에 필요한 설정값 세팅
## Server 환경 세팅
* Node.js & MySQL 설치
* 해당 repository `git clone` 하기
* `server` 폴더로 이동하여 `npm install` 명령어 수행
* MySQL에서 `create.sql` 파일을 통해 프로그램 실행에 필요한 테이블을 생성
* `config.json` 파일을 사용자 환경에 맞춰서 세팅
* `npm start` 명령어로 서버 실행
----
## SQL 데이터 테이블 설계

## 서버 API 문서 정리
* 회원가입 : `/member` (post)
  * request example
    ```
    {
        "name": "박인서",
        "nickname": "inclue",
        "password": "abcd1234",
        "telephone": "01012345678",
        "university_id": 5
    }
    ```
  * response example
    ```
    status code : 201
    {}
    ```

* 회원정보 보기 : `/member/{id}` (get)
  * request example
    ```
    {}
    ```
  * response example
    ```
    status code : id가 존재하면 200, 존재하지 않으면 404
    {
        "university_id": 5,
        "name": "박인서",
        "nickname": "inclue",
        "telephone": "01012345678",
        "point": 0
    }
    ```

* 회원정보 수정 : `/member/{id}` (put)
  * request example
    ```
    {
        "password": "abcde12345",
        "telephone": "01010101010"
    }
    ```
  * response example
    ```
    status code : id가 존재하면 200, 존재하지 않으면 404
    {}
    ```

* 로그인 : `/login` (get)
  * request example
    ```
    {
        "nickname": "inclue",
        "password": "abcd1234"
    }
    ```
  * response example
    ```
    status code : 로그인 성공 시 200, 실패 시 404
    {}
    ```

* 이메일 보내기 : `/mail/send` (post)
  * request example
    ```
    {
        "email": "wb092311@cau.ac.kr"
    }
    ```
  * response example
    ```
    status code : 메일 보내기 성공 시 200, 실패 시 404
    {}
    ```

* 이메일 보내기 : `/mail/check` (get)
  * request example
    ```
    {
        "email": "wb092311@cau.ac.kr",
        "authcode": 174631
    }
    ```
  * response example
    ```
    status code : 200
    {
        "check": true
    }
    ```
