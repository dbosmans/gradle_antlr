grammar Flow;
@header {
    package be.dbo;
}

flowExpr  : DEP departure ARR arrival;
DEP : 'DEP' | 'dep' | 'Dep' ;
ARR : 'ARR' | 'arr' | 'Arr' ;
departure: AD;
arrival : AD;

AD :  [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ;