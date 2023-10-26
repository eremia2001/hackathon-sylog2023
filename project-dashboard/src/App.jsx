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
      <div className="flex flex-col pt-10">
        <h1 className="text-5xl font-bold mx-auto">Meine NGO-Projekte</h1>
        <p className="text-sm mx-auto text-gray-400 mt-2">
          Gemeinsam Veränderung schaffen: Deine Initiativen für eine bessere
          Welt.
        </p>
        <ProjectView />
      </div>
    </div>
  );
}

export default App;
