# https://www.cs.rochester.edu/~brown/173/readings/05_grammars.txt
#
#  "TINY" Grammar
#
# PGM        -->   STMT+
# STMT       -->   ASSIGN   |   "print"  EXP
# ASSIGN     -->   ID  "="  EXP
# EXP        -->   TERM   ETAIL
# ETAIL      -->   "+" TERM   ETAIL  | "-" TERM   ETAIL | EPSILON
# TERM       -->   FACTOR  TTAIL
# TTAIL      -->   "*" FACTOR TTAIL  | "/" FACTOR TTAIL | EPSILON
# FACTOR     -->   "(" EXP ")" | INT | ID
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
load "Token.rb"
load "Lexer.rb"
class Parser < Scanner
	def initialize(filename)
    	super(filename)
    	consume()
   	end
   	
	def consume()
      	@lookahead = nextToken()
      	while(@lookahead.type == Token::WS)
        	@lookahead = nextToken()
      	end
   	end
  	
	def match(dtype)
      	if (@lookahead.type != dtype)
         	puts "Expected #{dtype} found #{@lookahead.text}"
      	end
      	consume()
   	end
   	
	def program()
      	while( @lookahead.type != Token::EOF)
        	puts "Entering STMT Rule"
			statement()  
      	end
   	end

	def statement()
		if (@lookahead.type == Token::PRINT)
			puts "Found PRINT Token: #{@lookahead.text}"
			match(Token::PRINT)
			puts "Entering EXP Rule"
			exp()
		else
			puts "Entering ASSGN Rule"
			assign()
		end
		
		puts "Exiting STMT Rule"
	end
end






def statement()
        enterRule("STMT")

        if (@lookahead.type == Token::PRINT)
            foundToken("PRINT")
            match(Token::PRINT)
            expr()
        else
            assign()
        end
        
        exitRule("STMT")
    end

    def assign()
        enterRule("ASSGN")

        if (@lookahead.type == Token::ID)
            foundToken("ID")
        end
        match(Token::ID)
        if (@lookahead.type == Token::ASSGN)
            foundToken("ASSGN")
        end
        match(Token::ASSGN)
        expr()

        exitRule("ASSGN")
    end

    def expr()
        enterRule("EXP")

        termRule()
        etailRule()

        exitRule("EXP")
    end

    def termRule()
        enterRule("TERM")

        factorRule()
        ttailRule()

        exitRule("TERM")
    end

    def factorRule()
        enterRule("FACTOR")

        if (@lookahead.type == Token::LPAREN)
            foundToken("LPAREN")
            match(Token::LPAREN)
            expr()
            
            if (@lookahead.type == Token::RPAREN)
                foundToken("RPAREN")
            end
            match(Token::RPAREN)
            
        elsif (@lookahead.type == Token::INT)
            foundToken("INT")
            match(Token::INT)
            
        elsif (@lookahead.type == Token::ID)
            foundToken("ID")
            match(Token::ID)
            
        else
            match(Token::LPAREN, Token::INT, Token::ID)
        end

        exitRule("FACTOR")
    end

    def ttailRule()
        enterRule("TTAIL")

        if (@lookahead.type == Token::MULTOP)
            foundToken("MULTOP")
            match(Token::MULTOP)
            factorRule()
            ttailRule()
            
        elsif (@lookahead.type == Token::DIVOP)
            foundToken("DIVOP")
            match(Token::DIVOP)
            factorRule()
            ttailRule()
            
        else
            chooseEpsilon("MULTOP", "DIVOP")
        end

        exitRule("TTAIL")
    end

    def etailRule()
        enterRule("ETAIL")

        if (@lookahead.type == Token::ADDOP)
            foundToken("ADDOP")
            match(Token::ADDOP)
            termRule()
            etailRule()
            
        elsif (@lookahead.type == Token::SUBOP)
            found_token("SUBOP")
            match(Token::SUBOP)
            termRule()
            etailRule()
            
        else
            chooseEpsilon("ADDOP", "SUBOP")
        end

        exitRule("ETAIL")
    end

    def enterRule(rule)
        
        puts "Entering #{rule} Rule"
        
    end

    def exitRule(rule)
        
        puts "Exiting #{rule} Rule"
        
    end

    def foundToken(token)
        
        puts "Found #{token} Token: #{@lookahead.text}"
        
    end

    def chooseEpsilon(*token)
        
        puts "Did not find #{token.join(" or ")} Token, choosing EPSILON production"
        
    end

