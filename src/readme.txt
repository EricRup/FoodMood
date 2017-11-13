Per our Code Review, we removed all of the outstanding bad smells noted in 
relation to our code.

Many of these included the use of switch statements, improperly delegating 
responsibility and duplicate and dead code that was useless. To fix these, we 
consolidated and modulated our code to increase readability and performance.

The refactoring was done primarily in the DiaryFXMLController, where there was 
a lot of lengthy and redundant code, but there was also refactoring done in 
using the superclass Controller to initialize the EntryList for the application.