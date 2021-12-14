; NAME:        Midas Oden
; STUDENT ID:  mto0006
; FILE NAME:   Midas_Oden.asm
; PROJECT:     3
; DESCRIPTION: Design of program will read a value from an array and place the value in another array with the location shifted by a certain amount. Array length may be anywhere between 2 to 100.

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword


.data
		; Create a BYTE array with the label 'input'. The newly created array should have eight elements, e.g. with vlaues 1 through 8.
		input byte 1, 2, 3, 4, 5, 6, 7, 8

		; Create a BYTE array with the label 'output'. The newly created array should be the same length as the 'input' array.
		output byte LENGTHOF input DUP(?)

		; Create a DWORD vaiables with the label 'shift. The newly created variable should hold a single value, e.g. which must be less than the length of the 'input' array.
		shift dword 3


.code
		main proc
					; clear all registers
					mov eax, 0			 
					mov ebx, 0				 
					mov ecx, shift

					
					L1:			; start of loop 1

						neg ecx
						mov al, input[LENGTHOF input + ecx]			; move the value from input into al
						mov output[ebx], al							; move the value from al into output
						inc ecx										; increment the input index
						inc ebx										; increment the output index
							
					loop L1

					mov ecx, LENGTHOF input			; configure registers ecx and edx for the first loop
					sub ecx
					mov edx, 0				


					L2:			; start of loop 2

						mov al, input[edx]				; move the value from input into al
						mov output[ebx], al				; move the value from al into output
						INC ebx							; increments the input index
						INC edx							; increments the outut index

					loop L2


				invoke ExitProcess, 0
		main endp
end main