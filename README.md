# HarMe(Harmony-Melodies) - 생성형 AI를 활용한 작곡 서비스
![image](https://github.com/user-attachments/assets/1c1de10c-a6b3-403f-8e70-d4e952830d67)


https://github.com/user-attachments/assets/ec7ac9de-3d87-4f96-bc89-a59ac0f62c24

# 📌 목차

- [README](#readme)
  - [🤔 기획 배경](#-기획-배경)
  - [💡 주요 기능](#-주요-기능)
  - [📝 설계 문서](#-설계-문서)
    - ERD
    - 기능 명세서
    - API 명세서
  - [🚧 서비스 아키텍쳐](#-서비스-아키텍쳐)
  - [🛠 기술 스택](#-기술-스택)
  - [📂 파일 구조](#-파일-구조)
  - [🐰 팀원 소개](#-팀원-소개)

<br>
<br>

## 📅 프로젝트 진행 기간

| 프로젝트 진행 기간 | 2024.07.26 ~ 2024.08.02 (총 1주) |
| ------------- | -------------------------------- |

<br>

## 🤔 기획 배경
- 음악이 우울증 해소에 긍정적 영향을 미친다는 연구를 바탕으로 노년층의 우울증 증가를 해결하기 위해 본 서비스를 기획<br>
- Google Cloud Platform, OpenAI, Suno AI를 활용하여 음성 인식, 가사 생성, 그림 생성, 노래 생성을 지원하는 서비스를 제공<br>
- 이를 통해 노년층의 정서적 안정, 사회적 연결, 인지 기능 향상, 자아실현을 도모하고자 함<br>

<br>

## 💡 주요 기능
### 1. 작곡 기능
<img src=https://github.com/user-attachments/assets/1686b56b-fbfe-4fd1-905e-caa9900c36ce width="180" height="420"></img>
<img src=https://github.com/user-attachments/assets/0f81ad00-4676-4d46-8e27-cf2ba20bd70e width="170" height="420"></img>
<img src=https://github.com/user-attachments/assets/8c44ac4e-d5cd-4e90-a1a3-bcbe221090ff width="160" height="420"></img>
<img src=https://github.com/user-attachments/assets/8a315e57-25e7-423f-be4c-c67029f0404c width="160" height="420"></img>
<img src=https://github.com/user-attachments/assets/c2c4bf2f-7799-4598-91f3-8809001b8fc0 width-="170" height="420"></img>
<img src=https://github.com/user-attachments/assets/b1605cae-7015-4627-adc0-188d0fbd344c width="170" height="420"></img>


### 2. 





3. 기록 기능
<img src="https://github.com/user-attachments/assets/e897a9a1-d882-4e23-a57c-d7866e3c393b" width="80%"></img>

<br>

## 🎙️ 서비스 화면
<img src="https://github.com/user-attachments/assets/c30ab7ca-d6ce-4d68-b717-cf2cd93860bb" width="80%"></img>
<br>


## 📝 설계 문서

### 🔗 [erdcloud](https://www.erdcloud.com/d/mWFhqQ7DPSYGKnLnt)

### 🔗 [기능명세서](https://better-jumpsuit-1f8.notion.site/3eb7c54faee1405a9340949eeeacb4bb?pvs=4)

### 🔗 [Swagger](http://43.201.54.73:8081/swagger-ui/index.html)

<br>

## 🚧 서비스 아키텍쳐
<img src="https://github.com/user-attachments/assets/083aa946-17dd-44c0-b2de-1e05aca9e311" width="80%"></img>

<br>

## 🛠 기술 스택

### 🍓 AI
- ![Flask](https://img.shields.io/badge/Flask-000000?style=for-the-badge&logo=flask&logoColor=white) : 

### 🥕 Backend

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) : 17.0.9
- ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) : 3.2.5
- **JPA** : 3.25
- ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white) : 8.0.34
- **Maira DB** : 8.0.34

### 🥝 Frontend

- ![Next.js](https://img.shields.io/badge/Next.js-000?logo=nextdotjs&logoColor=fff&style=for-the-badge) : 14.2.5
- ![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB) : 18

### 🫐 협업 툴

- ![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
- ![Discord](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)
- ![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)

<br>

## 📂 파일 구조

<details  style="margin-left: 5px;">
<summary><b>BackEnd</b></summary>
<div>

```
📦allclear
┣ 📂allclearsse
┃ ┣ 📂client
┃ ┃ ┗ 📜SensorServiceClient
┃ ┣ 📂config
┃ ┃ ┗ 📜Resilience4JConfiguration
┃ ┣ 📂controller
┃ ┃ ┣ 📜SseController
┃ ┃ ┣ 📜TestController
┃ ┃ ┗ 📜TestUserController
┃ ┣ 📂domain
┃ ┃ ┣ 📜DailyEnv
┃ ┃ ┣ 📜Farm
┃ ┃ ┣ 📜HourlyEnv
┃ ┃ ┗ 📜Yield
┃ ┣ 📂dto
┃ ┃ ┣ 📜FarmRequestDto
┃ ┃ ┣ 📜FarmResponseDto
┃ ┃ ┗ 📜SensorResponseDto
┃ ┣ 📂repository
┃ ┃ ┣ 📜SseDailyEnvRepository
┃ ┃ ┣ 📜SseHourlyEnvRepository
┃ ┃ ┗ 📜TestUserRepository
┃ ┣ 📂service
┃ ┃ ┣ 📜SseService
┃ ┃ ┗ 📜TestUserService
┃ ┗ 📜SseServiceApplication
```

</div>
</details>

<br>
<details  style="margin-left: 5px;">
<summary><b>FrontEnd</b></summary>
<div>

```
📦allclear
┣ 📂public
┃ ┣ 📂Build
┃ ┗ 📂Simul
┣ 📂src
┃ ┣ 📂apis
┃ ┣ 📂assets
┃ ┣ 📂components
┃ ┃ ┣ 📂line
┃ ┃ ┣ 📂period
┃ ┃ ┣ 📜Dashboard.jsx
┃ ┃ ┣ 📜Join.jsx
┃ ┃ ┣ 📜Login.jsx
┃ ┃ ┣ 📜Monitoring.jsx
┃ ┃ ┣ 📜Navbar.jsx
┃ ┃ ┣ 📜OpenVidu.jsx
┃ ┃ ┣ 📜Sidebar.jsx
┃ ┃ ┣ 📜Statistics.jsx
┃ ┃ ┗ 📜VideoStream.jsx
┃ ┣ 📂modules
┃ ┃ ┗ 📜useOpenVidu.jsx
┃ ┣ 📂recoil
┃ ┃ ┣ 📂dashboard
┃ ┃ ┣ 📂login
┃ ┃ ┗ 📂statistics
┃ ┣ 📜App.jsx
┃ ┗ 📜main.jsx
┣ 📜package-lock.json
┣ 📜package.json
┣ 📜vite.config.js
┣ 📜index.html
┣ 📜.env
┗ 📜.eslintrc.cjs
```

</div>
</details>
<br>

## 🐰 팀 구성

| 이름         | 역할   |
| ------------ | ------ |
| 김민태       | - Leader, AI <br>|
| 김현진       | - BE <br> |
| 석지원       | - UI/UX <br> |
| 오승태       | - FE <br> |
| 이대영       | - BE, AI, Infra <br> |

<br>
