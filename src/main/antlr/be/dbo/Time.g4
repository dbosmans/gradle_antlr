grammar Time;

@header {
    package be.dbo;
}

time : DIGIT DIGIT ':' DIGIT DIGIT;

DIGIT : [0-9];