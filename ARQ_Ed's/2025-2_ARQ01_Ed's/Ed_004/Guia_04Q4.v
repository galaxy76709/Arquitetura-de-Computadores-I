// Guia_04Q3a_PoS.v
module Guia_04Q3a_PoS (output s, input x, y, z);
    // s = (x+y+z') & (x+y'+z') & (x'+y+z') & (x'+y'+z')
    assign s = (x | y | ~z) & (x | ~y | ~z) & (~x | y | ~z) & (~x | ~y | ~z);
endmodule

// Guia_04Q3a_Simplified.v
module Guia_04Q3a_Simplified (output s, input x, y, z);
    assign s = ~z;
endmodule

 //--------------- 


// Guia_04Q3b_PoS.v
module Guia_04Q3b_PoS (output s, input x, y, z);
    // s = (x+y+z) & (x+y'+z) & (x'+y+z) & (x'+y'+z)
    assign s = (x | y | z) & (x | ~y | z) & (~x | y | z) & (~x | ~y | z);
endmodule

// Guia_04Q3b_Simplified.v
module Guia_04Q3b_Simplified (output s, input x, y, z);
    assign s = z;
endmodule

 //--------------- 


 // Guia_04Q3c_PoS.v
module Guia_04Q3c_PoS (output s, input x, y, w, z);
    assign s = (x | y | w | z) & (x | y | w | ~z) & (x | y | ~w | z) & 
               (x | y | ~w | ~z) & (x | ~y | ~w | z) & (x | ~y | ~w | ~z) & 
               (~x | y | ~w | ~z) & (~x | ~y | w | ~z);
endmodule

// Guia_04Q3c_Simplified.v
module Guia_04Q3c_Simplified (output s, input x, y, w, z);
    // Minterms: 4, 5, 8, 9, 10, 12, 14, 15
    assign s = (~x & y & ~w & ~z) | (~x & y & ~w & z) | (x & ~y & ~w & ~z) |
               (x & ~y & ~w & z) | (x & ~y & w & ~z) | (x & y & ~w & ~z) |
               (x & y & w & ~z) | (x & y & w & z);
endmodule


 //--------------- 



// Guia_04Q3d_PoS.v
module Guia_04Q3d_PoS (output s, input x, y, w, z);
    assign s = (x | y | w | ~z) & (x | y | ~w | z) & (x | ~y | w | z) & 
               (x | ~y | ~w | z) & (~x | y | w | z) & (~x | y | ~w | z) & 
               (~x | ~y | ~w | z);
endmodule


// Guia_04Q3d_Simplified.v
module Guia_04Q3d_Simplified (output s, input x, y, w, z);
    assign s = ~(x ^ y ^ w ^ z); // XNOR de 4 entradas
endmodule


 //--------------- 


// Guia_04Q3e_PoS.v
module Guia_04Q3e_PoS (output s, input x, y, w, z);
    assign s = (x | y | w | z) & (x | y | w | ~z) & (x | y | ~w | z) & 
               (x | y | ~w | ~z) & (x | ~y | w | ~z) & (~x | y | ~w | ~z) &
               (~x | ~y | ~w | ~z);
endmodule


// Guia_04Q3e_Simplified.v
module Guia_04Q3e_Simplified (output s, input x, y, w, z);
    // Expressão simplificada dos mintermos
    assign s = (y & ~z) | (x & ~y) | (~x & y & w) | (x & y & w);
endmodule