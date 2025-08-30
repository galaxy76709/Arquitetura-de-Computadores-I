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
