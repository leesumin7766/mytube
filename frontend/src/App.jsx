import './App.css';
import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomePage from "./pages/HomePage";
import UploadPage from "./pages/UploadPage";
import VideoDetailPage from "./pages/VideoDetailPage";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/">홈</Link> | <Link to="/upload">업로드</Link>
      </nav>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/upload" element={<UploadPage />} />
        <Route path="/videos/:id" element={<VideoDetailPage />} />
      </Routes>
    </Router>
  );
}

export default App;
