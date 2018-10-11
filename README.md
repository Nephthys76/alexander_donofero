#Alexander Donofero programming project
_for Illumina_

Alex, in this project you will find a partially started project. For this exercise, I will want you to implement a method that will 
fulfill the requirements below. If you implement the first method, and we still have time, we will try to get to the second method as well.

For each method, I have written a series of unit tests to test our test cases. The first one for each method passes, because the method is 
hard coded to return that answer. The other tests fail because the method is not yet implemented.


###Activity 1

The client has a String, which represents a comma separated list of integers. They would like to know how many integers would need to be added to 
the list in order to make it into a consecutive list of integers. 


#####Example:

- Input: `"5, 10, 15"`
- Output: `8`
- Explanation: In order for the input to become a list of consecutive integers, we would need to add the following integers: 6, 7, 8, 9, 11, 12, 13, 14. 
That is 8 integers


###Activity 2 (if time permits)

If the list of integers is not already consecutive, the client would like the list to be made consecutive. 
Return a string that is a comma separated list of the consecutive list that is derived from the input. 
Continuing with the above example...

#####Example:
- Input: `"5, 10, 15"`
- Output: `"5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15"`
- Explanation: The missing integers were added to the list, and the string was created to present the consecutive list in a comma separated list of integers.