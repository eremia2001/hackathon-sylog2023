import ProjectItem from "./ProjectItem";
import useProjects from "../hooks/useProjects";
import React, { useState } from "react";
import PopupFormCard from "./CreateProjectView";

const ProjectView = () => {
  const [projects, setProjects] = useProjects();
  const [isFormOpen, setFormOpen] = useState(false);
  const handleCloseForm = () => setFormOpen(false);

  return (
    <div className="grid grid-cols-2 gap-20 max-w-[1080px] mx-auto shadow-xl p-5 mt-10">
      {" "}
      {/* Hier wird das Grid mit 2 Spalten erstellt */}
      <div className="bg-[#EBEDF0] text-white rounded-md  mx-auto my-auto text-5xl font-bold cursor-pointer">
        <div
          className="bg-[#111C24] rounded-2xl flex items-center justify-center p-5"
          onClick={() => setFormOpen(true)}
        >
          <button
            onClick={() => setFormOpen(true)}
            className="flex items-center"
          >
            +
          </button>
        </div>
      </div>
      {projects.map((project) => (
        <div key={project.title} className="mx-auto">
          <ProjectItem project={project} />
        </div>
      ))}
      <PopupFormCard
        isFormOpen={isFormOpen}
        handleCloseForm={handleCloseForm}
      />
    </div>
  );
};

export default ProjectView;
