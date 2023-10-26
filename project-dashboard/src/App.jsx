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

function App() {
  return (
    <div className="flex flex-col">
      {/* NavBar */}
      <Navigation />
      <h1 className="mx-auto font-bold text-5xl mt-20">
        Projekte, die Veränderungen bewirken
      </h1>
      <p className="text-sm text-gray-500 mx-auto mt-2">
        Entdecken Sie die vielfältigen Initiativen, durch die unsere
        Gemeinschaft einen positiven Einfluss nimmt.
      </p>
      <div className="p-60">
        <ProjectView />
      </div>
    </div>
  );
}

export default App;
