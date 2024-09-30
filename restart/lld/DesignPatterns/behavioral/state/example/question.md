### Question on State Design Pattern

**Question:**  
You are tasked with designing a **Document Workflow System** for a document management application. In this system, documents can exist in multiple states, such as **Draft**, **Review**, **Approved**, and **Rejected**. Each state should have its own behavior, influencing what actions can be performed on the document.

1. Define a `Document` class that maintains its current state.
2. Create an interface `State` with methods for actions such as `edit()`, `submitForReview()`, `approve()`, and `reject()`.
3. Implement concrete state classes (`DraftState`, `ReviewState`, `ApprovedState`, `RejectedState`) that define the behavior for each state.
4. Demonstrate how changing states works, including what actions are available at each state and how transitions occur.

#### Requirements:
- Ensure that each state handles state transitions appropriately.
- Include a main method to simulate the document workflow, showing how a document moves through different states based on user actions.