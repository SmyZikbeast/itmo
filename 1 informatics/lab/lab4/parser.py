RON_COMMA = ','
RON_COLON = ':'
RON_LEFTBRACKET = '['
RON_RIGHTBRACKET = ']'
RON_LEFTBRACE = '{'
RON_RIGHTBRACE = '}'
RON_QUOTE = '"'
RON_LEFTRBRACKET = '('
RON_RIGHTRBRACKET = ')'
WHITESPACE = [' ', '\t', '\b', '\n', '\r']
SYNTAX = [RON_COMMA, RON_COLON, RON_LEFTBRACKET, RON_RIGHTBRACKET,
          RON_LEFTBRACE, RON_RIGHTBRACE, RON_LEFTRBRACKET, RON_RIGHTRBRACKET]

FALSE_LEN = len('false')
TRUE_LEN = len('true')
NULL_LEN = len('null')

def lex(string):
    tokens = []
    while (len(string)):
        identifier, string = lex_identifier(string)
        if identifier is not None:
            tokens.append(identifier)
            continue
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
        ron_null, string = lex_null(string)
        if ron_null is not None:
            tokens.append(ron_null)
            continue
        if string[0] in WHITESPACE:
            string=string[1:]
            continue
        elif string[0] in SYNTAX:
            tokens.append(string[0])
            string=string[1:]
            continue
    return tokens

def lex_identifier(string):
    identifier = ''
    for c in string:
        if c.isalnum() or c in ['_', '-']:
            identifier += c
        else:
            break
    rest = string[len(identifier):]
    if len(identifier) == 0:
        return None, string
    return identifier, rest

def lex_number(string):
    ron_number = ''

    number_characters = [str(d) for d in range(0, 10)] + ['-', 'e', '.']

    for c in string:
        if c in number_characters:
            ron_number += c
        else:
            break

    rest = string[len(ron_number):]

    if not len(ron_number):
        return None, string

    if '.' in ron_number:
        return float(ron_number), rest
    return int(ron_number), rest

def lex_string(string):
    ron_string = ''
  
    if string[0] == '"':
        string = string[1:]
    else:
        return None, string
  
    for c in string:
        if c == '"':
            return ron_string, string[len(ron_string)+1:]
        else:
            ron_string += c

def lex_null(string):
    if len(string) >= NULL_LEN and string[:NULL_LEN] == 'null':
        return True, string[NULL_LEN:]
    return None, string

def lex_bool(string):
    if len(string) >= TRUE_LEN and string[:TRUE_LEN] == 'true':
        return True, string[TRUE_LEN:]
    elif len(string) >= FALSE_LEN and string[:FALSE_LEN] == 'false':
        return False, string[FALSE_LEN:]
    return None, string

def parse_array(tokens):
    ron_array = []
    t = tokens[0]
    if t == RON_RIGHTBRACKET:
        return ron_array, tokens[1:]
    while True:
        ron, tokens = parse(tokens)
        ron_array.append(ron)

        t = tokens[0]
        if t == RON_RIGHTBRACKET:
            return ron_array, tokens[1:]
        elif t != RON_COMMA:
            raise Exception('Expected comma after object in array')
        else:
            tokens = tokens[1:]

def parse_object(tokens):
    ron_object = {}
    t = tokens[0]

    if t == RON_RIGHTBRACE:
        return ron_object, tokens[1:]

    while True:
        key_token = tokens[0]

        if isinstance(key_token, str):
            ron_key = key_token.strip('"')
            tokens = tokens[1:]
        else:
            raise Exception('Expected key of type string or identifier')

        if tokens[0] != RON_COLON:
            raise Exception('Expected colon ( : ) in object type dict')
        else:
            tokens = tokens[1:]

        ron_value, tokens = parse(tokens)
        ron_object[ron_key] = ron_value

        t = tokens[0]
        if t == RON_RIGHTBRACE:
            return ron_object, tokens[1:]
        elif t == RON_COMMA:
            tokens = tokens[1:]
        else:
            raise Exception('Expected comma or closing brace in object')

def parse(tokens):
    t = tokens[0]
    if t == '[':
        return parse_array(tokens[1:])
    elif t == '{':
        return parse_object(tokens[1:])
    else:
        return t,tokens[1:]


def loads(string):
    tokens = lex(string)
    result, remaining = parse(tokens)
    if remaining:
        raise Exception('Unexpected tokens after parsing')
    return result

def serialize_value(value):
    if isinstance(value, str):
        return f'"{value}"'
    elif isinstance(value, bool):
        return 'true' if value else 'false'
    elif isinstance(value, (int, float)):
        return str(value)
    elif isinstance(value, dict):
        lines = []
        for k, v in value.items():
            lines.append(f'{k} = {serialize_value(v)}')
        return '{ ' + ', '.join(lines) + ' }'
    else:
        return 'null'

def serialize_to_toml(obj):
    lines = []
    for key, value in obj.items():
        if isinstance(value, list):
            for item in value:
                lines.append(f'[[{key}]]')
                for k, v in item.items():
                    if isinstance(v, list):
                        for thing in v:
                            lines.append(f'[[{key}.{k}]]')
                            for l_k, l_v in thing.items():
                                lines.append(f'{l_k} = {serialize_value(l_v)}')
                    else:
                        lines.append(f'{k} = {serialize_value(v)}')
        else:
            lines.append(f'{key} = {serialize_value(value)}')
    return lines
if __name__ == "__main__":
    with open("schedule.ron", encoding="utf-8") as f:
        schedule = f.read()

    data = loads(schedule)
    print(data)
    lines = serialize_to_toml(data)
    toml_content = '\n'.join(lines)

    print(toml_content)
    with open('schedule.toml', 'w', encoding="utf-8") as file:
        file.write(toml_content)
