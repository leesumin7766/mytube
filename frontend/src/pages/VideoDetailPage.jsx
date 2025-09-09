import React, { useEffect, useState } from "react";
import { getVideoById } from "../api/videoApi";
import { useParams } from "react-router-dom";
import VideoPlayer from "../components/VideoPlayer";

const VideoDetailPage = () => {
  const { id } = useParams();
  const [video, setVideo] = useState(null);

  useEffect(() => {
    getVideoById(id).then((res) => setVideo(res.data));
  }, [id]);

  if (!video) return <p>Loading...</p>;

  return (
    <div>
      <VideoPlayer video={video} />
    </div>
  );
};

export default VideoDetailPage;
