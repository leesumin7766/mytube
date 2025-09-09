import React, { useState } from "react";
import { uploadVideo } from "../api/videoApi";

const UploadPage = () => {
  const [file, setFile] = useState(null);
  const [title, setTitle] = useState("");
  const [channelID, setChannelID] = useState("defaultChannel");
  const [categoryID, setCategoryID] = useState("defaultCategory");
  const [thumbnailURL, setThumbnailURL] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("file", file);
    formData.append("title", title);
    formData.append("channelID", channelID);
    formData.append("categoryID", categoryID);
    formData.append("thumbnailURL", thumbnailURL);

    try {
      const res = await uploadVideo(formData);
      alert(`업로드 성공: ${res.data.title}`);
    } catch (err) {
      alert("업로드 실패");
    }
  };

  return (
    <div>
      <h1>영상 업로드</h1>
      <form onSubmit={handleSubmit}>
        <input type="file" onChange={(e) => setFile(e.target.files[0])} />
        <input
          type="text"
          placeholder="제목"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="썸네일 URL"
          value={thumbnailURL}
          onChange={(e) => setThumbnailURL(e.target.value)}
        />
        <button type="submit">업로드</button>
      </form>
    </div>
  );
};

export default UploadPage;
