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
# EPSILON    -->   ""
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
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
			@errors_found+=1
        end
        consume()
    end

    def program()
    	@errors_found = 0
		
		p = AST.new(Token.new("program","program"))
		
	    while( @lookahead.type != Token::EOF)
            p.addChild(statement())
        end
        
        puts "There were #{@errors_found} parse errors found."
      
		return p
    end

    def statement()
		stmt = AST.new(Token.new("statement","statement"))
        if (@lookahead.type == Token::PRINT)
			stmt = AST.new(@lookahead)
            match(Token::PRINT)
            stmt.addChild(exp())
        else
            stmt = assign()
        end
		return stmt
    end

    def exp()
       firstTerm = term()
       
           if (@lookahead.type == Token::ADDOP or @lookahead.type == Token::SUBOP)
               id = etail()
               id.addChild(firstTerm)
               return op
           end
           
       return firstTerm
    end

    def term()
        firstFactor = factor()
        
            if (@lookahead.type == Token::MULTOP or @lookahead.type == Token::DIVOP)
                id = ttail()
                id.addChild(firstFactor)
                return id
            end
            
        return firstFactor
    end

    def factor()
        fct = AST.new(Token.new("factor", "factor"))
        
            if (@lookahead.type == Token::LPAREN)
                match(Token::LPAREN)
                fct = exp()
                
                if (@lookahead.type == Token::RPAREN)
                    match(Token::RPAREN)
                else
                    match(Token::RPAREN)
                end
                
            elsif (@lookahead.type == Token::INT)
                fct = AST.new(@lookahead)
                match(Token::INT)
                
            elsif (@lookahead.type == Token::ID)
                fct = AST.new(@lookahead)
                match(Token::ID)
                
            else
                puts "Expected to see ( or INT Token or ID Token. Instead found #{@lookahead.text}"
                @errors_found+=1
                consume()
            end
            
        return fct
    end

    def ttail()
        tt_AST = AST.new(Token.new("op", "op"))
        
            if (@lookahead.type == Token::MULTOP)
                tt_AST = AST.new(@lookahead)
                    match(Token::MULTOP)
                    tt_AST.addChild(factor())
                    
                    ttail() != nil ? tt_AST.addChild(ttail()) : nil
                    
                   # next_tt_AST = ttail()
                    #if (next_tt_AST != nil)
                     #   tt_AST.addChild(next_tt_AST)
                    # end
                
            elsif (@lookahead.type == Token::DIVOP)
                tt_AST = AST.new(@lookahead)
                    match(Token::DIVOP)
                    tt_AST.addChild(factor())
                    
                    ttail() != nil ? tt_AST.addChild(ttail()) : nil
                    
                   # next_tt_AST = ttail()
                    #if (next_tt_AST != nil)
                     #   tt_AST.addChild(next_tt_AST)
                    # end
            
            else
                return nil
            end
            
        return tt_AST
    end

    def etail()
       et_AST = AST.new(Token.new("op", "op"))
       
           if (@lookahead.type == Token::ADDOP)
               et_AST = AST.new(@lookahead)
                    match(Token::ADDOP)
                    et_AST.addChild(term())
                    
                    etail() != nil ? et_AST.addChild(etail()) : nil

                 #   next_et_AST = etail()
                  #  if (next_et_AST != nil)
                   #     et_AST.addChild(next_et_AST)
                    # end
           
           elsif (@lookahead.type == Token::SUBOP)
                et_AST = AST.new(@lookahead)
                    match(Token::SUBOP)
                    et_AST.addChild(term())
                    
                    etail() != nil ? et_AST.addChild(etail()) : nil
                    
               #     next_et_AST = etail()
                #    if (next_et_AST != nil)
                 #       et_AST.addChild(next_et_AST)
                  #  end
                    
            else
                return nil
            end
           
       return et_AST
    end

    def assign()
        assgn = AST.new(Token.new("assignment","assignment"))
		if (@lookahead.type == Token::ID)
			idtok = AST.new(@lookahead)
			match(Token::ID)
			if (@lookahead.type == Token::ASSGN)
				assgn = AST.new(@lookahead)
				assgn.addChild(idtok)
            	match(Token::ASSGN)
				assgn.addChild(exp())
        	else
				match(Token::ASSGN)
			end
		else
			match(Token::ID)
        end
		return assgn
	end
end
