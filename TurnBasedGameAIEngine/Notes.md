
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
    * **Unit Test:**
      * Add test to check behaviour of `GamePlay`
        * **Iteration 1:** Added tests according to hard-coded algorithms of AI engine. Although it check 2 out of 3 principles i.e **_Readble_** and **_Correct_**, but it fails terribly when it comes to being **_Extensible_**. Since we've hardcoded the moves of the human we are assuming that at every next step the AI won't go there, that's totally wrong.
### Ad-hoc:
* **API**: Methods to be exposed to allow limited internal state change
* **Anti-pattern:**