// Funcao 'a'
module funcao_a (output f, input x, y);
	assign f = x & ~y;
endmodule

// Funcao 'b'
module funcao_b (output f, input x, y);
	assign f = y;
endmodule

// Funcao 'c' - XNOR entre x e z
module funcao_c (output f, input x, y, z);
	assign f = ~(x ^ z);
endmodule

// Funcao 'd'
module funcao_d (output f, input x, y, z);
	assign f = (x & ~z) | (~y & z) | (y & ~z);
endmodule

// Funcao 'e' - XNOR entre y e z
module funcao_e (output f, input x, y, w, z);
	assign f = ~(y ^ z);
endmodule