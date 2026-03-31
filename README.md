# AI Resume Analyzer + Job Matcher 🚀

## 📌 Overview
A full-stack AI-powered application that:
- Extracts text from resumes (PDF)
- Identifies skills using NLP
- Scores resumes
- Matches resumes to job roles using TF-IDF + cosine similarity

---

## 🧠 Tech Stack

### Backend
- Spring Boot (Java)
- PostgreSQL

### AI Service
- FastAPI (Python)
- spaCy
- scikit-learn

### Frontend
- React

---

## 🔥 Features
- Resume upload (PDF)
- Skill extraction
- Resume scoring
- AI-based job matching

---

## 🏗️ Architecture

Frontend → Spring Boot → Python AI Service

---

## 🚀 How to Run

### 1. Start AI Service
cd ai-service  
venv\Scripts\activate  
uvicorn main:app --reload  

### 2. Start Backend
cd backend  
./gradlew bootRun  

### 3. Start Frontend
cd frontend  
npm start  

---

## 📊 Sample Output

- Score: 40  
- Skills: Java, Python, SQL, Spring  
- Job Matches:
  - Backend Developer: 88%
  - Data Analyst: 60%

---

## 👨‍💻 Author
Nirbhay Kakani
