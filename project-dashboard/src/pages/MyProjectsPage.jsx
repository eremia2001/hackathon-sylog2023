import React, { useState } from "react";
import ProjectView from "../components/ProjectView";

const MyProjectsPage = ({ handleProjectClick }) => {
  return (
    <div className="flex flex-col">
      <h1 className="text-5xl font-bold mx-auto">My NGO-Projects</h1>
      <p className="text-md mx-auto text-gray-400 mt-2">
        Creating Change Together: Your initiatives for a better world.{" "}
      </p>
      <ProjectView handleProjectClick={handleProjectClick} />
    </div>
  );
};

export default MyProjectsPage;