end




def statement()
        if (@lookahead.type == Token::PRINT)
            puts "Found PRINT Token: #{@lookahead.text}"
            match(Token::PRINT)
            exprRule()
        else
            puts "Entering ASSGN Rule"
            assign()
            puts "Exiting ASSGN Rule"
        end
        
        puts "Exiting STMT Rule"
    end
    
    def assign()
        idRule()
        
        if (@lookahead.type == Token::ASSIGN)
            puts "Found ASSGN Token: #{@lookahead.text}"
        end
        match(Token::ASSGN)
        exprRule()
    end
    
    def exprRule()
        puts "Entering EXPR Rule"
        termRule()
        puts "Exiting EXPR Rule"
        
        if (@lookahead.type == Token::RPAREN)
           puts "Found RPAREN Token: #{lookahead.text}"
           consume()
        end
    end
    
    def termRule()
        puts "Entering "TERM Rule"
        factorRule()
        puts "Exiting TERM Rule"
    
        puts "Entering ETAIL Rule"
            etailRule()
        puts "Exiting ETAIL Rule"
    end
    
    def idRule()
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{lookahead.text}"
        end
        match(Token:ID)
    end
    
    def factorRule()
        puts "Entering FACTOR Rule"
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
            consume()
        
        elsif (@lookahead.type == Token::INT)
            puts "Found INT Token: #{@lookahead.text}"
            consume()
    
        elsif (@lookahead.type == Token::LPAREN)
            puts "Found LPAREN Token: #{@lookahead.text}"
            consume()
            exprRule()
    
        else
            puts "Expected #{Token::LPAREN} or #{Token::INT} or #{Token::ID} found #{@lookahead.type}"
            @@totalErrors = @@totalErrors + 1
            consume()
        end
    
        puts "Exiting FACTOR Rule"
    
        puts "Entering TTAIL Rule"
        ttailRule()
        puts "Exiting TTAIL Rule"
    
    end
    
    def ttailRule()
        if (@lookahead.type == Token::MULTOP)
            puts "Found MULTOP Token: #{@lookahead.text}"
            consume()
            factorRule()
    
        elsif (@lookahead.type == Token::DIVOP)
            puts "Found DIVOP Token: #{@lookahead.text}"
            consume()
            factorRule()
    
        else
            puts "Did not find #{token or DIVOP Token, choosing EPSILON production
        end
    end
    
    def etailRule()
        if (@lookahead.type == Token::ADDOP)
            puts "Found ADDOP Token: #{@lookahead.text}"
            consume()
            termRule()
    
        elsif (@lookahead.type == Token::SUBOP)
            puts "Found SUBOP Token: #{@lookahead.text}"
            consume()
            term()
    
        else
            puts "Did not find ADDOP or SUBOP Token, choosing EPSILON production"
        end
    end
end








def statement()
        puts "Entering STMT Rule"
        if (@lookahead.type == Token::PRINT)
            puts "Found PRINT Token: #{@lookahead.text}"
            match(Token::PRINT)
            expr()
        else
            assign()
        end
        
        puts "Exiting STMT Rule"
    end
    
    def assign()
        puts "Entering ASSGN Rule"
        id()
        if (@lookahead.type == Token::ASSGN)
            puts "Found ASSGN Token: #{@lookahead.text}"
            match(Token::ASSGN)
        else
            match(Token::ASSGN)
        end
        
        expr()
        puts "Exiting ASSGN Rule"
    end

    def expr()
        puts "Entering EXP Rule"
        termRule()
        etailRule()
        puts "Exiting EXP Rule"
    end

    def etailRule()
        puts "Entering ETAIL Rule"
        if (@lookahead.type == Token::ADDOP)
            puts "Found ADDOP Token: #{@lookahead.text}"
            match(Token::ADDOP)
            termRule()
            etailRule()
        elsif (@lookahead.type == Token::SUBOP)
            puts "Found SUBOP Token: #{@lookahead.text}"
            match(Token::SUBOP)
            termRule()
            etailRule()
        else
            puts "Did not find ADDOP or SUBOP Token, choosing EPSILON production"
        end

        puts "Exiting ETAIL Rule"
    end

    def termRule()
        puts "Entering TERM Rule"
        factorRule()
        ttailRule()
        puts "Exiting TERM Rule"
    end

    def ttailRule()
        puts "Entering TTAIL Rule"
        if (@lookahead.type == Token::MULTOP)
            puts "Found MULTOP Token: #{@lookahead.text}"
            match(Token::MULTOP)
            factorRule()
            ttailRule()
        elsif (@lookahead.type == Token::DIVOP)
            puts "Found DIVOP Token: #{@lookahead.text}"
            match(Token::DIVOP)
            factorRule()
            ttailRule()
        else
            puts "Did not find MULTOP or DIVOP Token, choosing EPSILON production"
        end

        puts "Exiting TTAIL Rule"
    end

    def factorRule()
        puts "Entering FACTOR Rule"
        if (@lookahead.type == Token::LPAREN)
            puts "Found LPAREN Token: #{@lookahead.text}"
            match(Token::LPAREN)
            expr()
            if (@lookahead.type == Token::RPAREN)
                puts "Found RPAREN Token: #{@lookahead.text}"
                match(Token::RPAREN)
            else
                match(Token::RPAREN)
            end
        elsif (@lookahead.type == Token::ID)
            id()
        elsif (@lookahead.type == Token::INT)
            int()
        else
            puts "Expected ( or INT or ID found #{@lookahead.type}"
            @totalErrors = totalErrors + 1
        end
        
        puts "Exiting FACTOR Rule"
    end

    def id()
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
            match(Token::ID)
        else
            match(Token::ID)
        end
    end

    def int()
        if(@lookahead.type == Token::INT)
            puts "Found INT Token: #{@lookahead.text}"
            match(Token::INT)
        else
            match(Token::INT)
        end
    end
