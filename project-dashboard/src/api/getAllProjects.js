import mockup_data from "../data/projects.json";
async function getAllProjects() {
    return await fetch("http://localhost:8080/projects");
}

export default getAllProjects;