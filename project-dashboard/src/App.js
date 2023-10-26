import './App.css';
import ProjectItem from "./ProjectItem";
import Navigation from "./Navigation";
import CreateProjectView from "./CreateProjectView";

function App() {
  return (
    <div className="App">
        <Navigation></Navigation>
        <ProjectItem></ProjectItem>
        <CreateProjectView></CreateProjectView>
    </div>
  );
}

export default App;
