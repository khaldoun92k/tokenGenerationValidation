# Token Generator/Validator 
The purpose of this project is to run generate and validate a Token based on the Luhn algorithm (see below for detail)

| Requirement | Version | Purpose of Choice                    |
|-------------|---------|--------------------------------------|
| JDK         | 20      | no particular reason                 |
| npm         | 9.5.1   | to be able to run the React frontend |
| Maven       | 3+      | building tool                        |

-> To run both service and UI (on window) execute **start.bat**


# Luhn algorithm

The check digit is computed as follows:

- If the number already contains the check digit, drop that digit to form the "payload".
- The check digit is most often the last digit.
- With the payload, start from the rightmost digit.
- Moving left, double the value of every second digit (including the rightmost digit).
- Sum the values of the resulting digits.
The check digit is calculated by (10-(s  mod 10)) mod 10, where s is the sum from step 3.

| Digits  | 3 | 3 | 7 | 9 | 5 | 1 | 3 | 5 | 6 | 1 | 1 | 0 | 8 | 7 | 9 | 5 |
|---------|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| Weight  | 2 | 1 | 2 | 1 | 2 | 1 | 2 | 1 | 2 | 1 | 2 | 1 | 2 | 1 | 2 | 1 |
| Product | 6 | 3 | 5 | 9 | 1 | 1 | 6 | 5 | 3 | 1 | 2 | 0 | 7 | 7 | 9 | 5 |

-> the sum of Product = 70 which ends with 0 so this number is valid
