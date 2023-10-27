import React, { useState } from "react";
import ProjectView from "../components/ProjectView";

const MyProjectsPage = () => {
  return (
    <div className="flex flex-col">
      <h1 className="text-5xl font-bold mx-auto">Meine NGO-Projekte</h1>
      <p className="text-md mx-auto text-gray-400 mt-2">
        Gemeinsam Veränderung schaffen: Deine Initiativen für eine bessere Welt.
      </p>
      <ProjectView />
    </div>
  );
};

export default MyProjectsPage;
