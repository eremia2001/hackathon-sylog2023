import React from "react";
import womanProfile from "../res/woman1.jpg";
import womanProfile2 from "../res/profile2.jpg";
import womanProfile3 from "../res/profile3.jpg";
import womanProfile4 from "../res/profile4.jpg";
import womanProfile5 from "../res/profile5.jpg";
import ToggleComponent from "../components/ToggleComponent";
import ToDoComponent from "../components/ToDoComponent";
import OnDoingTodo from "../components/OnDoingTodo";
import FinishedTodo from "../components/FinishedTodo";
import CommentSection from "../components/CommentSection";
import { useToggle } from "../hooks/useToogle";
import getProjectTasks from "../api/getProjectTasks";

const ProjectDetailsPage = ({ project }) => {
  const [selected, toggle] = useToggle();
  const projectTasks = getProjectTasks();

  return (
    <div className="flex flex-col max-w-[1080px] gap-3 mx-auto px-40 py-20 shadow-2xl">
      <img src={project.image} className="w-full object-cover" width={10} />
      <h1 className="text-3xl font-bold ">{project.title}</h1>
      <p className="text-gray-400 text-sm">{project.long_description}</p>

      <div className="flex flex-row gap-5 justify-center items-center">
        <img
          src={womanProfile}
          className=" rounded-full w-12 h-12 object-cover mr-2"
          width={1}
        />

        <div className="flex flex-col  w-full">
          <p>Anna Matthew </p>
          <p className="text-gray-500">Owner</p>
        </div>

        <div className="flex flex-col w-full">
          <p>20.10.2023 </p>
          <p className="text-gray-500">Start</p>
        </div>

        <div className="flex flex-col w-full">
          <p>30.06.2023 </p>
          <p className="text-gray-500">End</p>
        </div>
      </div>

      <div className="flex flex-row mt-2">
        <div className="flex flex-row items-center w-full mb-2">
          <img
            src={womanProfile2}
            alt="Nikola Fien"
            className="rounded-full w-12 h-12 object-cover mr-2"
          />
          <p>Nikola Fien</p>
        </div>

        <div className="flex flex-row items-center w-full mb-2">
          <img
            src={womanProfile3}
            alt="Mike Kielo"
            className="rounded-full w-12 h-12 object-cover mr-2"
          />
          <p>Mike Kielo</p>
        </div>

        <div className="flex flex-row items-center w-full mb-2">
          <img
            src={womanProfile4}
            alt="Sidney Edie"
            className="rounded-full w-12 h-12 object-cover mr-2"
          />
          <p>Sidney Edie</p>
        </div>

        <div className="flex flex-row items-center w-full mb-2">
          <img
            src={womanProfile5}
            alt="Amilia liro"
            className="rounded-full w-12 h-12 object-cover mr-2"
          />
          <p>Amilia liro</p>
        </div>

        <div className="flex flex-row items-center w-full mb-2 cursor-pointer">
          <button className="mt-2 rounded-full w-12 h-12 object-cover mr-2 border-2 border-gray-500 ">
            <p className="">+</p>
          </button>
        </div>
      </div>

      <ToggleComponent selected={selected} toggle={toggle} />
      {selected == "right" ? (
        <div className="flex flex-col gap-16">
          {" "}
          <ToDoComponent todos={projectTasks} />
          <OnDoingTodo todos={projectTasks} />
          <FinishedTodo todos={projectTasks} />
        </div>
      ) : (
        ""
      )}
      <CommentSection />
    </div>
  );
};

export default ProjectDetailsPage;
