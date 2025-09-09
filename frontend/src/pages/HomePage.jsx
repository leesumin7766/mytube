import React, { useEffect, useState } from "react";
import { getPopularVideos } from "../api/videoApi";
import VideoCard from "../components/VideoCard";

const HomePage = () => {
  const [videos, setVideos] = useState([]);

  useEffect(() => {
    getPopularVideos().then((res) => setVideos(res.data));
  }, []);

  return (
    <div>
      <h1>인기 영상 TOP 10</h1>
      <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
        {videos.map((video) => (
          <VideoCard key={video.videoID} video={video} />
        ))}
      </div>
    </div>
  );
};

export default HomePage;
