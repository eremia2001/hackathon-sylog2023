import React from "react";

const ToDoComponent = ({ todos }) => {
  const onDoingTodos = todos.filter((todo) => todo.status === "in progress");

  return (
    <div className="overflow-x-auto flex flex-col">
      <h1 className="text-2xl font-bold mx-auto">Doing</h1>
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
          {onDoingTodos.map((todo, index) => (
            <tr key={index}>
              <td className="sticky inset-y-0 start-0 bg-white px-4 py-2">
                <label className="sr-only" htmlFor={`Row${index + 1}`}>
                  Row {index + 1}
                </label>
                <input
                  className="h-5 w-5 rounded border-gray-300"
                  type="checkbox"
                  id={`Row${index + 1}`}
                />
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
