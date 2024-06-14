![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/f32ad5b3-8edb-4ff8-b32e-0863e6cdf667)
<br>


<div align="center">

### UAM(Urban Air Mobility)은 도시 공간에서 공중 이동을 가능하게 하는 차세대 교통수단으로 UAM 관제사, 교통관리서비스 제공자가 사용해야할 모니터링 시스템을 제안합니다.

</div>

![완성본](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/19da0b84-daaa-4f79-9ae7-2ef732e8df8d)

1️⃣ [개요](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EA%B0%9C%EC%9A%94) <br>

2️⃣ [기능](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EA%B8%B0%EB%8A%A5) <br>

3️⃣ [UML](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#%EF%B8%8F-uml) <br>

4️⃣ [시스템 아키텍쳐](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90) <br>

5️⃣ [기술스택](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EA%B8%B0%EC%88%A0-%EC%8A%A4%ED%83%9D) <br>

6️⃣ [서버스펙](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#%EF%B8%8F-%EC%84%9C%EB%B2%84-%EC%8A%A4%ED%8E%99) <br>

7️⃣ [소프트웨어 아키텍쳐](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4-%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90) <br>

8️⃣ [데이터 설계](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%84%A4%EA%B3%84) <br> 

9️⃣ [클래스 다이어그램](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8) <br>

🔟 [결과](https://github.com/sami355-24/uam_monitoring_backend?tab=readme-ov-file#-%EA%B2%B0%EA%B3%BC) <br>

---


# 👋 개요

> 본 프로젝트는 도시 공간에서 하늘로의 이동을 가능하게 하는 차세대 교통수단인 UAM (Urban Air Mobility)에 대한 모니터링 시스템 개발에 초점을 맞추고 있습니다.
> 현재 항공 교통관제 시스템이 존재하지만, 항공기는 운행 고도와 공간 밀집도 등과 같이 UAM과는 다른 특성을 가지고 있어 UAM의 안정적인 운행과 도시에서의 운용을
> 위해서는 새로운 모니터링 시스템이 필요합니다. 본 프로젝트에서는 기존의 항공 데이터를 기반하여 UAM 모니터링에 필요한 데이터를 구성하는 방법을 제안하고,
> UAM 생태계에 기여할 수 있는 UAM 모니터링 시스템의 프로토타입을 개발하고자 합니다.

---

# 📱 기능

⚠️ [원본 레포지토리](https://github.com/uam-monitoring/monitoring_backend)와 달리 본 레포지토리는 제가 구현한 것 위주로 작성하였습니다.

- 비행체의 이동 정로를 실시간으로 조회할 수 있다.
- 확장 가능한 시스템과 다수의 동시 사용자 및 항공기를 처리할 수 있다.
- 실시간 비행정보(UAM ADS-B)를 저장, 조회, 삭제, 클라이언트에게 전송할 수 있다.
- 특정 UAM의 비행 예정 정보(UAM FIXM)를 저장, 조회할 수 있어야 한다.

---

# 🎞️ UML

⚠️ 제가 구현한 것 위주로 작성하였습니다.

## 유스케이스

### ADS-B 확인하기

| 시스템 제목 | UAM 모니터링 시스템                                              |
|--------|-----------------------------------------------------------|
| 액터     | 로그인한 사용자                                                  |
| 시작 조건  | 로그인한 사용자가 모니터링 시스템에 접속해야 한다.                              |
| 흐름     | 1. 로그인한 사용자가 모니터링 시스템에 접속한다.                              |
|        | 2. 모니터링 시스템은 ADS-B를 전부 가져온다.                              |
|        | 3. ADS-B들을 가져오고 클라이언트에게 정보들을 보내 위도, 경도, 고도를 하나의 화면에 보여준다. |

### 비행을 완료한 UAM에 대한 기록 시스템에서 지우기

| 시스템 제목 | UAM 모니터링 시스템                                        |
|--------|-----------------------------------------------------|
| 액터     | UAM                                                 |
| 시작 조건  | UAM이 비행 종료 신호를 모니터링 서버에 보낸다.                        |
| 흐름     | 1. 비행중인 UAM이 비행 종료 신호를 보낸다.                         |
|        | 2. 중앙 모니터링 서버는 DB에 존재하는 해당 UAM의 ADS-B 데이터를 전부 삭제한다. |
|        | 3. 현재 접속중인 클라이언트들에게 비행완료한 UAM의 정보를 보낸다.             |

### 특정 UAM의 FIXM정보를 확인하기

| 시스템 제목 | UAM 모니터링 시스템                                     |
|--------|--------------------------------------------------|
| 액터     | 로그인한 사용자                                         |
| 시작 조건  | 비행중인 UAM에 마우스 호버링을 한다.                           |
| 흐름     | 1. 로그인한 사용자가 비행중인 UAM에 마우스 호버링을 한다.              |
|        | 2. 시스템은 해당 UAM의 FIXM을 가져온다.                      |
|        | 3. 가져온 FIXM을 로그인한 사용자의 화면에 보여준다.                 |
|        | 4. 마우스의 호버링을 종료하면 사용자의 화면에 FIXM을 보여주기 이전으로 돌아간다. |

## 유스케이스 다이어그램

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/52f04aab-0d0d-485a-95bd-db88e2fba7b5)

---

# 🏗 시스템 아키텍쳐

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/362f2aa7-85df-4486-9a84-96b739a2a74a)

- 데이터 서버는 대량의 데이터를 **안정적으로 처리**하기 위해서 **Kafka 메시징**을 이용합니다.
    - 각 UAM은 Message Producer가 되어 일정 주기로 Broker에 현재 위치를 포함한 비행 정보를 전달합니다.
    - 브로커는 Producer Consumer가 Broker 기반으로 통신하기 때문에, 중앙의 메시징 시스템만 유지 된다면 **메시지가 유실될 위험이 적습니다.**
    - 또한 메시징 시스템을 중심으로 연결되기 때문에 **확장하기에 용이합니다.**
    - 이러한 점은 아직까지 UAM이 대중화되지 않은 현재부터, UAM 비중이 큰 미래 상황까지 고려하였을 때 **시스템을 유연하게 설계**할 수있다는 장점으로 작용합니다.
    - 모니터링 시스템의 특성상 UAM이 전달한 데이터가 유실될 경우 정확한 비행 상황을 판단하지 못해 안전 사고가 발생할 수있습니다.
    - 타. 메시징 시스템과 달리 Kafka는 보관 주기 동안 디스크에 메시지를 저장하기 때문에 트래픽이 안정적이지 못한 상황에서 컨슈머의 처리가 늦어져도 **메시지 손실 없이 안전하게 처리**할 수 있습니다.
- http 프로토콜이 아닌 **WebSocket통신**을 사용해 데이터 전송의 **실시간성을 보장**하였다.

---
# 🛠 기술 스택
- Spring Boot
- Data JPA
- MySql
- Kafka
- Redis
- jenkins
- react
- nginx
- GCP

---
# 🗄️ 서버 스펙
- vCPU: 2Core
- memory 1GB

---

# 💻 소프트웨어 아키텍쳐

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/b7bf19c7-efd7-4680-9f16-14ac9b99a781)

---

# 💾 데이터 설계

- 본 모니터링 시스템에서 사용하는 데이터 포맷인 **UAM FIXM**과 **UAM ADS-B**는 **기존 항공기의 표준 데이터 포맷**인 FIXM과 ADS-B을 **참고 하여** 만들었으며
필요하다고 판단한 데이터들은 기존의 데이터 포맷에서 **취사 선택**하여 만들었습니다.
-  기존의 표준 데이터 포맷인 FIXM과 ADS-B이 XML의 형식으로 존재 하나 본 모니터링 시스템은 **웹 어플리케이션이라는 점**과 **XML의 형식이 불필요하다는** 점에서 **Json데이터 포맷**을
선택하였습니다.
- UAM FIXM은 비행 예정 경로에 대한 정보를 의미하며 ADS-B는 실시간 비행 정보를 의미합니다.

### UAM FIXM 데이터 포맷(비행 예정 경로)

| 주요 포맷     | 세부 포맷       |
|-----------|-------------|
| 식별자       | UAM 식별자     |
| 출발도착 버티포트 | 위도, 경도      |
| 출발도착 예정시각 | 날짜, 시간, 시간대 |
| 경로        | 위도, 경도      |

### UAM ADS-B 데이터 포맷(실시간 비행 정보)

| 주요 포맷 | 세부 포맷       |
|-------|-------------|
| 식별자   | UAM 식별자     |
| 현재 시각 | 날짜, 시간, 시간대 |
| 현재 위치 | 위도, 경도, 고도  |

---

# 🏭 클래스 다이어그램

모니터링 시스템 서버 클래스 다이어그램입니다.
![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/1577bafa-1546-4714-9717-386684df859c)

---

# 📄 결과

본 프로젝트를 바탕으로 `고도와 경로를 활용한 UAM 모니터링 시스템 개발`이라는 제목의 논문을 작성하였고
'2023 한국정보기술학회 하계 종합학술 대회'에서 우수 논문상을 수상하였습니다.
그리고 프로젝트 내용들을 개발자 커뮤니티인 `Devocean`에 기고하였습니다.
<br><br>
논문은 [DBpia](https://www.dbpia.co.kr/journal/articleDetail?nodeId=NODE11485532)에 등록되어 있으며 [원본 문서 레포지토리](https://github.com/uam-monitoring/monitoring_doc/blob/main/625%20%E1%84%80%E1%85%A9%E1%84%83%E1%85%A9%E1%84%8B%E1%85%AA%20%E1%84%80%E1%85%A7%E1%86%BC%E1%84%85%E1%85%A9%E1%84%85%E1%85%B3%E1%86%AF%20%E1%84%92%E1%85%AA%E1%86%AF%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB%20UAM%20%E1%84%86%E1%85%A9%E1%84%82%E1%85%B5%E1%84%90%E1%85%A5%E1%84%85%E1%85%B5%E1%86%BC%20%E1%84%89%E1%85%B5%E1%84%89%E1%85%B3%E1%84%90%E1%85%A6%E1%86%B7%20%E1%84%80%E1%85%A2%E1%84%87%E1%85%A1%E1%86%AF.pdf)에서 확인할수 있습니다.<br>
기고 글은 [도심항공모빌리티를 위한 UX](https://devocean.sk.com/blog/techBoardDetail.do?ID=165167)에서 확인하실 수 있습니다.

### 논문 상세 내용

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/a5f3095e-7ae5-4466-8437-33ed56ed2b18)

### 논문 수상 내역

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/fe7bd72c-513d-4055-aa6f-b6aa77d70d12)

### 개발자 커뮤니티 기고

![image](https://github.com/uam-monitoring/monitoring_backend/assets/72246411/ef2b10a6-b3f1-4868-be74-498071807bdb)

---

#  
