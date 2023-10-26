import React, { useState } from "react";
import ProjectView from "../components/ProjectView";

const MyProjectsPage = () => {
  return (
    <div className="flex flex-col">
      <h1 className="text-5xl font-bold mx-auto">Alle NGO-Projekte</h1>
      <p className="text-md mx-auto text-gray-400 mt-2">
        Vereint für das Gute: Entdecke Initiativen aus unserer Gemeinschaft.
      </p>
    </div>
  );
};

export default MyProjectsPage;
