with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

package body Assgn is 
-----------------------------------------------------------------------------------------------------------------------

   -- initialize first array (My_Array) with random binary values
   procedure Init_Array (Arr: in out BINARY_ARRAY) is
   begin
      -- initialise array
      Arr(16) := BINARY_NUMBER(1);
      -- loop thru and fill
      for Index in 1..15 loop
         Arr(Index) := BINARY_NUMBER(0);
      end loop;
   end Init_Array;
    
-----------------------------------------------------------------------------------------------------------------------

   -- accepts a BINARY_ARRAY and prints it to the console.
   procedure Print_Bin_Arr (Arr : in BINARY_ARRAY) is
   begin
      -- loop thru every index and print
      for Index in 1..16 loop
         Put_Line(BINARY_NUMBER'Image (Arr(Index)));
      end loop;
   end Print_Bin_Arr;
   
-----------------------------------------------------------------------------------------------------------------------

   -- accepts a BINARY_ARRAY and reverses it.
   procedure Reverse_Bin_Arr (Arr : in out BINARY_ARRAY) is
      Reversed_Array : BINARY_ARRAY; 
   begin
      -- loop thru every index and initialise to a new 'reversed' array
      for Index in 1..16 loop
         Reversed_Array(Index) := Arr(abs(Index - 17));
      end loop;
      -- loop thru every index and initialise to a new array
      for Index in 1..16 loop
         Arr(Index) := Reversed_Array(Index);
      end loop;
   end Reverse_Bin_Arr;
   
-----------------------------------------------------------------------------------------------------------------------

   -- accepts an INTEGER value and convert it to a BINARY_ARRAY.
   function Int_To_Bin(Num : in INTEGER) return BINARY_ARRAY is
      Arr_Output : BINARY_ARRAY;
      Int_Value : INTEGER;
   begin
      Int_Value := Num;
      for Index in reverse 1..16 loop
         Arr_Output(Index) := Int_Value mod 2;
         Int_Value := Int_Value / 2;
      end loop;
      return Arr_Output;
   end Int_To_Bin;

-----------------------------------------------------------------------------------------------------------------------

   -- accepts a BINARY_ARRAY and converts it to an integer.
   function Bin_To_Int (Arr : in BINARY_ARRAY) return INTEGER is
      Int_Output : INTEGER := 0;
      Conversion : INTEGER := 0;
      Reversed_Array : BINARY_ARRAY := Arr;
   begin
      Reverse_Bin_Arr(Reversed_Array);
      for Index in 0..15 loop
         Conversion := 2 ** Index * Reversed_Array(Index + 1);  
         Int_Output := Int_Output + Conversion;
      end loop;
      return Int_Output;
   end Bin_To_Int;

-----------------------------------------------------------------------------------------------------------------------

   -- overloaded + operator that accepts an INTEGER and BINARY_ARRAY type, adds them, and returns a BINARY_ARRAY.
   function "+" (Left : in INTEGER; Right : in BINARY_ARRAY) return BINARY_ARRAY is
   begin
      return Int_To_Bin(Left) + Right;
   end "+";

-----------------------------------------------------------------------------------------------------------------------

   -- overloaded + operator that accepts two BINARY_ARRAY types together, adds them, and returns a BINARY_ARRAY.
   function "+" (Left, Right : in BINARY_ARRAY) return BINARY_ARRAY is
      Sum : INTEGER := 0;
      Carry : BINARY_NUMBER := 0;
      Arr_Output : BINARY_ARRAY;
   begin
      for Index in reverse 1..16 loop
         Sum := Left(Index) + Right(Index) + Carry;
         Arr_Output(Index) := Sum mod 2;
      
         if Sum > 1 then
            Carry := 1;
         else
            Carry := 0;
         end if;
      end loop;
      return Arr_Output;
   end "+";

-----------------------------------------------------------------------------------------------------------------------

   -- overloaded - operator to subtract a BINARY_ARRAY type from an INTEGER type
   function "-" (Left : in Integer; Right : in BINARY_ARRAY) return BINARY_ARRAY is
   begin
      return Int_To_Bin(Left) - Right;
   end "-";

-----------------------------------------------------------------------------------------------------------------------

   -- overloaded - operator to subtract one BINARY_ARRAY type from another			 
   function "-" (Left, Right : in BINARY_ARRAY) return BINARY_ARRAY is
      Twos_Comp : BINARY_ARRAY;
      Arr_Output : BINARY_ARRAY;
   begin
      for Index in 1..16 loop
         Twos_Comp(Index) := (Right(Index) + 1) mod 2;
      end loop;
      Twos_Comp := INTEGER(1) + Twos_Comp;
   
      Arr_Output := Twos_Comp + Left;
      return Arr_Output;
   end "-";

-----------------------------------------------------------------------------------------------------------------------
end Assgn;