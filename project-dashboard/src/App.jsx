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

function App() {
  return (
    <div className="flex flex-col">
      <Navigation />
      <ProjectView className="p-16" />
    </div>
  );
}

export default App;
