from fastapi import FastAPI, UploadFile, File
import pdfplumber
import spacy
import io
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

app = FastAPI()

nlp = spacy.load("en_core_web_sm")

JOB_DESCRIPTIONS = {
    "Backend Developer": "java spring boot rest api sql microservices backend",
    "Frontend Developer": "react javascript html css frontend ui ux",
    "Data Analyst": "python pandas numpy sql data analysis visualization",
    "DevOps Engineer": "docker kubernetes aws ci cd linux deployment"
}

SKILLS = ["java", "python", "sql", "spring", "docker", "aws"]

def match_jobs(resume_text):
    documents = [resume_text] + list(JOB_DESCRIPTIONS.values())

    vectorizer = TfidfVectorizer()
    vectors = vectorizer.fit_transform(documents)

    similarity = cosine_similarity(vectors[0:1], vectors[1:]).flatten()

    results = {}
    for i, job in enumerate(JOB_DESCRIPTIONS.keys()):
        results[job] = round(similarity[i] * 100, 2)

    return results


# 🚀 Main API
@app.post("/analyze")
async def analyze_resume(file: UploadFile = File(...)):
    contents = await file.read()

    # 📄 Extract text from PDF
    text = ""
    try:
        with pdfplumber.open(io.BytesIO(contents)) as pdf:
            for page in pdf.pages:
                text += page.extract_text() or ""
    except Exception as e:
        return {"error": "Failed to read PDF"}

    text_lower = text.lower()

    doc = nlp(text_lower)

    found_skills = [skill for skill in SKILLS if skill in text_lower]

    score = len(found_skills) * 10

    job_matches = match_jobs(text_lower)

    return {
        "text": text[:1000],  
        "skills": found_skills,
        "score": score,
        "job_matches": job_matches
    }