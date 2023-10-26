import React, { Component } from "react";
import { AppBar, Toolbar, Typography, Button } from "@mui/material";
class Navigation extends Component {
  render() {
    return (
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            LOGO.
          </Typography>
          <Button color="inherit">All Projects</Button>
          <Button color="inherit">My Projects</Button>
        </Toolbar>
      </AppBar>
    );
  }
}

export default Navigation;
