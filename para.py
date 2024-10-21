import sys

# Get the parameters passed from Jenkins
num1 = int(sys.argv[1])
num2 = int(sys.argv[2])

# Perform addition
result = num1 + num2

# Print the result
print(f"The sum of {num1} and {num2} is {result}")


python first.py %first% %second%
