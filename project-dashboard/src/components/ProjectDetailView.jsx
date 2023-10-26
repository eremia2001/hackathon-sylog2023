import React, {Component} from 'react';
import ProjectItem from "./ProjectItem";

class ProjectDetailView extends Component {

    constructor(props) {
        super(props);
        this.state = {
            project: {
                "id":
                    2,
                "title":
                    "Projekt 2",
                "imageURL":
                    "https://example.com/image2.jpg",
                "description":
                    "Ein weiteres Beispielprojekt.",
                "tasks":
                    [
                        "Aufgabe 4",
                        "Aufgabe 5"
                    ],
                "resources":
                    [
                        "Ressource 3"
                    ],
                "assignedPeople":
                    3,
                "ngo":
                    "NGO 2"
            }
        }
    }

    render() {
        return (
            <div></div>
        );
    }
}

export default ProjectDetailView;