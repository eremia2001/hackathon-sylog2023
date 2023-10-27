import mockup_data from "../data/myProjects.json";
async function getMyProjects(memberId) {
  return await fetch("http://localhost:8080/projects/members/" + memberId);
}

export default getMyProjects;
