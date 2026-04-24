import { useEffect, useState } from "react";
import API from "../services/api";
import Navbar from "../components/Navbar";

function Jobs() {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    API.get("/jobs/all").then(res => setJobs(res.data));
  }, []);

  return (
    <>
      <Navbar />
      <div style={{ padding: "20px" }}>
        <h2>All Jobs</h2>

        {jobs.map(job => (
          <div className="job-card" key={job.id}>
            <h3>{job.title}</h3>
            <p>{job.company}</p>
            <p>{job.location}</p>
          </div>
        ))}
      </div>
    </>
  );
}

export default Jobs;