import Navbar from "../components/Navbar";

function Profile() {
  return (
    <>
      <Navbar />

      <div style={{ padding: "20px" }}>
        <h2>User Profile</h2>

        <p><b>Name:</b> Your Name</p>
        <p><b>Email:</b> user@gmail.com</p>
        <p><b>Role:</b> Job Seeker</p>
      </div>
    </>
  );
}

export default Profile;