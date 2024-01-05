# jsp/servlet miniProject

목표

- jsp, servlet으로 MVC패턴 이해하기
- MVC(Model, View, Controller) 패턴에서 Controller → Service → Repository패턴을 통해 DB에 값이 저장되는 전체적인 흐름을 JSP와 Servlet으로 구현하기
- html과 css, bootstrap, jsp와 taglib, EL으로 view를 구현 해보기
- Servlet으로 Contoller를 구현
- 구현 기능
    - 로그인
    - 회원 가입
    - 로그아웃
    - 회원 탈퇴
    - 회원별 뉴스 등록
    - 회원별 뉴스 목록
    - 뉴스 삭제


Database

- H2 Database
- JDBC를 통한 NativeQuery

비고

- index와 main 그리고 member는 직접 코딩한 CSS를 이용.
- news 관련 기능들을 bootstrap을 이용.
- java beans의 beanutils를 이용한 파라미터 DTO 매핑은 예제에는 있었으나 제거함
- delete, withdraw같은 삭제하는 흐름도 get매핑으로 동작함…..
- 전체적인 기능은 완성했지만 아직 아쉬운 부분들이 있다. 하지만, 다음 수업을 따라가야하고 또 코딩테스트 공부도 해야하기 때문에 JSP와 Servlet은 이정도만 경험해보고 먼 훗날에 시간이 생기면 아래 내용들을 추가 할 예정이다. (23.08.07 작성)
- 추가하고 싶은 내용
    - RESTful API 개념 적용하기
    - RESTful API 개념을 위한 view 수정하기
    - RESTful API 개념을 도입하면서 JSON형식과 DTO를 통해 MVC패턴 구성하기
    - 모든 기능에 커스텀 예외 클래스 만들어서 예외 처리 해보기 현재 로그인, 회원가입 기능에만 구현함
    - JDBC를 이용한 Join을 통해 뉴스목록에 작성자 이름이 나오게 하기
    - 위의 모든 기능이 구현되면 소스코드 리팩토링과 다듬기 및 주석달기
- 배운점 및 느낌점

  예제에서는 beanutils의 *`populate*()`메서드를 이용했는데 이 메서드는 DAO객체의 필드에 대한 Setter를 만들어 놔야 사용이 가능했다.

  DTO에 Setter를 열어놓고 Beanutils를 이용해서 담고 그리고 DAO로 다시 옮겨서 DB저장하는 흐름으로 코딩하기에는 예외 처리 없이 사용할 수 없어서 오히려 더 복잡해 지는거 같아서 사용하지 않았다.

  excuteQuery() 메서드를 통해 조회쿼리(select문)을 이용할때 배운점

  DB의 들어가있는 값도 하나고 조회 쿼리 자체도 하나만 조회해오는 상황, *`excuteQuery()` 메서드를 통해 ResultSet에 조회 결과를 저장해 리턴 할 때 값이 하나여도 *`next()` 메서드를 한 번 호출해줘야 값을 제대로 리턴할 수 있다. 이거 하나 놓쳐서 진짜 너무 힘들었다.

  Servlet을 이용해 request에서 속성 값을 가져오는 흐름, 한참동안 이해안되던 Session에 로그인한 유저 정보를 담아서 내려보내 주는 흐름, 등을 이해하는 유익한 시간이었다.
