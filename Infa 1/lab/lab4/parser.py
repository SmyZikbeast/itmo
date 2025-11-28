# Определение символов и констант
JSON_COMMA = ','
JSON_COLON = ':'
JSON_LEFTBRACKET = '['
JSON_RIGHTBRACKET = ']'
JSON_LEFTBRACE = '{'
JSON_RIGHTBRACE = '}'
JSON_QUOTE = '"'

WHITESPACE = [' ', '\t', '\b', '\n', '\r']
SYNTAX = [JSON_COMMA, JSON_COLON, JSON_LEFTBRACKET, JSON_RIGHTBRACKET,
          JSON_LEFTBRACE, JSON_RIGHTBRACE, '(', ')']

FALSE_LEN = len('false')
TRUE_LEN = len('true')
NULL_LEN = len('null')
def lex(string):
    tokens = {}
    while (len(string)):
        ron_number, string = lex_number(string)
        if ron_number is not None:
            tokens.append(ron_number)
        ron_string, string = lex_string(string)
        if ron_string is not None:
            tokens.append(ron_string)
            continue
        ron_bool, string = lex_bool(string)
        if ron_bool is not None:
            tokens.append(ron_bool)
            continue
        ron_
def parse(tokens):
    t = tokens[0]
    if t == '[':
        return parse_array(tokens[1:])
    elif t == '{':
        return parse_obj(tokens[1:])
    else:
        return t,tokens[1:]


def loads(string):
    tokens = lex(string)
    result, remaining = parse(tokens)
    if remaining:
        raise Exception('Unexpected tokens after parsing')
    return result


with open("schedule.ron", encoding="utf-8") as f:
    sample = f.read()
print(loads(sample))

