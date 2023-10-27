import ProjectItem from "./ProjectItem";
import React, {useEffect, useState} from "react";
import PopupFormCard from "./CreateProjectView";
import getMyProjects from "../api/getMyProjects";

const ProjectView = () => {
    const [projects, setProjects] = useState([]);
    const [isFormOpen, setFormOpen] = useState(false);
    const [isMyProject, setMyProject] = useState(false)
    const handleCloseForm = () => setFormOpen(false);

    useEffect(() => {
        console.log("hallo ich bin daten" + projects)
        getMyProjects().then(projects => {
            setProjects(projects)
        })
    }, [projects]);

    if (isMyProject) {
        return (
            <div className="grid grid-cols-2 gap-20 max-w-[1080px] mx-auto shadow-xl p-5 mt-10">
                {
                    isMyProject &&
                    <div
                        className="bg-[#EBEDF0] text-white rounded-md  mx-auto my-auto text-5xl font-bold cursor-pointer">
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
                }
                {/* Hier wird das Grid mit 2 Spalten erstellt */}
                {projects.map((project) => {
                    if (project.ngo === "NGO 1") {
                        return (<div key={project.title} className="mx-auto">
                            <ProjectItem project={project}/>
                        </div>)
                    }
                })}
                <PopupFormCard
                    isFormOpen={isFormOpen}
                    handleCloseForm={handleCloseForm}
                />
            </div>
        )
    } else {
        return (
            <div className="grid grid-cols-2 gap-20 max-w-[1080px] mx-auto shadow-xl p-5 mt-10">
                {projects.map((project) => (
                    <div key={project.title} className="mx-auto">
                        <ProjectItem project={project}/>
                    </div>
                ))}
            </div>
        )
    }
};


export default ProjectView;
