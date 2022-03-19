## Bitbise operators

&(AND):true if both true
101
100
---
100

||(OR):true if anyone is true

101
100
---
101


^(XOR):If both bit are different then 1 if same then 0
101
100
---
001


~(NOT): complement operation . It toggles all bit of number .i.e  0 replaced by 1 and vice-versa
00000011 becomes 111111100


>>(RS):binary op shift bit toward right (convert to 2's complement then shifting in case of -ve number)
x=5 (0000101)
k=2
x>>k= (00001)
result= x/2^k

<<(LS): shifts bit toward left
x==0000101
k=2
x<<k
0010100
result=x*2^k

>>>(unsigned right shift op:   only java):considers sign bit also then shifting




##### signed number-> -inf to +inf (supported by java)-: represented by 2's complement
only -ve number represented by 2's compliment.
for ex.
let us we have only 3 bit to represent number.
-2 == 2^3 - 2=8-2=6 ==110(this is 2's complement representation of -2)
2 == simple decimal to binary ==010
-3 == 2^3-3 == 5 ==(101)

##### unsigned number -> 0 to +inf  (not supported by java)-: just convert to binary to find binary representation of a number

c++ support both signed and unsigned.
