import React, { Component } from "react";
import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";

class ProjectItem extends Component {
  render() {
    return (
      <Card sx={{ width: "250px" }}>
        <CardMedia
          component="img"
          height="140"
          image="https://picsum.photos/200"
          alt="Beispieltitel"
        />
        <CardContent>
          <Typography variant="h5">Beispieltitel</Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Beispielbeschreibung hier.
          </Typography>
        </CardContent>
        <CardActions>
          <Typography variant="body2" color="textSecondary" component="p">
            Zuletzt bearbeitet: DATUM_HIER
          </Typography>
        </CardActions>
      </Card>
    );
  }
}

export default ProjectItem;
