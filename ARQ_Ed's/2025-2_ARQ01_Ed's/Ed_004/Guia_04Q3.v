// Guia_04Q3a.v
module Guia_04Q3a (output s, input x, y, z);
    assign s = (~x & ~y & z) | (~x & y & ~z) | (x & ~y & z) | (x & y & ~z);
endmodule

// Guia_04Q3b.v
module Guia_04Q3b (output s, input x, y, z);
    assign s = (~x & ~y & z) | (~x & y & z) | (x & ~y & z) | (x & y & z);
endmodule

// Guia_04Q3c.v
module Guia_04Q3c (output s, input x, y, w, z);
    assign s = (~x & ~y & ~w & z) |
               (~x & ~y & w & ~z) |
               (~x & y & ~w & z) |
               (~x & y & w & ~z) |
               (~x & y & w & z) |
               (x & ~y & w & z) |
               (x & y & w & z);
endmodule


// Guia_04Q3d.v
module Guia_04Q3d (output s, input x, y, w, z);
    assign s = (~x & ~y & ~w & ~z) |
               (~x & ~y & w & ~z) |
               (~x & y & w & ~z) |
               (x & ~y & ~w & ~z) |
               (x & ~y & w & ~z) |
               (x & y & ~w & ~z) |
               (x & y & w & ~z);
endmodule


// Guia_04Q3e.v
module Guia_04Q3e (output s, input x, y, w, z);
    assign s = (~x & ~y & ~w & ~z) |
               (~x & ~y & ~w & z) |
               (~x & y & w & ~z) |
               (x & ~y & ~w & z) |
               (x & ~y & w & z);
endmodule
