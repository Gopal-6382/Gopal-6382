import { useState, useRef } from "react";
import QRCode from "react-qr-code";
// import "bootstrap/dist/css/bootstrap.min.css";

const Qr_code = () => {
  const [url, setUrl] = useState("");
  const [size, setSize] = useState(128);
  const [showQR, setShowQR] = useState(false);
  const qrRef = useRef(null);

  const isImageUrl = (link) => /\.(jpeg|jpg|png|gif|webp|svg)$/i.test(link);


  const handleGenerate = () => {
    if (url.trim() === "") return;
    setShowQR(true);
  };

  const downloadQRCode = async () => {
    const svgElement = qrRef.current?.querySelector("svg");
    if (!svgElement) return;

    
    try {
      const { toPng } = await import("html-to-image");
      const pngDataUrl = await toPng(svgElement);

      const link = document.createElement("a");
      link.href = pngDataUrl;
      link.download = "qr_code.png";
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    } catch (error) {
      console.error("Download failed:", error);
    }
  };

  return (
    <div className="container d-flex justify-content-center mt-5">
      <div className="col-md-6 shadow p-4 rounded bg-light">
        <h2 className="text-center mb-4 text-uppercase text-primary">
          QR Code Generator
        </h2>

        {isImageUrl(url) && (
          <div className="text-center mb-3">
            <p className="text-muted">Image Preview:</p>
            <img
              src={url}
              alt="Preview"
              className="img-fluid rounded"
              style={{ maxHeight: "200px" }}
            />
          </div>
        )}

        <label htmlFor="urlInput" className="form-label">
          Enter URL or text:
        </label>
        <input
          type="text"
          id="urlInput"
          className="form-control mb-3"
          placeholder="https://example.com"
          value={url}
          onChange={(e) => {
            setUrl(e.target.value);
            setShowQR(false);
          }}
        />

        <label htmlFor="sizeInput" className="form-label">
          QR Code Size:
        </label>
        <input
          type="number"
          id="sizeInput"
          className="form-control mb-4"
          value={size}
          onChange={(e) => setSize(Number(e.target.value))}
          min="64"
          max="512"
        />

        <div className="d-flex gap-2 mb-4 justify-content-center">
          <button className="btn btn-primary" onClick={handleGenerate}>
            Generate QR
          </button>
          <button className="btn btn-success" onClick={downloadQRCode}>
            Download PNG
          </button>
        </div>

        {showQR && url && (
          <div className="text-center" ref={qrRef}>
            <QRCode value={url} size={size} />
          </div>
        )}
      </div>
    </div>
  );
};

export default Qr_code;
