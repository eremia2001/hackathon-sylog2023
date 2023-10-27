async function getMyProjects(memberId) {
  return await fetch("http://localhost:8080/api/projects/members/" + 2);
}

export default getMyProjects;
