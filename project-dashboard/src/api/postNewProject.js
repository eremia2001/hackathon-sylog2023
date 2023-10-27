async function postNewProjects(project, filePath) {
    // JSON-Daten in die Datei schreiben
    return await fetch("http://localhost:8080/projects/create", {
        method: "POST",
        body: JSON.stringify(project),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
}

export default postNewProjects;