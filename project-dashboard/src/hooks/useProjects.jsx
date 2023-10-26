import {useEffect, useState} from "react";
import getMyProjects from "../api/getMyProjects";

function useProjects() {
    const [projects, setProjects] = useState(null);
    useEffect(() => {
      getMyProjects().then(projects => {
          setProjects(projects)
      })
    }, []);
    return [projects, setProjects];
}

export default useProjects;
