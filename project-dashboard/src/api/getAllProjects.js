async function getAllProjects() {
    return await fetch("http://localhost:8080/api/projects");
}

export default getAllProjects;