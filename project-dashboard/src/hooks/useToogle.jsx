import { useState } from "react";

export const useToggle = (initialState = "right") => {
  const [selected, setSelected] = useState(initialState);

  const toggle = (value) => {
    setSelected(value);
  };

  return [selected, toggle];
};
