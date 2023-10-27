import React, { useState } from "react";
import ProjectView from "../components/ProjectView";

const AllProjectsPage = ({ handleProjectClick }) => {
  return (
    <div className="flex flex-col">
      <h1 className="text-5xl font-bold mx-auto">All NGO-Projects</h1>
      <p className="text-md mx-auto text-gray-400 mt-2">
        United for Good: Discover initiatives from our community.{" "}
      </p>
      <ProjectView handleProjectClick={handleProjectClick} />
    </div>
  );
};

export default AllProjectsPage;
