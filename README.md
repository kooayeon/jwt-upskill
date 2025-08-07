## 1. 프로젝트 개요
- **트랙**: 인증/인가
- **목표**: Spring Security + JWT 기반 사용자 인증/인가, OAuth2(구글/카카오/네이버) 소셜 로그인
- **현재 구현**:
  - JWT 로그인 (Access/Refresh 발급)
  - 회원가입, 로그인, 토큰 재발급 API
  - 인증 기반 `/user/me` 보호 API
- **배포 진행 상황**:
  - Docker + EC2 환경 구성 완료
  - GitHub Actions CI/CD 파이프라인 작성
  - EC2에서 컨테이너 기동 중 MySQL 연결 이슈로 최종 배포 미완성
  - 로컬 환경에서는 정상 동작 확인

## 2. 기술 스택
- **언어**: Java 17
- **프레임워크**: Spring Boot 3.2, Spring Security, Spring Data JPA
- **DB**: MySQL 8.0
- **인프라**: Docker, Docker Compose, AWS EC2, GitHub Actions
- **기타 라이브러리**: jjwt, OAuth2 Client, Lombok

## 3. 기능 요약
| Method | Endpoint     | 설명 |
|--------|--------------|------|
| POST   | /auth/signup | 회원가입 |
| POST   | /auth/login  | JWT 발급 (AT/RT) |
| POST   | /auth/refresh| 토큰 재발급 |
| GET    | /user/me     | 현재 사용자 정보 (JWT 인증 필요) |

- API 명세서: [링크 또는 Swagger URL]

## 4. 로컬 실행 방법
```bash
# 1. .env 생성 (예시)
DB_HOST=db
DB_PORT=3306
DB_NAME=jwt_upskill
DB_USERNAME=springuser
DB_PASSWORD=2930
JWT_SECRET=랜덤시크릿키

# 2. 빌드 & 실행
docker-compose up -d --build

미완성 사유: MySQL 컨테이너 재생성 버그 발생 → 배포 마무리 실패
