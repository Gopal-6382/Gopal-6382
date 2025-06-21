// import "bootstrap/dist/css/bootstrap.min.css";
import { useState } from "react";

// const QrCode = () => {
//   const [img, setImg] = useState("public/vite.svg");
//   function handleGenerateQR() {}
//   function Mousehover() {
//     alert("Here will be displyed the QR Code");
//   }
//   function handleGenerateQR() {}
//   return (
//     <div className="container d-flex justify-content-center mt-5">
//       <div className="col-md-6 shadow p-4 rounded bg-light">
//         <h2 className="text-center mb-4 text-uppercase text-primary">
//           QR Code Generator
//         </h2>

//         {/* Image Preview */}
//         <div className="text-center mb-3">
//           <p className="text-muted">Image Preview:</p>
//           <img
//             onMouseEnter={() => {
//               Mousehover();
//             }}
//             src={img}
//             alt="Preview"
//             className="img-fluid rounded"
//             style={{ maxHeight: "200px" }}
//           />
//         </div>

//         {/* URL Input */}
//         <label htmlFor="urlInput" className="form-label">
//           Enter URL or text:
//         </label>
//         <input
//           type="text"
//           id="urlInput"
//           className="form-control mb-3"
//           placeholder="https://example.com"
//         />

//         {/* Size Input */}
//         <label htmlFor="sizeInput" className="form-label">
//           QR Code Size:
//         </label>
//         <input
//           type="number"
//           id="sizeInput"
//           className="form-control mb-4"
//           placeholder="128"
//           min="64"
//           max="512"
//         />

//         {/* Buttons */}
//         <div className="d-flex gap-2 mb-4 justify-content-center">
//           <button className="btn btn-primary">Generate QR</button>
//           <button className="btn btn-success">Download PNG</button>
//         </div>

//         {/* QR Display */}
//         <div className="text-center">
//           <div
//             style={{
//               width: "128px",
//               height: "128px",
//               backgroundColor: "#eee",
//               margin: "0 auto",
//               borderRadius: "4px",
//             }}
//           >
//             {/* Placeholder for QR Code */}
//             <p className="pt-5 text-muted">QR Code</p>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// import "bootstrap/dist/css/bootstrap.min.css";
// import { useState } from "react";

const QrCode = () => {
  const [img, setImg] = useState("");
  const [qrData, setQrData] = useState("https://example.com");
  const [qrSize, setQrSize] = useState("150");
  const [loading, setLoading] = useState(false);

  // Generate QR Code
  async function generateQr() {
    setLoading(true);
    try {
      const url = `https://api.qrserver.com/v1/create-qr-code/?size=${qrSize}x${qrSize}&data=${encodeURIComponent(
        qrData
      )}`;
      setImg(url);
    } catch (error) {
      console.error("QR generation error:", error);
    } finally {
      setLoading(false);
    }
  }

  // Download QR Code
  function downloadQr() {
    fetch(img)
      .then((response) => response.blob())
      .then((blob) => {
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);
        link.download = "qrcode.png";
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
      });
  }

  return (
    <div className="container d-flex justify-content-center mt-5">
      <div className="col-md-6 shadow p-4 rounded bg-light">
        <h2 className="text-center mb-4 text-uppercase text-primary">
          QR Code Generator
        </h2>

        {/* Image Preview */}
        <div className="text-center mb-3">
          <p className="text-muted">Image Preview:</p>
          {img ? (
            <img
              src={img}
              alt="QR Code"
              className="img-fluid rounded"
              style={{ maxHeight: "200px" }}
              onMouseEnter={() => alert("This is your QR code preview.")}
            />
          ) : (
            <div
              style={{
                width: "128px",
                height: "128px",
                backgroundColor: "#eee",
                borderRadius: "4px",
                margin: "0 auto",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                color: "#999",
              }}
            >
              QR Code
            </div>
          )}
        </div>

        {/* URL Input */}
        <label htmlFor="urlInput" className="form-label">
          Enter URL or text:
        </label>
        <input
          type="text"
          id="urlInput"
          value={qrData}
          onChange={(e) => setQrData(e.target.value)}
          className="form-control mb-3"
          placeholder="https://example.com"
        />

        {/* Size Input */}
        <label htmlFor="sizeInput" className="form-label">
          QR Code Size:
        </label>
        <input
          type="number"
          id="sizeInput"
          value={qrSize}
          onChange={(e) => setQrSize(e.target.value)}
          className="form-control mb-4"
          placeholder="150"
          min="64"
          max="512"
        />

        {/* Buttons */}
        <div className="d-flex gap-2 mb-4 justify-content-center">
          <button
            onClick={generateQr}
            className="btn btn-primary"
            disabled={loading}
          >
            {loading ? "Generating..." : "Generate QR"}
          </button>
          <button
            onClick={downloadQr}
            className="btn btn-success"
            disabled={!img}
          >
            Download PNG
          </button>
        </div>
      </div>
    </div>
  );
};

export default QrCode;
