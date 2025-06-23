import React, { useEffect, useState } from "react";
import axios from "axios";

// Create custom Axios instance
const api = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com",
  headers: {
    "Content-Type": "application/json",
  },
});

const AxiosDemo = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  // 🟢 1. GET request with params
  const fetchData = async () => {
    setLoading(true);
    try {
      const res = await api.get("/posts", {
        params: { _limit: 5 }, // same as ?_limit=5
      });
      setData(res.data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // 🟢 2. POST request
  const createPost = async () => {
    try {
      const res = await api.post("/posts", {
        title: "New Post",
        body: "This is the body of the post",
        userId: 1,
      });
      alert("Post Created: ID " + res.data.id);
    } catch (err) {
      alert("Error creating post"+err);
    }
  };

  // 🟢 3. PUT request
  const updatePost = async (id) => {
    try {
      const res = await api.put(`/posts/${id}`, {
        title: "Updated Title",
      });
      alert("Post Updated: " + res.data.title);
    } catch (err) {
      alert("Error updating post"+err);
    }
  };

  // 🟢 4. DELETE request
  const deletePost = async (id) => {
    try {
      await api.delete(`/posts/${id}`);
      alert("Post Deleted");
    } catch (err) {
      alert("Error deleting post"+err);
    }
  };

  // 🟢 5. Interceptor example (log all requests)
  useEffect(() => {
    const requestLogger = api.interceptors.request.use((config) => {
      console.log("📡 Request:", config.method?.toUpperCase(), config.url);
      return config;
    });
    const responseLogger = api.interceptors.response.use((res) => {
      console.log("📥 Response:", res.status, res.config.url);
      return res;
    });

    return () => {
      api.interceptors.request.eject(requestLogger);
      api.interceptors.response.eject(responseLogger);
    };
  }, []);

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">🚀 Axios Demo</h2>

      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p className="text-red-500">Error: {error}</p>
      ) : (
        <ul className="space-y-2">
          {data.map((item) => (
            <li key={item.id} className="border p-2 rounded">
              <p className="font-semibold">{item.title}</p>
              <button
                className="text-blue-500 mr-2"
                onClick={() => updatePost(item.id)}
              >
                Update
              </button>
              <button
                className="text-red-500"
                onClick={() => deletePost(item.id)}
              >
                Delete
              </button>
            </li>
          ))}
        </ul>
      )}

      <div className="mt-6 space-x-4">
        <button className="bg-blue-600 text-white px-4 py-2 rounded" onClick={createPost}>
          ➕ Create Post
        </button>
        <button className="bg-gray-600 text-white px-4 py-2 rounded" onClick={fetchData}>
          🔄 Refresh
        </button>
      </div>
    </div>
  );
};

export default AxiosDemo;
