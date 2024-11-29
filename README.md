# 채팅 프로그램 V2

## 프로젝트 설명
[김영한의 실전 자바 - 고급 2편, I/O, 네트워크, 리플렉션](https://www.inflearn.com/course/%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B3%A0%EA%B8%89-2/dashboard) 강의를 기반으로 채팅 프로그램 업그레이드하여 개발했습니다.

### 개요

- 기간: 2024.11.22 - 2024.11.27
- 팀원: 김준영(BE)

### 프로젝트 목표 

* V1 클론 코딩의 단순 구현을 넘어 **RoomManager**라는 새로운 구조를 도입하여, **Room**을 생성하고 관리하는 시스템으로 변경했습니다. 이를 통해 각 채팅방이 독립적으로 작동하며 효율적으로 관리될 수 있도록 구조를 개선했습니다.

## 기술 스택

* **Language** : Java 21

* **Environment** : IntelliJ, Git, GitHub

## 주요 기능
**방 생성 기능**
  - 비밀번호 설정 가능
  - 방 이름 지정 가능
    
**방 입퇴장 기능**

**사용자 이름 변경 기능**
  - **방 내부**와 **방 외부**에서 이름 변경 가능
    
**사용자 조회**
  - **방 외부:** 전체 사용자 목록 조회
  - **방 내부:** 해당 방의 사용자 목록 조회

## 화면 구성 

**방 외부에서 이름 변경**

![1)이름변경](https://github.com/user-attachments/assets/f8f15fd7-2c33-44d7-84f6-d61ffdf1df96)

**방 생성 및 조회**

![2)방생성및조회](https://github.com/user-attachments/assets/fcfc8a7b-5fa9-4608-b2d3-9af36752e36b)

**방 입장**

![3)방들어가기](https://github.com/user-attachments/assets/695c8b06-2fdb-4254-a848-88d0b4d4810a)


**방 내부에서 이름 변경**

![4)방에서이름변경및인사](https://github.com/user-attachments/assets/6570cf18-94a4-4860-98be-54116be2320c)


**방 퇴장**

![5)방떠나기](https://github.com/user-attachments/assets/256c65f1-6fdf-4ad4-9a2f-7a0e81ade4f6)


**방 외/내부 사용자 조회**


![6)인원조회](https://github.com/user-attachments/assets/3b69124d-f49e-47e2-8aed-878519d4f29b)
