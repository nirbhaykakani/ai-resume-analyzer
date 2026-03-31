import React, { useState } from "react";
import axios from "axios";

function App() {
  const [file, setFile] = useState(null);
  const [result, setResult] = useState(null);

  const handleUpload = async () => {
    if (!file) return alert("Please select a file");

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await axios.post(
        "http://localhost:8080/api/resume/upload",
        formData,
        { headers: { "Content-Type": "multipart/form-data" } }
      );

      setResult(response.data);
    } catch (error) {
      console.error(error);
      alert("Upload failed");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>AI Resume Analyzer</h1>

      <input
        type="file"
        onChange={(e) => setFile(e.target.files[0])}
      />

      <br /><br />

      <button onClick={handleUpload}>Upload Resume</button>

      {result && (
        <div style={{ marginTop: "20px" }}>
          <h2>Result</h2>

          <p><b>File:</b> {result.fileName}</p>
          <p><b>Score:</b> {result.score}</p>
          <p><b>Skills:</b> {result.skills}</p>

          {/* 🔥 Job Matches Section */}
          {result.job_matches && (
            <div>
              <h3>Job Matches:</h3>
              <ul>
                {Object.entries(result.job_matches).map(([job, score]) => (
                  <li key={job}>
                    {job}: {score}%
                  </li>
                ))}
              </ul>
            </div>
          )}
        </div>
      )}
    </div>
  );
}

export default App;