import axiosInstance from "./axiosInstance";

export const getPopularVideos = () =>
  axiosInstance.get("/videos/popular");

export const getVideoById = (id) =>
  axiosInstance.get(`/videos/${id}`);

export const increaseViewCount = (id) =>
  axiosInstance.post(`/videos/${id}/view`);

export const uploadVideo = (formData) =>
  axiosInstance.post("/videos/upload", formData, {
    headers: { "Content-Type": "multipart/form-data" },
  });
