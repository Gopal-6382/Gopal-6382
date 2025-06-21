import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Advice } from "./components/AdviceApp/Advice";
import WeatherApp from "./components/WeatherApp/weatherApp";
import { Currency } from "./components/currency/currency";
import Qr_code from "./components/Qr_code/Qr_code";
import { UseState } from "./components/UseState/UseState";
import { FormData } from "./components/Form/FormData";
import { Table } from "./components/Table/Table";
import "./sass/all.scss"; // your global styles

export default function App() {
  return (
    <div className="container my-5">
      <h1 className="text-center text-primary mb-5">Utility Dashboard</h1>

      <div className="row gy-4">
        <ComponentCard title="Advice Generator" variant="success">
          <Advice />
        </ComponentCard>

        <ComponentCard title="Weather App" variant="info">
          <WeatherApp />
        </ComponentCard>

        <ComponentCard title="Currency Converter" variant="warning">
          <Currency />
        </ComponentCard>

        <ComponentCard title="QR Code Generator" variant="secondary">
          <Qr_code />
        </ComponentCard>

        <ComponentCard title="UseState Example" variant="dark">
          <UseState />
        </ComponentCard>

        <ComponentCard title="Form Handling" variant="primary">
          <FormData />
        </ComponentCard>

        <ComponentCard title="Data Table" variant="danger">
          <Table />
        </ComponentCard>
      </div>
    </div>
  );
}

// Simple reusable wrapper for layout
function ComponentCard({ title, children, variant = "secondary" }) {
  return (
    <div className="col-12 col-md-6">
      <div className={`p-4 shadow-sm rounded bg-white border-start border-4 border-${variant} h-100`}>
        <h4 className={`text-${variant} mb-3`}>{title}</h4>
        {children}
      </div>
    </div>
  );
}
