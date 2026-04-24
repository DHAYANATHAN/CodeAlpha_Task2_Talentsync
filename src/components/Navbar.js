import { Link } from "react-router-dom";
import { FaBriefcase, FaBookmark, FaUser } from "react-icons/fa";
function Navbar() {
  return (
    <div className="navbar">
      <h2>TalentSync</h2>

      <div className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/saved">Saved</Link>
         <Link to="/"><FaBriefcase /> Jobs</Link>
        
        <Link to="/profile"><FaUser /> Profile</Link>
      </div>
    </div>
  );
}

export default Navbar;