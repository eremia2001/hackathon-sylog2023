import React from "react";
import { useComment } from "../hooks/useComment";

const CommentSection = () => {
  const { comments, newComment, handleCommentChange, handleCommentSubmit } =
    useComment();
  const sortedComments = [...comments].sort((a, b) => {
    const dateA = new Date(a.date);
    const dateB = new Date(b.date);
    //return dateB - dateA;  // Für absteigende Sortierung (neueste zuerst)
    return dateA - dateB; // Für aufsteigende Sortierung (älteste zuerst)
  });

  return (
    <section className="bg-white dark:bg-gray-900 py-8 lg:py-16 antialiased">
      <div className="max-w-2xl mx-auto px-4">
        <div className="flex justify-between items-center mb-6">
          <h2 className="text-lg lg:text-2xl font-bold text-gray-900 dark:text-white">
            Discussion (20)
          </h2>
        </div>
        <form className="mb-6" onSubmit={handleCommentSubmit}>
          <div className="py-2 px-4 mb-4 bg-white rounded-lg rounded-t-lg border border-gray-200 dark:bg-gray-800 dark:border-gray-700">
            <label htmlFor="comment" className="sr-only">
              Your comment
            </label>
            <textarea
              id="comment"
              rows="6"
              className="px-0 w-full text-sm text-gray-900 border-0 focus:ring-0 focus:outline-none dark:text-white dark:placeholder-gray-400 dark:bg-gray-800"
              placeholder="Write a comment..."
              required
              value={newComment}
              onChange={handleCommentChange}
            ></textarea>
          </div>
          <button
            type="submit"
            className="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-blue-700 rounded-lg focus:ring-4 focus:ring-primary-200 dark:focus:ring-primary-900 hover:bg-primary-800"
          >
            Post comment
          </button>
        </form>
        {sortedComments.map((comment, index) => (
          <article
            key={index}
            className="p-6 text-base bg-white rounded-lg dark:bg-gray-900"
          >
            <footer className="flex justify-between items-center mb-2">
              <div className="flex items-center">
                <p className="inline-flex items-center mr-3 text-sm text-gray-900 dark:text-white font-semibold">
                  <img
                    className="mr-2 w-6 h-6 rounded-full"
                    src={comment.avatar}
                    alt={comment.name}
                  />
                  {comment.name}
                </p>
                <p className="text-sm text-gray-600 dark:text-gray-400">
                  <time pubdate dateTime={comment.date} title={comment.date}>
                    {comment.date}
                  </time>
                </p>
              </div>
              {/* Rest des Codes für Dropdown-Menu und Kommentartext */}
            </footer>
            <p className="text-gray-500 dark:text-gray-400">
              {comment.comment}
            </p>
            {/* Rest des Codes für Antwort-Button */}
          </article>
        ))}
      </div>
    </section>
  );
};

export default CommentSection;
