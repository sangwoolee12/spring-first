# 📘 Hello Spring Boot

Spring Boot를 이용해 기본적인 웹 애플리케이션 구조를 연습한 프로젝트입니다.  
강의를 들으며 스프링 부트의 실행 방식, 컨트롤러, 요청/응답 처리, 쿼리 스트링, 경로 변수, 객체 기반 JSON 응답 등을 직접 실습했습니다.

## 🧠 학습 내용
- Spring Boot 프로젝트 생성 및 실행
- `@RestController`, `@GetMapping`을 이용한 요청 처리
- JSON 형태의 응답 반환
- `@RequestParam`을 활용한 쿼리 스트링 처리
- `@PathVariable`을 활용한 경로 변수 처리
- 객체를 반환하여 JSON으로 자동 변환하는 방식 이해
- Gradle을 이용한 빌드 및 실행

## 📂 주요 기능
- `/hello` : 기본 인사 메시지 반환
- `/goodbye` : 작별 메시지 반환
- `/info` : JSON 데이터 반환
- `/welcome?name=...` : 쿼리 스트링으로 전달받은 이름 출력
- `/books?page=...&line=...` : 여러 개의 쿼리 스트링 처리
- `/hello/{name}` : 경로 변수를 사용한 인사 메시지 반환
- `/cube/{side}/{count}` : 경로 변수 기반 계산 결과 반환
- `/message/object` : 객체를 JSON으로 자동 변환하여 반환

## 🔧 실행 방법

### IntelliJ에서 실행
`HelloApplication.java`의 `main` 메소드를 실행하면 서버가 시작됩니다.

### 터미널에서 실행
```bash
./gradlew bootRun
```

## ✍️ 느낀 점

직접 요청을 받고 응답을 반환하는 과정을 구현해보면서,
스프링 부트가 웹 애플리케이션 개발에서 반복되는 설정을 많이 줄여준다는 점을 체감할 수 있었습니다.
특히 쿼리 스트링, 경로 변수, JSON 응답 방식의 차이를 실습으로 확인할 수 있어 기본적인 REST API 동작 방식을 이해하는 데 도움이 되었습니다.
