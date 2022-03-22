# SRPNCalculator
This is a Git repository that contains the Java program for Assignment 1 of _Principles of Programming_ module
of the MSc Computer Science of University of Bath.

A Java program to match the functionality of a Saturated Reverse Polish Notation Calculator (SRPN).

_Explanation:_

In reverse Polish notation, the operators follow their operands. For instance, to add 3 and 4 together, one would write 3 4 + rather than 3 + 4. 

If there are multiple operations, operators are given immediately after their final operands (often an operator takes two operands, in which case the operator is written after the second operand); so the expression written 3 − 4 + 5 in conventional notation would be written 3 4 − 5 + in reverse Polish notation: 4 is first subtracted from 3, then 5 is added to it. An advantage of reverse Polish notation is that it removes the need for parentheses that are required by infix notation. While 3 − 4 × 5 can also be written 3 − (4 × 5), that means something quite different from (3 − 4) × 5. 

In reverse Polish notation, the former could be written 3 4 5 × −, which unambiguously means 3 (4 5 ×) − which reduces to 3 20 − (which can further be reduced to -17); the latter could be written 3 4 − 5 × (or 5 3 4 − ×, if keeping similar formatting), which unambiguously means (3 4 −) 5 ×.

_(Explanation taken from Wikipedia)_

Replit Link: 

https://replit.com/@sg2550/Coursework1-SRPN-v15
