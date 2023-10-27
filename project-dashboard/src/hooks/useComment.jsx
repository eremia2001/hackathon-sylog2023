import React, { useState } from "react";

// Initial comments data
const initialComments = [
  {
    name: "Jacob Smith",
    date: "Apr. 2, 2022",
    avatar: "https://flowbite.com/docs/images/people/profile-picture-3.jpg",
    comment:
      "I really appreciate the practical tips shared in this article. It's always a good reminder to focus on the foundational aspects of design.",
  },
  {
    name: "Sophia Johnson",
    date: "Apr. 10, 2022",
    avatar: "https://flowbite.com/docs/images/people/profile-picture-4.jpg",
    comment:
      "Absolutely agree! Tools are there to facilitate the process, but they can't replace good design thinking and strategy.",
  },
  {
    name: "Matthew Taylor",
    date: "May. 6, 2022",
    avatar: "https://flowbite.com/docs/images/people/profile-picture-5.jpg",
    comment:
      "This article was a refresher on the importance of understanding the 'why' before the 'how'. Thanks for sharing!",
  },
  {
    name: "Olivia Davis",
    date: "Jun. 12, 2022",
    avatar: "https://flowbite.com/docs/images/people/profile-picture-6.jpg",
    comment:
      "A well-thought design strategy is what sets successful projects apart from the rest. This article explains that very well.",
  },
];

// Custom hook to manage comments
export const useComment = () => {
  const [comments, setComments] = useState(initialComments);
  const [newComment, setNewComment] = useState("");

  const handleCommentChange = (event) => {
    console.log("" + newComment);
    setNewComment(event.target.value);
  };

  const handleCommentSubmit = (event) => {
    event.preventDefault();
    if (newComment.trim()) {
      const newCommentData = {
        name: "Your Name", // Replace with the actual name
        date: new Date().toLocaleDateString("en-US", {
          month: "short",
          day: "2-digit",
          year: "numeric",
        }),
        avatar: "https://your-avatar-url.com", // Replace with the actual avatar URL
        comment: newComment,
      };
      setComments([...comments, newCommentData]);
      setNewComment(""); // Clear the textarea
    }
  };

  return {
    comments,
    newComment,
    handleCommentChange,
    handleCommentSubmit,
  };
};
