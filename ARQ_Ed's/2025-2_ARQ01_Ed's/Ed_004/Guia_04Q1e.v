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
