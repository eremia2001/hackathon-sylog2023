import { useState } from "react";

export function useNavigation() {
  const [currentView, setCurrentView] = useState("MyProjects");

  const navigateTo = (view) => {
    setCurrentView(view);
  };

  return { currentView, navigateTo };
}
