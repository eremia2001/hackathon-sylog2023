import * as fs from "fs";
async function postNewProjects(object, filePath) {
    const jsonData = JSON.stringify(object, null, 2); // Das 'null, 2' sorgt für eine formatierte Ausgabe mit Einrückungen

    // JSON-Daten in die Datei schreiben
    fs.writeFile(filePath, jsonData, 'utf8', (err) => {
        if (err) {
            console.error('Fehler beim Schreiben der JSON-Datei:', err);
        } else {
            console.log('JSON-Datei erfolgreich erstellt: ' + filePath);
        }
    });
}

export default postNewProjects;