end






@@totalErrors = 0

    def initialize(filename)
        super(filename)
        consume()
    end

    def consume()
        @lookahead = nextToken()
        while(@lookahead.type == Token::WS)
            @lookahead = nextToken()
        end
    end

    def match(dtype)
        if (@lookahead.type != dtype)
            puts "Expected #{dtype} found #{@lookahead.text}"
            @@totalErrors = @@totalErrors + 1
        end
        consume()
    end

    def program()
        while( @lookahead.type != Token::EOF)
            puts "Entering STMT Rule"
            statement()
        end
        
    puts "There were " + @@totalErrors.to_s + " parse errors found."
    end

    def statement()
        if (@lookahead.type == Token::PRINT)
            puts "Found PRINT Token: #{@lookahead.text}"
            match(Token::PRINT)
            exp()
        else
            puts "Entering ASSGN Rule"
            assign()
            puts "Exiting ASSGN Rule"
        end
        puts "Exiting STMT Rule"
    end
        
    def assign()
        id()
        if (@lookahead.type == Token::ASSGN)
            puts "Found ASSGN Token: #{@lookahead.text}"
        end
        match(Token::ASSGN)
        exp()
    end
        
    def exp()
        puts "Entering EXP Rule"
        term()
        puts "Exiting EXP Rule"
        if (@lookahead.type == Token::RPAREN)
            puts "Found RPAREN Token: #{@lookahead.text}"
            consume()
        end
    end

    def id()
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
        end
        match(Token::ID)
    end
    
    def term()
        puts "Entering TERM Rule"
        factor()
        puts "Exiting TERM Rule"
        puts "Entering ETAIL Rule"
        etail()
        puts "Exiting ETAIL Rule"
    end

    def factor()
        puts "Entering FACTOR Rule"
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
            consume()
        elsif (@lookahead.type == Token::INT)
            puts "Found INT Token: #{@lookahead.text}"
            consume()
        elsif (@lookahead.type == Token::LPAREN)
            puts "Found LPAREN Token: #{@lookahead.text}"
            consume()
            exp()
        else
            puts "Expected ( or INT or ID found #{@lookahead.text}"
            @@errorCount = @@errorCount + 1
            consume()
        end
        puts "Exiting FACTOR Rule"
        puts "Entering TTAIL Rule"
        ttail()
        puts "Exiting TTAIL Rule"
    end
        
    def ttail()
        if (@lookahead.type == Token::MULTOP)
            puts "Found MULTOP Token: #{@lookahead.text}"
            consume()
            factor()
        elsif (@lookahead.type == Token::DIVOP)
            puts "Found DIVOP Token: #{@lookahead.text}"
            consume()
            factor()
        else
            puts "Did not find MULTOP or DIVOP Token, choosing EPSILON production"
        end
    end
                
    def etail()
        if (@lookahead.type == Token::ADDOP)
            puts "Found ADDOP Token: #{@lookahead.text}"
            consume()
            term()
        elsif (@lookahead.type == Token::SUBOP)
            puts "Found SUBOP Token: #{@lookahead.text}"
            consume()
            term()
        else
            puts"Did not find ADDOP or SUBOP Token, choosing EPSILON production"
        end
    end
