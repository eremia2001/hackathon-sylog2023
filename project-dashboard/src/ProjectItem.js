import React, {Component} from 'react';
import {Button, Card, CardActions, CardContent, CardMedia, Typography} from "@mui/material";
import Image from "./res/template.jpeg"

class ProjectItem extends Component {
    render() {
        return (
            <Card sx={{ maxWidth: 345 }}>
                <CardMedia
                    component="img"
                    alt="green iguana"
                    height="140"
                    image={Image}
                />
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        Project 1
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et
                    </Typography>

                </CardContent>
                <CardActions>
                    <Button size="small">Share</Button>
                    <Button size="small">Learn More</Button>
                </CardActions>
            </Card>
        );
    }
}

export default ProjectItem;