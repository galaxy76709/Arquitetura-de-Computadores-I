// Guia_04Q2a.v
module Guia_04Q2a (output s, input x, y);
    assign s = (~x & y); // x'·y
endmodule

// Guia_04Q2b.v
module Guia_04Q2b (output s, input x, y);
    assign s = (x | y); // x + y
endmodule

// Guia_04Q2c.v
module Guia_04Q2c (output s, input x, y);
    assign s = x; // simplificado para x
endmodule

// Guia_04Q2d.v
module Guia_04Q2d (output s, input x, y);
    assign s = 1'b1; // sempre 1
endmodule

// Guia_04Q2e.v
module Guia_04Q2e (output s, input x, y);
    assign s = (x & ~y) | (~x & y); // XOR
endmodule
