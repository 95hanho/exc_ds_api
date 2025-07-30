# 엑스퍼트 HR 수강신청 Back

> Svelte 기반 HR 수강신청의 백엔드 서버 프로젝트입니다.
> Spring Boot 기반 REST API 서버로, 로그인 인증, 과정조회 및 설명, 수강신청, 교육생 관리, 프로그램관리 등의 기능을 제공합니다.

## 기술 스택
- **Language/Framework**: Java 17, Spring Boot
- **Build Tool**: Gradle
- **DB**: MariaDB, MySQL
- **ORM/Mapper**: Spring Data JPA, MyBatis
- **보안**: JWT 인증 처리 (`jjwt`)
- **문서화 및 Excel 처리**: Apache POI
- **로깅**: SLF4J + Logback

---

## 환경 구성

- JDK 17 이상 설치
- DB (MariaDB/MySQL) 사전 세팅
- application-exmaple.properties로 application.properties 구성
  - spring.datasource.username
  - spring.datasource.password
  - spring.datasource.url
  - spring.servlet.multipart.location
