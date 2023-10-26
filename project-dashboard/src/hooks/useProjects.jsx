import { useState } from "react";
import getProjects from "../api/getProjects";

function useProjects() {
  const [projects, setProjects] = useState(getProjects());
  return [projects, setProjects];
}

export default useProjects;
