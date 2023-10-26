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
} from "@mui/material";
import Navigation from "./Navigation";
import ProjectView from "./ProjectView";

function App() {
  return (
    <div>
      {/* NavBar */}
      <Navigation />
      <ProjectView />
    </div>
  );
}

export default App;
