import React from "react";
import { Link } from "react-router-dom";

const VideoCard = ({ video }) => {
  return (
    <div className="video-card">
      <Link to={`/videos/${video.videoID}`}>
        <img
          src={video.thumbnailURLSub || "/default-thumbnail.png"}
          alt={video.title}
          style={{ width: "200px", height: "120px" }}
        />
        <h3>{video.title}</h3>
        <p>조회수: {video.viewCount}</p>
      </Link>
    </div>
  );
};

export default VideoCard;
