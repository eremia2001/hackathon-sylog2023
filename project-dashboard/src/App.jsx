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
      <Navigation></Navigation>
      <CreateProjectView></CreateProjectView>
    </div>
  );
}

export default App;
