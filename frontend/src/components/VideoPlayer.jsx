import React, { useEffect } from "react";
import { increaseViewCount } from "../api/videoApi";

const VideoPlayer = ({ video }) => {
  useEffect(() => {
    if (video && video.videoID) {
      increaseViewCount(video.videoID);
    }
  }, [video]);

  return (
    <div>
      <h2>{video.title}</h2>
      <video
        width="640"
        height="360"
        controls
        src={`/uploads/${video.videoID}.mp4`} // 실습용 경로
      />
      <p>조회수: {video.viewCount}</p>
    </div>
  );
};

export default VideoPlayer;
