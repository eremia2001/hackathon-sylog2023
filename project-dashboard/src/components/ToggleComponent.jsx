import React, { useState } from "react";

const ToggleComponent = ({ selected, toggle }) => {
  return (
    <div className="flex  p-2 rounded-md">
      <div
        onClick={() => toggle("left")}
        className={`flex-1 p-2 cursor-pointer rounded-xl ${
          selected === "left"
            ? "bg-blue-500 text-white "
            : "bg-gray-200 text-gray-700"
        }`}
      >
        Attachments
      </div>
      <div
        onClick={() => toggle("right")}
        className={`flex-1 p-2 cursor-pointer rounded-xl translate-x-[-50px] ${
          selected === "right"
            ? "bg-blue-500 text-white"
            : "bg-gray-200 text-gray-700"
        }`}
      >
        Tasks
      </div>
    </div>
  );
};

export default ToggleComponent;
