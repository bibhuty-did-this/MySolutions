
- Guiding Principles:(Rules to generally follow)
  - SOLID
  - Inheritance
  - Encapsulation
  - Abstraction
  - Composition
- Design Patterns:(Blueprints for thinking. Have been solved before)
  - Prototype Pattern

### Problem Statement:
* Turn based AI Game with goal:
  * Requirement: Taking a turn based game and having the ability to play it through AI
  * Things to ensure about the code:
    * Readable:
      * Easier to debug
      * Easier to change
      * Easier to test case
    * Extensible:
      * Minor feature addition shouldn't require major change
    * Correct:
      * Cost of fixing prod bug is high, so correctness is bare minimum
  * Thought Process:
    * _**Do all the board have cells?**_ If the ans is yes then its obvious to put **getCell** method in the parent board class. If the answer is no or may be then its better to add it at the specific board class here that is **TicTacToeBoard** class.
    * _**Single Responsiblity Principle**_
      * Starting and moving a game should be part of a ```GameEngine``` but functions like **checking for completion** and **suggesting moves** should not be part of the same
      * | Class         | Responsibility                           |
        | ------------- | ----------------------------------------- |
        | GameEngine    | Any changes in the board                  |
        | AIPlayer      | Smartness or AI decisions                 |
        | RuleEngine    | Making sure all rules are followed        |
    * _**Open Closed Principle**_
      * `Open` for extension, `Closed` for modification
        * Make minimal changes to the existing code when you want to add a new functionality
        * Don't break things which are already working very well. 
        * Adding a wrapper on top of working code is far better than editing the core of a working code
        * Example: In our rule engine we made the rules configurable instead of keeping it in `getState`. Imagine the amount of changes we had to do in that case. It would have messed up the core functionality all the time.
    * _**Prototype Design Pattern:**_
      * Gives you a fresh object with the changed state you are looking for without altering the current object
      * Example: 
        * Config cloning with complex configurations
        * Similar object cloning where diff in minimal
    * _**Iterator Design Pattern:**_
      * The Iterator Design Pattern simplifies how you interact with collections by separating the logic of iteration from the structure of the collection itself. This pattern encapsulates the iteration logic within a separate object (the Iterator), which you can use to move through the collection without exposing its internal details.
      * **Why Use the Iterator Pattern?**
        * Imagine you have different types of collections (like an ArrayList, Set, or Tree), each with its own way of storing and managing data. Without the Iterator pattern, you’d need to know the specific structure of each collection to iterate over it. This violates the Single Responsibility Principle, because you’d be mixing iteration logic with collection logic. With the Iterator pattern:
          * You can traverse a collection without exposing its internal implementation. 
          * The client code doesn’t need to know whether the collection is an array, list, tree, etc. 
          * It provides a consistent interface to traverse different types of collections.
    * _**Builder Design Pattern:**_
    * _**DRY Principle:**_ **D**on't **R**epeat **Y**ourself
      * Don't overfit in the name of DRY principle and messup the entire codebase
    * **Unit Test:**
      * Add test to check behaviour of `GamePlay`
        * **Iteration 1:** Added tests according to hard-coded algorithms of AI engine. Although it check 2 out of 3 principles i.e **_Readble_** and **_Correct_**, but it fails terribly when it comes to being **_Extensible_**. Since we've hardcoded the moves of the human we are assuming that at every next step the AI won't go there, that's totally wrong.
        * **Iteration 2:** 
          * Should we modify the test according to current logic?
            * Not really, we can't afford to to infinite changes
          * Enforce logic to AI Engine or say hardcode the AI steps?
            * We should because unit tests are not always for testing non-deterministic data. Let's have a separate test for those cases in case needed but let's not put non-deterministic test cases while writing our test whose result can mess-up our entire testing approach.
### Ad-hoc:
* **API**: Methods to be exposed to allow limited internal state change
* **Anti-pattern:**
* **Approach:** 
  * Instead of finding principles and enforcing it in the code, we need to find the problems in the code and then see what principle can work best with it.
  * Instead of writing classes or following patterns first, let's focus on the functionality first and then extract it to patterns
