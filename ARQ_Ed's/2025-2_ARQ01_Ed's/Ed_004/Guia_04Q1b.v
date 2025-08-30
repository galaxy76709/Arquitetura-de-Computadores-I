// Guia_04Q1b.v
module Guia_04Q1b;
    reg a, b; 
    wire s;

    assign s = a | ~b;  // expressao de Q1b

    initial begin
        $display("a b | s");
        $display("-----------");
        a=0; b=0; #1 $display("%b %b | %b", a, b, s);
        a=0; b=1; #1 $display("%b %b | %b", a, b, s);
        a=1; b=0; #1 $display("%b %b | %b", a, b, s);
        a=1; b=1; #1 $display("%b %b | %b", a, b, s);
    end
endmodule
