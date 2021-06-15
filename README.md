# Rock-Paper-Scissors

In this file I implemented a version of the rock paper scissors game, where

the character R represents rock, P represents paper, and S represents scissors. The expression (R&S)

represents a game between the rock and the scissors, and therefore the winner (and the outcome)

will be R. We can also have more complicated expressions. For example, ((P&S)&(R&P)) will be

equivalent to (S&P) which in turn is equivalent to S. (You can think of the expression as a kind of

rock paper scissors tournament and the result is the winner of the tournament!) Note the input may

or may not be “valid”. We deﬁne valid input (recursively) as follows:

• R, P, and S are valid (single-character) inputs.

• (A&B) is also valid as long as A and B are valid.

Note this means that, for instance we have:

• R is valid (and the outcome is just R).

• (R&R) is valid (and we deﬁne the outcome to be R).

1


• (R&P&S) is invalid.

• R&P is invalid.

• (R&(P)) is invalid.

• )R&S( is invalid.

• ((R&S)) is invalid.

• (A&B) is invalid (invalid characters)

• (R& P) is invalid (invalid character(i.e., space))

\1. RPSGame

A program that given an input, outputs either “VALID” or “INVALID” depending on the

input. For this question you can assume

• The input is a single line.

• The length of the input is at most 1000 characters.

Input Sample

Output Sample

VALID

(R&(P&((P&R)&(R&R ) ) ) )

Here is another example.

Input Sample

R&(R&P )

Output Sample

INVALID

\2. ValidInput

A program that given the input, outputs the winner. You can assume that the input is

valid for this question.

Input Sample

Output Sample

S

( (R&P)&(S&S ))

Here is another example.

Input Sample

Output Sample

R

( ( ( R&P)&(P&S))&R)

2
