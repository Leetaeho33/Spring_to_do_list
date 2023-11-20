# TO_DO_LIST
할일카드 프로젝트

스프링 프레임워크로 구현한 프로젝트입니다.

**프로젝트 설명**

회원제로 이루어는 프로젝트입니다. 회원가입이 된 유저는 할일 카드 작성을 하여 오늘의 할일을 관리할 수 있습니다.
완료한 할일은 할일 완료 요청을 해 상태를 변경할 수 있습니다.
회원들은 서로의 할일 카드에 댓글을 달며 소통할 수 있습니다. 

**회원 별 인증/인가에 따라 주어지는 권한입니다.** 

회원 인증이 필요 하지 않은 권한
- 전체 할일 카드 조회
- 선택 유저 할일 카드 조회

회원 인증이 성공한 회원에 주어지는 권한.
- 할일 카드 작성
- 할일 카드에 댓글 작성

회원 인증이 성공, 해당 할일 카드의 작성자에게 주어지는 권한
- 할일 카드 완료 여부 체크
- 할일 카드 수정
- 할일 카드 삭제

회원 인증이 성공, 해당 할일 카드의 댓글 작성자에게 주어지는 권한
- 할일 카드 댓글 수정

- 할일 카드 댓글 삭제

**구현에 사용된 기술들**

JWT를 통해 회원의 인증/인가를 확인합니다.
JPA를 이용하여 DB와 자바의 객체를 연결했습니다.
Entity의 관계를 설정하고, 영속성 전이를 이용하여 관리합니다.

**테스트 방식**
POST맨으로 API 요청을 보내고, 응답을 받았습니다.

ERD입니다
![TO DO LIST (2)](https://github.com/Leetaeho33/Spring_to_do_list/assets/148296128/60794a3c-bc29-4292-82a3-18e48249c48e)

USER와 CARD는 1:N의 관계, CARD와 COMMENT는 1:N 관계, USER와 COMMENT는 1:N 관계입니다.

**API 명세서**
https://documenter.getpostman.com/view/30925785/2s9Ye8fuxj

