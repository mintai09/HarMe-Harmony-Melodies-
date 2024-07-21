# HarMe(Harmony-Melodies) - 생성형 AI를 활용한 작곡 서비스
<img src="https://github.com/user-attachments/assets/88516d91-e758-429f-8f74-4751b58dedaa" width="70%"></img>
<audio src="https://drive.google.com/uc?export=download&id=1UxodMtuJf5qLiLG5wk7Y9RRJss09t4N2" autoplay="true" controls="true"></audio>
<br>

# 📖목차

- [README](#readme)
  - [✨ 기획 배경](#-기획-배경)
  - [💡 주요 기능](#-주요-기능)
  - [📝 설계 문서](#-설계-문서)
    - ERD
    - 기능 명세서
    - API 명세서
  - [🚧 서비스 아키텍쳐](#-서비스-아키텍쳐)
  - [🛠 기술 스택](#-기술-스택)
  - [📂 파일 구조](#-파일-구조)
  - [❤ 팀원 소개](#-팀원-소개)

<br>
<br>

## ✨프로젝트 진행 기간

| 프로젝트 기간 | 2024.07.26 ~ 2024.08.02 (총 1주) |
| ------------- | -------------------------------- |

<br>

## ✨기획 배경

<br>

## 💡 주요 기능

### 1. Generative AI

### 2.

### 3.

### 4.

## 서비스 화면

## ERD

erdcloud 링크 :

<br>
<br>

## 📝 설계 문서

#### 기능 명세서

- 노션 링크 : https://www.notion.so/6148cbfebbf84486acf198174dc590ea?v=24f8b6ae2580413ba16b23ff75497949

#### API 명세서

- 노션 링크 :

<br>

## 🚧 서비스 아키텍쳐

<br>

## 🛠 기술 스택

### ☑Backend & AI

- **Java** : 17.0.9
- **Spring Boot** : 3.2.5
- **JPA** : 3.25
- **MySQL(Maira DB)** : 8.0.34

### ☑Frontend

- **Node.js** : 20.11.1
- **React** : 18.2.0

### ☑협업 툴

- **GitHub**
- **Notion**
- **Discord**

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

## 팀 구성

| 이름         | 역할   |
| ------------ | ------ |
| 김민태(팀장) | - <br> |
| 김현진       | - <br> |
| 석지원       | - <br> |
| 오승태       | - <br> |
| 이대영       | - <br> |

<br>
