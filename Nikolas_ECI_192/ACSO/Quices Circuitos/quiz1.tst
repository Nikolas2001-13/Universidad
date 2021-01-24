load quiz1.hdl,
output-file quiz1.out,
output-list A B C S;
set A 0, set B 0, set C 0, eval, output;
set A 0, set B 0, set C 1, eval, output;
set A 0, set B 1, set C 0, eval, output;
set A 0, set B 1, set C 1, eval, output;
set A 1, set B 0, set C 0, eval, output;
set A 1, set B 0, set C 1, eval, output;
set A 1, set B 1, set C 0, eval, output;
set A 1, set B 1, set C 1, eval, output;
