# Utilizando input do usuário

string_inicial = input('Digite uma string: ')

string_invertida = ''

for i in range(len(string_inicial)-1, -1, -1):
    string_invertida += string_inicial[i]

print(string_invertida)

# Utilizando string previamente definida

string_inicial = 'Hello World!'
string_invertida = ''

for i in range(len(string_inicial)-1, -1, -1):
    string_invertida += string_inicial[i]

print(string_invertida)