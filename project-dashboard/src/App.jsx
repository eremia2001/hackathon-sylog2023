import * as React from "react";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  Card,
  CardMedia,
  CardContent,
  CardActions,
  IconButton,
  Box,
} from "@mui/material";
import Navigation from "./components/Navigation";
import ProjectView from "./components/ProjectView";
import CreateProjectView from "./components/CreateProjectView";
import { useNavigation } from "./hooks/useNavigation";
import MyProjectsPage from "./pages/MyProjectsPage";
import AllProjectsPage from "./pages/AllProjectsPage";

function App() {
  const { currentView, navigateTo } = useNavigation();

  return (
    <div className="flex flex-col">
      <Navigation navigateTo={navigateTo} />
      <div className="flex flex-col pt-10">
        {currentView === "MyProjects" && <MyProjectsPage />}
        {currentView === "AllProjects" && <AllProjectsPage />}
      </div>
    </div>
  );
}

export default App;
