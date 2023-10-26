import { useState } from "react";
import getMyProjects from "../api/getMyProjects";

function useProjects() {
  const [projects, setProjects] = useState(getMyProjects());
  return [projects, setProjects];
}

export default useProjects;
