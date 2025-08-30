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

// Guia_04Q1c.v
module Guia_04Q1c;
    reg p, q;
    wire not_p, not_q;
    wire p_and_notq, notp_and_q;
    wire result;

    not NOT1 (not_p, p);
    not NOT2 (not_q, q);

    and AND1 (p_and_notq, p, not_q);
    and AND2 (notp_and_q, not_p, q);

    or OR1 (result, p_and_notq, notp_and_q);

    initial begin
        $display("Guia_04Q1c - (p AND ~q) OR (~p AND q)");
        $display(" p q | result ");
        $display("--------------");
        p=0; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=0; q=1; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=1; #1 $display(" %b %b |   %b", p,q,result);
    end
endmodule


// Guia_04Q1d.v
module Guia_04Q1d;
    reg p, q;
    wire not_p, not_q;
    wire p_and_q, notp_and_notq;
    wire result;

    not NOT1 (not_p, p);
    not NOT2 (not_q, q);

    and AND1 (p_and_q, p, q);
    and AND2 (notp_and_notq, not_p, not_q);

    or OR1 (result, p_and_q, notp_and_notq);

    initial begin
        $display("Guia_04Q1d - (p AND q) OR (~p AND ~q)");
        $display(" p q | result ");
        $display("--------------");
        p=0; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=0; q=1; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=1; #1 $display(" %b %b |   %b", p,q,result);
    end
endmodule

// Guia_04Q1e.v
module Guia_04Q1e;
    reg p, q;
    wire not_p, not_q;
    wire p_or_q, notp_or_notq;
    wire result;

    not NOT1 (not_p, p);
    not NOT2 (not_q, q);

    or OR1 (p_or_q, p, q);
    or OR2 (notp_or_notq, not_p, not_q);

    and AND1 (result, p_or_q, notp_or_notq);

    initial begin
        $display("Guia_04Q1e - (p OR q) AND (~p OR ~q)");
        $display(" p q | result ");
        $display("--------------");
        p=0; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=0; q=1; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=0; #1 $display(" %b %b |   %b", p,q,result);
        p=1; q=1; #1 $display(" %b %b |   %b", p,q,result);
    end
endmodule