end







############ BELOW IS THE ACTUAL CODE

# https://www.cs.rochester.edu/~brown/173/readings/05_grammars.txt
#
#  "TINY" Grammar
#
# PGM        -->   STMT+
# STMT       -->   ASSIGN   |   "print"  EXP
# ASSIGN     -->   ID  "="  EXP
# EXP        -->   TERM   ETAIL
# ETAIL      -->   "+" TERM   ETAIL  | "-" TERM   ETAIL | EPSILON
# TERM       -->   FACTOR  TTAIL
# TTAIL      -->   "*" FACTOR TTAIL  | "/" FACTOR TTAIL | EPSILON
# FACTOR     -->   "(" EXP ")" | INT | ID
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
load "Token.rb"
load "Lexer.rb"
class Parser < Scanner
    @@totalErrors = 0

    def initialize(filename)
        super(filename)
        consume()
    end

    def consume()
        @lookahead = nextToken()
        while(@lookahead.type == Token::WS)
            @lookahead = nextToken()
        end
    end

    def match(dtype)
        if (@lookahead.type != dtype)
            puts "Expected #{dtype} found #{@lookahead.text}"
            @@totalErrors = @@totalErrors + 1
        end
        consume()
    end

    def program()
        while( @lookahead.type != Token::EOF)
            puts "Entering STMT Rule"
            statement()
        end
        
    puts "There were " + @@totalErrors.to_s + " parse errors found."
    end

    def statement()
        if (@lookahead.type == Token::PRINT)
            puts "Found PRINT Token: #{@lookahead.text}"
            match(Token::PRINT)
            exp()
        else
            puts "Entering ASSGN Rule"
            assign()
            puts "Exiting ASSGN Rule"
        end
        puts "Exiting STMT Rule"
    end
        
    def assign()
        id()
        if (@lookahead.type == Token::ASSGN)
            puts "Found ASSGN Token: #{@lookahead.text}"
        end
        match(Token::ASSGN)
        exp()
    end
        
    def exp()
        puts "Entering EXP Rule"
        term()
        puts "Exiting EXP Rule"
        if (@lookahead.type == Token::RPAREN)
            puts "Found RPAREN Token: #{@lookahead.text}"
            consume()
        end
    end

    def id()
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
        end
        match(Token::ID)
    end
    
    def term()
        puts "Entering TERM Rule"
        factor()
        puts "Exiting TERM Rule"
        puts "Entering ETAIL Rule"
        etail()
        puts "Exiting ETAIL Rule"
    end

    def factor()
        puts "Entering FACTOR Rule"
        if (@lookahead.type == Token::ID)
            puts "Found ID Token: #{@lookahead.text}"
            consume()
        elsif (@lookahead.type == Token::INT)
            puts "Found INT Token: #{@lookahead.text}"
            consume()
        elsif (@lookahead.type == Token::LPAREN)
            puts "Found LPAREN Token: #{@lookahead.text}"
            consume()
            exp()
        else
            puts "Expected ( or INT or ID found #{@lookahead.text}"
            @@totalErrors = @@totalErrors + 1
            consume()
        end
        puts "Exiting FACTOR Rule"
        puts "Entering TTAIL Rule"
        ttail()
        puts "Exiting TTAIL Rule"
    end
        
    def ttail()
        if (@lookahead.type == Token::MULTOP)
            puts "Found MULTOP Token: #{@lookahead.text}"
            consume()
            factor()
        elsif (@lookahead.type == Token::DIVOP)
            puts "Found DIVOP Token: #{@lookahead.text}"
            consume()
            factor()
        else
            puts "Did not find MULTOP or DIVOP Token, choosing EPSILON production"
        end
    end
                
    def etail()
        if (@lookahead.type == Token::ADDOP)
            puts "Found ADDOP Token: #{@lookahead.text}"
            consume()
            term()
        elsif (@lookahead.type == Token::SUBOP)
            puts "Found SUBOP Token: #{@lookahead.text}"
            consume()
            term()
        else
            puts"Did not find ADDOP or SUBOP Token, choosing EPSILON production"
        end
    end
end
