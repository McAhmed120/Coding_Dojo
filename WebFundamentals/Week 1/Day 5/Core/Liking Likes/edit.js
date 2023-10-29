// Get the like button and likes count element by their IDs
const likeButton = document.getElementById("likeButton");
const likesCount = document.getElementById("likesCount");

// Initialize the like count
let likeCount = 0;

// Add an event listener to the like button
likeButton.addEventListener("click", function () {
    // Increase the like count
    likeCount++;

    // Update the likes count element with the new count
    likesCount.textContent = likeCount;
});
