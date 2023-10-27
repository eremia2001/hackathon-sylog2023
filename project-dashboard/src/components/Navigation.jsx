import React from "react";

function Navigation({ navigateTo }) {
  const [activePage, setActivePage] = React.useState("MyProjects");

  const handleNavigationClick = (page) => {
    setActivePage(page);
    navigateTo(page);
  };

  return (
    <nav className="border-gray-200 bg-gray-50 dark:bg-gray-800 dark:border-gray-700">
      <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
        <a href="#" className="flex items-center">
          <img
            src="https://flowbite.com/docs/images/logo.svg"
            className="h-8 mr-3"
            alt="Flowbite Logo"
          />
          <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
            NGONetwork
          </span>
        </a>
        <div className="hidden w-full md:block md:w-auto" id="navbar-solid-bg">
          <ul className="flex flex-col font-medium mt-4 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-transparent dark:bg-gray-800 md:dark:bg-transparent dark:border-gray-700">
            <li>
              <a
                href="#"
                onClick={() => handleNavigationClick("MyProjects")}
                className={`block py-2 pl-3 pr-4  ${
                  activePage === "MyProjects"
                    ? "text-blue-700"
                    : " hover:text-blue-700 text-gray-900"
                } rounded md:bg-transparent md:p-0 md:dark:text-blue-500 dark:bg-blue-600 md:dark:bg-transparent`}
              >
                Meine Projekte
              </a>
            </li>

            <li>
              <a
                href="#"
                onClick={() => handleNavigationClick("AllProjects")}
                className={`block py-2 pl-3 pr-4 ${
                  activePage === "AllProjects"
                    ? "text-blue-700"
                    : " hover:text-blue-700 text-gray-900"
                } rounded md:bg-transparent md:p-0 md:dark:text-blue-500 dark:bg-blue-600 md:dark:bg-transparent`}
              >
                Alle Projekte
              </a>
            </li>
            <li>
              <a
                  href="#"
                  onClick={() => handleNavigationClick("ProjectDetail")}
                  className={`block py-2 pl-3 pr-4 ${
                      activePage === "ProjectDetail"
                          ? "text-blue-700"
                          : " hover:text-blue-700 text-gray-900"
                  } rounded md:bg-transparent md:p-0 md:dark:text-blue-500 dark:bg-blue-600 md:dark:bg-transparent`}
              >
                Project Detail
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navigation;
