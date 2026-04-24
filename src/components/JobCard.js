function JobCard({ job, onApply, onSave }) {
  return (
    <div className="job-card">
      <h3>{job.title}</h3>
      <p>{job.company}</p>
      <p>{job.location}</p>

      <div className="buttons">
        <button onClick={() => onApply(job.id)}>Apply</button>
        <button onClick={() => onSave(job.id)}>Save</button>
      </div>
    </div>
  );
}

export default JobCard;