import { React, useState } from "react";
import Navigation from "./components/Navigation";
import { useNavigation } from "./hooks/useNavigation";
import MyProjectsPage from "./pages/MyProjectsPage";
import AllProjectsPage from "./pages/AllProjectsPage";
import ProjectDetailsPage from "./pages/ProjectDetailsPage";

function App() {
  const { currentView, navigateTo } = useNavigation();
  const [clickedProject, setClickedProject] = useState("");
  const handleProjectClick = (projectName) => {
    setClickedProject(projectName);
    navigateTo("ProjectDetails");
  };

  return (
    <div className="flex flex-col">
      <Navigation navigateTo={navigateTo} />
      <div className="flex flex-col pt-10">
        {currentView === "MyProjects" && (
          <MyProjectsPage handleProjectClick={handleProjectClick} />
        )}
        {currentView === "AllProjects" && (
          <AllProjectsPage handleProjectClick={handleProjectClick} />
        )}
        {currentView === "ProjectDetails" && (
          <ProjectDetailsPage project={clickedProject} />
        )}
      </div>
    </div>
  );
}

export default App;
