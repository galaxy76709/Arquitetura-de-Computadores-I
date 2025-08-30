// Guia_04Q1a.v
module Guia_04Q1a;
// variaveis de entrada
    reg a, b; 
// saida
    wire s;

 // expressão logica
    assign s = ~a & b;  // exemplo de Q1a (troque pela proposicao correta)

    initial begin
        $display("a b | s");
        $display("-----------");
        a=0; b=0; #1 $display("%b %b | %b", a, b, s);
        a=0; b=1; #1 $display("%b %b | %b", a, b, s);
        a=1; b=0; #1 $display("%b %b | %b", a, b, s);
        a=1; b=1; #1 $display("%b %b | %b", a, b, s);
    end
endmodule
