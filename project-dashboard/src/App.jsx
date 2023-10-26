import * as React from "react";
import Navigation from "./components/Navigation";
import {useNavigation} from "./hooks/useNavigation";
import MyProjectsPage from "./pages/MyProjectsPage";
import AllProjectsPage from "./pages/AllProjectsPage";
import ProjectDetailView from "./components/ProjectDetailView";

function App() {
    const {currentView, navigateTo} = useNavigation();

    return (
        <div className="flex flex-col">
            <Navigation navigateTo={navigateTo}/>
            <div className="flex flex-col pt-10">
                {currentView === "MyProjects" && <MyProjectsPage/>}
                {currentView === "AllProjects" && <AllProjectsPage/>}
                {currentView === "ProjectDetail" && <ProjectDetailView/>}
            </div>
        </div>
    );
}

export default App;
