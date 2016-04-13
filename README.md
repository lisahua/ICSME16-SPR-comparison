# ICSME16-SPR-comparison
We run both tools in 32-bit Linux Ubuntu Virtual Machine with default setting.
## SPR 
We use the SPR virtual machine provided by the author. 

* We first execute SPR by providing fix location. Out of 6 errors, SPR can generate a correct fix for RBTERR4 and a plausible fix for RBTERR1.
* We then use the default bug localization strategy and let SPR find the defect on the entire search space. SPR finds a correct fix for RBTERR4 and 4 plausible fixes out of 6 errors.


## GenProg
We use GenProg-2.2 in 2013 and install it on  32-bit Linux Ubuntu Virtual Machine

* Same as SPR, we compare its efficacy by providing fix location and exhaustively searching the entire search space. 
* To improve search effectiveness, we use two search strategies: Brute search strategy (default strategy) and Genetic Algirithm search strategy.


As the paper is under submission, we only provide generated patches in this repository. More data such as test cases, configuration, and faulty source code are available upon asking. 



