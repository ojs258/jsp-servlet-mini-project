# jsp-servlet-mini-project
html, jsp, servlet으로 MVC패턴 익히기

html과 css, bootstrap, jsp와 taglib, EL으로 view를 구현

Servlet으로 Contoller를 구현

구현 기능 
* 로그인
* 회원 가입
* 회원 목록
* 회원 삭제
* 회원 - 뉴스 등록
* 회원 - 뉴스 목록
* 회원 - 뉴스 삭제
* 관리자 - 뉴스 목록
* 관리자 - 뉴스 삭제

Database
* H2Database
* JDBC를 통한 NativeQuery

목표
* MVC + RESTful API개념
* DTO, DAO, Service, Repository 개념

추가 사항  
뉴스 관련 기능은 수업 자료를 보고 작성했습니다.
목표에 어긋나는 방식으로 구현 되어있을 수 있습니다.  
  
Member 관련 기능은 최대한 뉴스 기능의 코드를 참고해 최대한 혼자 만들었습니다.  
멤버는 CSS 뉴스는 Bootstrap을 이용해 view를 꾸몄습니다.  
RESTful API 개념은 jax-rs개념을 이용하고 "org.glassfish.jersey" Dependency를 통해 구현했습니다.