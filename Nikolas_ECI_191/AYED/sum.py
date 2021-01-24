from sys import stdin

def rec(acum, i, choices):
    global data, answer
    if acum == 0:
        answer = choices
        return True
    elif acum < 0 or i >= len(data):
        return False
    else:
        temp_choices = choices[:]
        temp_choices[i] = 1
        ans = rec(acum - data[i], i + 1, temp_choices)
        ans = ans or rec(acum, i + 1, choices)
        return ans
    

def main():
    while True:
        line = stdin.readline().strip()
        if line == '':
            break
        line = [int(x) for x in line.split()]
        n = line[0]
        global data
        data = line[2:]
        ans = rec(n, 0, [0 for x in range(len(data))])
        if ans:
            print('Possible')
            print(answer)
        else:
            print('Impossible')
        

main()
