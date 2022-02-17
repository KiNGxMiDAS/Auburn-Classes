%% Lab 4: Mesh and Nodal Analysis
% Exercise 5
%     V1 V2 V3 V4 Vx Ix
A = [ 2  -2  3 -2  0  0; % SNE
      1   0 -1  0  0  0; % SNI
      0   1  0  0  2  0; % V2 Vx 
     -1   0 -1  3 -1 -2; % V4
      0   0  1  0  0 -1; % Ix
      0   0  0 -1  2  0; % Vx 
    ];

 
x = [ 6; % SNE
     12; % SNI
      0; % V2-Vx
      0; % V4
      0; % Ix
     -6];% Vx
    

result = A\x;

[V1, V2, V3, V4, Vx, Ix] = num2cell(result);

% result =
%         10.8
%         4.32
%        -1.2
%         1.68
%        -2.16
%        -1.2
