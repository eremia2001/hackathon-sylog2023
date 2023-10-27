import React from "react";

const ToDoComponent = ({ todos }) => {
  const finishedTodos = todos.filter((todo) => todo.status === "done");

  return (
    <div className="overflow-x-auto flex flex-col">
      <h1 className="text-2xl font-bold mx-auto">Done</h1>
      <table className="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
        <thead className="ltr:text-left rtl:text-right">
          <tr>
            <th className="sticky inset-y-0 start-0 bg-white px-4 py-2"></th>
            <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
              To-Do
            </th>
            <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
              Owner
            </th>
            <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
              Deadline
            </th>
          </tr>
        </thead>

        <tbody className="divide-y divide-gray-200">
          {finishedTodos.map((todo, index) => (
            <tr key={index}>
              <td className="sticky inset-y-0 start-0 bg-white px-4 py-2">
                <label className="sr-only" htmlFor={`Row${index + 1}`}>
                  Row {index + 1}
                </label>
                <button
                  className=" w-28 rounded  border-2 border-gray-500 hover:border-blue-700 text-black"
                  id={`Row${index + 1}`}
                >
                  Start
                </button>
              </td>
              <td className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
                {todo.task}
              </td>
              <td className="whitespace-nowrap px-4 py-2 text-gray-700">
                {todo.owner}
              </td>
              <td className="whitespace-nowrap px-4 py-2 text-gray-700">
                {todo.deadline}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ToDoComponent;
