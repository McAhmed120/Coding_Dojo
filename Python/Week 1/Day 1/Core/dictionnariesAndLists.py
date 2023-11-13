x = [[5, 2, 3], [10, 8, 9]]
students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y': 20}]

# Change the value 10 in x to 15
x[1][0] = 15

# Change the last_name of the first student from 'Jordan' to 'Bryant'
students[0]['last_name'] = 'Bryant'

# In the sports_directory, change 'Messi' to 'Andres'
sports_directory['soccer'][0] = 'Andres'

# Change the value 20 in z to 30
z[0]['y'] = 30

# Iterate through a list of dictionaries
def iterateDictionary(some_list):
    for item in some_list:
        output = ""
        for key, value in item.items():
            output += f"{key} - {value}, "
        print(output[:-2])

# Get values from a list of dictionaries
def iterateDictionary2(key_name, some_list):
    for item in some_list:
        print(item[key_name])

# Iterate through a dictionary with list values
def printInfo(some_dict):
    for key, value in some_dict.items():
        print(f"{key} - {len(value)}")
        for item in value:
            print(item)

# Test cases
iterateDictionary(students)
print()
iterateDictionary2('first_name', students)
print()
iterateDictionary2('last_name', students)
print()
printInfo(sports_directory)
