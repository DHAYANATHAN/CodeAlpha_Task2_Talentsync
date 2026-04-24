import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";
import Navbar from "../components/Navbar";

function JobDetails() {
  const { id } = useParams();
  const [job, setJob] = useState(null);

  useEffect(() => {
    API.get(`/jobs/${id}`).then(res => setJob(res.data));
  }, [id]);

  if (!job) return <p>Loading...</p>;

  return (
    <>
      <Navbar />

      <div style={{ padding: "20px" }}>
        <h2>{job.title}</h2>
        <p><b>{job.company}</b></p>
        <p>{job.location}</p>

        <hr />

        <h3>Description</h3>
        <p>{job.description}</p>
      </div>
    </>
  );
}

export default JobDetails;