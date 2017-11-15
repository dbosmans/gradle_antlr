grammar Flow;

import Time;

flowExpr  : DEP departure ARR arrival ON? time?;
DEP : 'DEP' | 'dep' | 'Dep' ;
ARR : 'ARR' | 'arr' | 'Arr' ;
ON : 'O'| 'o' 'n' | 'n' ;

departure: AD;
arrival : AD;

AD :  [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ;