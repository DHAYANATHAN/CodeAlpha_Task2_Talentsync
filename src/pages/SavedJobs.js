import { useEffect, useState } from "react";
import API from "../services/api";
import Navbar from "../components/Navbar";

function SavedJobs() {
  const [savedJobs, setSavedJobs] = useState([]);

  useEffect(() => {
    API.get("/saved-jobs")
      .then(res => {
        console.log("Saved Jobs Response:", res.data);

        // ✅ Fix: ensure it's array
        if (Array.isArray(res.data)) {
          setSavedJobs(res.data);
        } else if (Array.isArray(res.data.data)) {
          setSavedJobs(res.data.data);
        } else {
          setSavedJobs([]);
        }
      })
      .catch(err => {
        console.log(err);
        setSavedJobs([]);
      });
  }, []);

  return (
    <>
      <Navbar />

      <div style={{ padding: "20px" }}>
        <h2>Saved Jobs</h2>

        {savedJobs.length === 0 ? (
          <p>No saved jobs</p>
        ) : (
          savedJobs.map(job => (
            <div className="job-card" key={job.id}>
              <h3>{job.title}</h3>
              <p>{job.company}</p>
              <p>{job.location}</p>
            </div>
          ))
        )}
      </div>
    </>
  );
}

export default SavedJobs;