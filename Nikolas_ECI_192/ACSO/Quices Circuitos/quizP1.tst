load quiz.hdl,
output-file quiz.out,
output-list A B C Y Z;
set A 0, set B 0, set C 0, eval, output;
set A 0, set B 0, set C 1, eval, output;
set A 0, set B 1, set C 0, eval, output;
set A 0, set B 1, set C 1, eval, output;
set A 1, set B 0, set C 0, eval, output;
set A 1, set B 0, set C 1, eval, output;
set A 1, set B 1, set C 0, eval, output;
set A 1, set B 1, set C 1, eval, output;