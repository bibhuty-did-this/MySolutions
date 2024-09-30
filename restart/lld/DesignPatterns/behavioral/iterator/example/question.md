# Iterator Design Pattern - Practical Scenario

## Scenario: Designing a Social Media Feed Iterator

Consider you're developing a social media platform, and you need to display the news feed to the user. Posts in the feed can come from friends, followed pages, or advertisements, each stored in different data structures (e.g., lists, trees, queues).

You want to design an iterator that:
1. Iterates over posts in chronological order.
2. Combines posts from various sources (friends, pages, ads) but maintains a uniform way to iterate over them.
3. Supports operations like `next()`, `hasNext()`, and optionally `reset()` to start over.

### **Problem Statement**:
Design an iterator using the **Iterator Design Pattern** that handles posts from three different sources (friends' posts stored in a list, page posts stored in a queue, and ads stored in a priority queue). Your task is to design the iterator that:
1. Abstracts the iteration logic for different sources.
2. Ensures that all posts are retrieved in a sequential and consistent way.

The solution should handle the following:
- Implement the core `Iterator` interface with methods like `hasNext()` and `next()`.
- Create different collections for each post source and integrate them into a single iterator.
- Consider handling edge cases, such as one of the sources being empty or allowing the user to reset the iteration.

### Key Goals:
- Abstract traversal of different data structures.
- Combine multiple sources into a single unified iteration process.
- Maintain consistency in post order.