import { useEffect, useState } from "react";
import API from "../services/api";
import Navbar from "../components/Navbar";
import { useNavigate } from "react-router-dom";

function Home() {
  const [jobs, setJobs] = useState([]);
  const [search, setSearch] = useState("");
  const navigate = useNavigate();

 useEffect(() => {
  API.get("/jobs/all")
    .then(res => {
      console.log("Jobs API:", res.data);

      // ✅ FIX HERE
      if (Array.isArray(res.data)) {
        setJobs(res.data);
      } else if (Array.isArray(res.data.jobs)) {
        setJobs(res.data.jobs);
      } else if (Array.isArray(res.data.data)) {
        setJobs(res.data.data);
      } else {
        setJobs([]);
      }
    })
    .catch(err => {
      console.log(err);
      setJobs([]);
    });
 }, []);

  const filteredJobs = Array.isArray(jobs)
   ? jobs.filter(job =>
      job.title?.toLowerCase().includes(search.toLowerCase())
     )
   : [];
  const applyJob = async (job) => {
   await API.post("/applications/apply", {
    title: job.title,
    company: job.company,
    location: job.location
   });

   alert("Applied Successfully ✅");
  };

  const saveJob = async (job) => {
    await API.post("/saved-jobs/save", {
      userId: 1,
      title: job.title,
      company: job.company,
      location: job.location
    });
  };

return (
  <>
    <Navbar />

    <div className="container">
      <div className="feed">
        <h2>Recommended Jobs 🚀</h2>

        <input
           type="text"
           className="search-bar"
           placeholder="Search jobs..."
           value={search}
           onChange={(e) => setSearch(e.target.value)}
           style={{
            width: "100%",
            padding: "10px",
            marginBottom: "15px",
            borderRadius: "20px",
            border: "1px solid #ccc"
           }}
        />

        {jobs.length === 0 ? (
           <p>No jobs available</p>
        ) : (
            jobs.map(job => (
               <div className="job-card" key={job.id}>
                   <h3>{job.title}</h3>
                  <p>{job.company}</p>
                  <p>{job.location}</p>

                  <button className="btn" onClick={() => saveJob(job)}>
                     Save
                  </button>

                  <button className="btn" onClick={() => applyJob(job)}>
                     Apply
                  </button>
               </div>
            ))
        )}
      </div>
    </div>
  </>
);
}

export default Home;