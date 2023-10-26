import React from "react";
import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";

const ProjectItem = ({ project }) => {
  const { title, image, description } = project;
  return (
    <div class="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
      <a href="#">
        <img
          class="rounded-t-lg w-full"
          src="https://picsum.photos/300/200"
          alt=""
        />
      </a>
      <div class="p-5">
        <a href="#">
          <h5 class="mb-2 text-2xl font-bold tracking-tight text[#212529] dark:text-white">
            {title}
          </h5>
        </a>
        <p class="mb-3 font-normal text-[#68717A]">{description}</p>
        <p class="mb-3 mt-10 font-normal text-[#6C757D]">
          Last updated 3 minutes ago
        </p>
      </div>
    </div>
  );
};

export default ProjectItem;

/*
    <Card sx={{ maxWidth: 345 }}>
      <CardMedia
        component="img"
        image="https://picsum.photos/id/237/200/300"
        alt="Beispieltitel"
        className="max-w-sm"
      />
      <CardContent>
        <Typography variant="h5">{title}</Typography>
        <Typography variant="body2" color="textSecondary" component="p">
          {description}
        </Typography>
      </CardContent>
      <CardActions>
        <Typography variant="body2" color="textSecondary" component="p">
          Zuletzt bearbeitet: DATUM_HIER
        </Typography>
      </CardActions>
    </Card>
*/
