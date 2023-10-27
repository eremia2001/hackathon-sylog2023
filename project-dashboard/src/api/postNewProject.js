async function postNewProjects(project) {
    // JSON-Daten in die Datei schreiben
    return await fetch("http://localhost:8080/api/projects/create", {
        method: "POST",
        body: JSON.stringify(project),
        headers: new Headers({
            "Content-type": "application/json; UTF",
            "Access-Control-Allow-Origin": "http://localhost:8080"
        })
    })
}

export default postNewProjects;