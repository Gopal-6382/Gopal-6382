import { useEffect, useState } from "react";
import axios from "axios";

// ✅ Correct base URL
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

  // ✅ GET
  const fetchData = async () => {
    setLoading(true);
    try {
      const res = await api.get("/posts", {
        params: { _limit: 5, _sort: "id", _order: "desc" },
      });
      console.log("🔄 Fetched Data:", res.data);
      setData(res.data);
      setError(null);
    } catch (err) {
      console.error("❌ Fetch error:", err.message);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // ✅ POST
  const createPost = async () => {
    try {
      const res = await api.post("/posts", {
        title: "Sample Post " + Math.floor(Math.random() * 1000),
        body: "This is a sample post body",
        userId: 1,
      });
      console.log("🟢 Created Post:", res.data);
      const updated = [res.data, ...data];
      setData(updated);
      console.log("📦 Data After Create:", updated);
      alert("Post Created: ID " + res.data.id);
    } catch (err) {
      console.error("❌ Create error:", err.message);
      alert("Error creating post: " + err.message);
    }
  };

  // ✅ PUT
  const updatePost = async (id) => {
    const original = data.find((item) => item.id === id);
    try {
      const res = await api.put(`/posts/${id}`, {
        ...original,
        title: "Updated Title - " + id,
      });
      console.log("✏️ Before Update:", original);
      console.log("🟢 Updated Post:", res.data);

      const updated = data.map((item) =>
        item.id === id ? res.data : item
      );
      setData(updated);
      console.log("📦 Data After Update:", updated);
      alert("Post Updated: " + res.data.title);
    } catch (err) {
      console.error("❌ Update error:", err.message);
      alert("Error updating post: " + err.message);
    }
  };

  // ✅ DELETE
  const deletePost = async (id) => {
    const deleted = data.find((item) => item.id === id);
    try {
      await api.delete(`/posts/${id}`);
      console.log("🗑️ Deleted Post:", deleted);

      const updated = data.filter((item) => item.id !== id);
      setData(updated);
      console.log("📦 Data After Delete:", updated);
      alert("Post Deleted");
    } catch (err) {
      console.error("❌ Delete error:", err.message);
      alert("Error deleting post: " + err.message);
    }
  };

  // Interceptors
  useEffect(() => {
    const reqLogger = api.interceptors.request.use((config) => {
      console.log("📡 Request:", config.method?.toUpperCase(), config.url);
      return config;
    });
    const resLogger = api.interceptors.response.use((res) => {
      console.log("📥 Response:", res.status, res.config.url);
      return res;
    });

    return () => {
      api.interceptors.request.eject(reqLogger);
      api.interceptors.response.eject(resLogger);
    };
  }, []);

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">🚀 Axios CRUD + Logs</h2>

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
        <button
          className="bg-blue-600 text-white px-4 py-2 rounded"
          onClick={createPost}
        >
          ➕ Create Post
        </button>
        <button
          className="bg-gray-600 text-white px-4 py-2 rounded"
          onClick={fetchData}
        >
          🔄 Refresh
        </button>
      </div>
    </div>
  );
};

export default AxiosDemo;
